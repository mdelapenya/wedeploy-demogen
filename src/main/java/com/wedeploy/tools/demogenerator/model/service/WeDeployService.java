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

package com.wedeploy.tools.demogenerator.model.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wedeploy.tools.demogenerator.model.healtcheck.HealthCheck;

import java.util.Map;
import java.util.Optional;

/**
 * @author Manuel de la Peña
 */
public interface WeDeployService {

	@JsonInclude(Include.NON_NULL)
	Optional<Integer> getCpu();

	@JsonInclude(Include.NON_NULL)
	Optional<String[]> getCustomDomains();

	@JsonInclude(Include.NON_NULL)
	Optional<String[]> getDependencies();

	@JsonInclude(Include.NON_NULL)
	Optional<Map<String, String>> getEnv();

	@JsonInclude(Include.NON_NULL)
	Optional<HealthCheck> getHealthCheck();

	String getId();

	@JsonInclude(Include.NON_NULL)
	Optional<String> getImage();

	@JsonInclude(Include.NON_NULL)
	Optional<Integer> getMemory();

	@JsonInclude(Include.NON_NULL)
	Optional<Integer> getPort();

	@JsonInclude(Include.NON_NULL)
	Optional<Integer> getScale();

	@JsonInclude(Include.NON_NULL)
	Optional<String> getVolume();

	@JsonInclude(Include.NON_NULL)
	Boolean isZeroDowntime();

}