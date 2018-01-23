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

package com.wedeploy.tools.demogenerator.model.template;

import com.wedeploy.tools.demogenerator.model.WeDeployEntityFactory;
import com.wedeploy.tools.demogenerator.model.service.WeDeployService;
import com.wedeploy.tools.demogenerator.model.service.WeDeployServiceBuilder;

/**
 * @author Manuel de la Peña
 */
public class TemplateBuilder {

	public static WeDeployService buildLiferayTemplate(String id) {
		WeDeployEntityFactory weDeployEntityFactory =
			WeDeployEntityFactory.getInstance();

		WeDeployServiceBuilder serviceBuilder =
			weDeployEntityFactory.getServiceBuilder(id)
				.withCpu(3)
				.withImage("wedeploy/liferay:dxp-sp6-20180123")
				.withMemory(4096);

		return serviceBuilder.build();
	}

}