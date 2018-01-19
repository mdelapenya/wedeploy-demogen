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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class WeDeployDemoTest {

	@Test
	public void testBuild() {
		WeDeployDemoBuilder builder = factory.getDemoBuilder("name");

		WeDeployDemo weDeployDemo = builder.build();

		Assert.assertEquals("name", weDeployDemo.getName());
		Assert.assertEquals(0, weDeployDemo.getServices().size());
	}

	@Test
	public void testBuildWithService() {
		WeDeployDemoBuilder builder = factory.getDemoBuilder("name");

		WeDeployServiceBuilder serviceBuilder1 = factory.getServiceBuilder(
			"service1");
		WeDeployServiceBuilder serviceBuilder2 = factory.getServiceBuilder(
			"service2");

		WeDeployDemo weDeployDemo = builder
			.withService(serviceBuilder1.build())
			.withService(serviceBuilder2.build())
			.build();

		Assert.assertEquals(2, weDeployDemo.getServices().size());
	}

	@Test
	public void testBuildWithServices() {
		WeDeployDemoBuilder builder = factory.getDemoBuilder("name");

		WeDeployServiceBuilder serviceBuilder1 = factory.getServiceBuilder(
			"service1");
		WeDeployServiceBuilder serviceBuilder2 = factory.getServiceBuilder(
			"service2");

		WeDeployDemo weDeployDemo = builder
			.withServices(serviceBuilder1.build(), serviceBuilder2.build())
			.build();

		Assert.assertEquals(2, weDeployDemo.getServices().size());
	}

	private static WeDeployEntityFactory factory =
		WeDeployEntityFactory.getInstance();

}