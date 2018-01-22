/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.wedeploy.tools.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import com.wedeploy.tools.demogenerator.model.WeDeployEntityFactory;
import com.wedeploy.tools.demogenerator.model.healtcheck.CommandHealthCheck;
import com.wedeploy.tools.demogenerator.model.healtcheck.UrlHealthCheck;
import com.wedeploy.tools.demogenerator.model.service.WeDeployService;
import com.wedeploy.tools.demogenerator.model.service.WeDeployServiceBuilder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to WeDeploy Service generator!";
    }

    @RequestMapping("/services/{id}")
    public @ResponseBody WeDeployService getService(
        @PathVariable("id") String id,
        @RequestParam("cpu") Optional<Integer> cpu,
        @RequestParam("customDomains") Optional<String> customDomains,
        @RequestParam("dependencies") Optional<String> dependencies,
        @RequestParam("env") Optional<String> env,
        @RequestParam("image") Optional<String> image,
        @RequestParam("healthCheck") Optional<String> healthCheck,
        @RequestParam("memory") Optional<Integer> memory,
        @RequestParam("port") Optional<Integer> port,
        @RequestParam("scale") Optional<Integer> scale,
        @RequestParam("volume") Optional<String> volume,
        @RequestParam("zeroDowntime") Optional<Boolean> zeroDowntime) {

		ObjectMapper mapper = new ObjectMapper();

		mapper.registerModule(new Jdk8Module());

		WeDeployServiceBuilder serviceBuilder =
			WeDeployEntityFactory.getInstance().getServiceBuilder(id);

		if (cpu.isPresent()) {
			serviceBuilder.withCpu(cpu.get());
        }

        if (customDomains.isPresent()) {
			String customDomainParam = customDomains.get();

			serviceBuilder.withCustomDomains(customDomainParam.split(","));
        }

        if (dependencies.isPresent()) {
			String dependenciesParam = dependencies.get();

			serviceBuilder.withDependencies(dependenciesParam.split(","));
        }

		if (env.isPresent()) {
			String envParam = env.get();

			String[] variables = envParam.split(",");

			Map<String, String> environment = new HashMap<>();

			for (String variable : variables) {
				int index = variable.indexOf("=");

				String key = variable.substring(0, index);
				String value = variable.substring(index + 1);

				environment.put(key, value);
			}

			serviceBuilder.withEnv(environment);
		}

        if (image.isPresent()) {
			serviceBuilder.withImage(image.get());
        }

		if (healthCheck.isPresent()) {
			String healthCheckParam = healthCheck.get();

			if (healthCheckParam.contains(":")) {
				String[] variable = healthCheckParam.split(":");

				if (variable.length == 2) {
					if ("url".equals(variable[0])) {
						serviceBuilder.withHealthCheck(
							new UrlHealthCheck(variable[1]));
					}
					else if ("command".equals(variable[0])) {
						serviceBuilder.withHealthCheck(
							new CommandHealthCheck(variable[1]));
					}
					else {
						// discard health check
					}
				}
			}
		}

        if (memory.isPresent()) {
			serviceBuilder.withMemory(memory.get());
        }

        if (port.isPresent()) {
			serviceBuilder.withPort(port.get());
        }

        if (scale.isPresent()) {
			serviceBuilder.withScale(scale.get());
        }

        if (volume.isPresent()) {
			serviceBuilder.withVolume(volume.get());
        }

        if (zeroDowntime.isPresent()) {
			if (zeroDowntime.get()) {
				serviceBuilder.withZeroDowntime();
			}
        }

		return serviceBuilder.build();
    }

}