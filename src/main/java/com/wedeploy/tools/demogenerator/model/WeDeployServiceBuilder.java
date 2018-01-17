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

import java.util.Map;

/**
 * @author Manuel de la Peña
 */
public interface WeDeployServiceBuilder
	extends WeDeployBuilder<WeDeployService> {

	WeDeployServiceBuilder withCpu(int cpu);

	WeDeployServiceBuilder withCustomDomains(String... customDomains);

	WeDeployServiceBuilder withDependencies(String... dependencies);

	WeDeployServiceBuilder withEnv(Map<String, String> env);

	WeDeployServiceBuilder withHealthCheck(HealthCheck healthCheck);

	WeDeployServiceBuilder withImage(String image);

	WeDeployServiceBuilder withMemory(int memory);

	WeDeployServiceBuilder withPort(int port);

	WeDeployServiceBuilder withScale(int scale);

	WeDeployServiceBuilder withVolume(String volume);

	WeDeployServiceBuilder withZeroDowntime();

}
