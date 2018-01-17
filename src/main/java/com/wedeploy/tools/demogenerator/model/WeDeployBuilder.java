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
public interface WeDeployBuilder {

	WeDeployService build();

	WeDeployBuilder withCpu(int cpu);

	WeDeployBuilder withCustomDomains(String... customDomains);

	WeDeployBuilder withDependencies(String... dependencies);

	WeDeployBuilder withEnv(Map<String, String> env);

	WeDeployBuilder withHealthCheck(HealthCheck healthCheck);

	WeDeployBuilder withImage(String image);

	WeDeployBuilder withMemory(int memory);

	WeDeployBuilder withPort(int port);

	WeDeployBuilder withScale(int scale);

	WeDeployBuilder withVolume(String volume);

	WeDeployBuilder withZeroDowntime();

}
