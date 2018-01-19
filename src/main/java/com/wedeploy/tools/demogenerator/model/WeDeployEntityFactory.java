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

import com.wedeploy.tools.demogenerator.model.demo.WeDeployDemoBuilder;
import com.wedeploy.tools.demogenerator.model.internal.WeDeployDemoImpl;
import com.wedeploy.tools.demogenerator.model.internal.WeDeployServiceImpl;
import com.wedeploy.tools.demogenerator.model.service.WeDeployServiceBuilder;

/**
 * @author Manuel de la Peña
 */
public final class WeDeployEntityFactory {

	public static final WeDeployEntityFactory getInstance() {
		return instance;
	}

	public WeDeployDemoBuilder getDemoBuilder(String demoName) {
		return new WeDeployDemoImpl.Builder(demoName);
	}

	public WeDeployServiceBuilder getServiceBuilder(String id) {
		return new WeDeployServiceImpl.Builder(id);
	}

	private static final WeDeployEntityFactory instance =
		new WeDeployEntityFactory();

}