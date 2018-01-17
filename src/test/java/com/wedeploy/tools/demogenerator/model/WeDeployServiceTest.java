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

package com.wedeploy.tools.demogenerator.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manuel de la Peña
 */
public class WeDeployServiceTest {

	@Test
	public void testBuild() {
		String id = "service";

		WeDeployServiceBuilder builder = factory.getServiceBuilder(id);

		builder.withCpu(3);
		builder.withCustomDomains("foo.com", "bar.es");
		builder.withDependencies("service1", "service2", "service3");

		Map<String, String> env = new HashMap<>();

		env.put("KEY1", "VALUE1");
		env.put("KEY2", "VALUE2");

		builder.withEnv(env);

		builder.withImage("image");
		builder.withMemory(4096);
		builder.withPort(8081);
		builder.withScale(10);
		builder.withVolume("/tmp/foo");
		builder.withZeroDowntime();

		WeDeployService service = builder.build();

		Assert.assertEquals(3, service.getCpu().get().intValue());
		Assert.assertArrayEquals(
			new String[] {"foo.com", "bar.es"},
			service.getCustomDomains().get());
		Assert.assertArrayEquals(
			new String[] {"service1", "service2", "service3"},
			service.getDependencies().get());
		assertThat(env, is(service.getEnv().get()));
		Assert.assertEquals(id, service.getId());
		Assert.assertEquals("image", service.getImage().get());
		Assert.assertEquals(4096, service.getMemory().get().intValue());
		Assert.assertEquals(8081, service.getPort().get().intValue());
		Assert.assertEquals(10, service.getScale().get().intValue());
		Assert.assertEquals("/tmp/foo", service.getVolume().get());
		Assert.assertTrue(service.isZeroDowntime());
	}

	@Test
	public void testBuildWithCommandHealthCheck() {
		String id = "service";

		WeDeployServiceBuilder builder = factory.getServiceBuilder(id);

		builder.withHealthCheck(
			new CommandHealthCheck(
				"curl -X GET --silent --fail 'localhost/blog/'"));

		WeDeployService service = builder.build();

		HealthCheck healthCheck = service.getHealthCheck().get();

		Assert.assertEquals("command", healthCheck.getHealthCheckKey());
		Assert.assertEquals(
			"curl -X GET --silent --fail 'localhost/blog/'",
			healthCheck.getHealthCheckValue());
	}

	@Test
	public void testBuildWithUrlHealthCheck() {
		String id = "service";

		WeDeployServiceBuilder builder = factory.getServiceBuilder(id);

		builder.withHealthCheck(new UrlHealthCheck("localhost/blog/"));

		WeDeployService service = builder.build();

		HealthCheck healthCheck = service.getHealthCheck().get();

		Assert.assertEquals("url", healthCheck.getHealthCheckKey());
		Assert.assertEquals(
			"localhost/blog/", healthCheck.getHealthCheckValue());
	}

	private static WeDeployEntityFactory factory =
		WeDeployEntityFactory.getInstance();

}