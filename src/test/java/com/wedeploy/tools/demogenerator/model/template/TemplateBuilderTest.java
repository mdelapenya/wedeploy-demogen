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

import com.wedeploy.tools.demogenerator.model.service.WeDeployService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class TemplateBuilderTest {

	@Test
	public void testBuildLiferayTemplate() {
		WeDeployService liferayTemplate =
			TemplateBuilder.buildLiferayTemplate("liferay");

		Assert.assertEquals(
			"wedeploy/liferay:dxp-sp6-20180123",
			liferayTemplate.getImage().get());
		Assert.assertEquals(new Integer(3), liferayTemplate.getCpu().get());
		Assert.assertEquals(
			new Integer(4096), liferayTemplate.getMemory().get());
	}

}