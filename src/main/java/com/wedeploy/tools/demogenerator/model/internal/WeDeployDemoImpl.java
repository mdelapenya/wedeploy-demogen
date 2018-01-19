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

package com.wedeploy.tools.demogenerator.model.internal;

import com.wedeploy.tools.demogenerator.model.WeDeployDemo;
import com.wedeploy.tools.demogenerator.model.WeDeployDemoBuilder;
import com.wedeploy.tools.demogenerator.model.WeDeployService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

/**
 * @author Manuel de la Peña
 */
public class WeDeployDemoImpl implements WeDeployDemo {

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public List<WeDeployService> getServices() {
		return _services;
	}

	public static class Builder implements WeDeployDemoBuilder {

		public Builder(String name) {
			_weDeployDemo = new WeDeployDemoImpl();

			_weDeployDemo._name = name;
		}

		@Override
		public WeDeployDemo build() {
			WeDeployDemo weDeployDemo = _weDeployDemo;

			_weDeployDemo = new WeDeployDemoImpl();

			return weDeployDemo;
		}

		@Override
		public Builder withService(WeDeployService weDeployService) {
			List<WeDeployService> services = _weDeployDemo.getServices();

			services.add(weDeployService);

			return this;
		}

		@Override
		public Builder withServices(WeDeployService... weDeployService) {
			Stream<WeDeployService> serviceStream = Arrays.stream(
				weDeployService);

			serviceStream.forEach(service -> withService(service));

			return this;
		}

		private String _name; 
		private WeDeployDemoImpl _weDeployDemo;

	}

	private WeDeployDemoImpl() {
	}

	private String _name;
	private List<WeDeployService> _services = new CopyOnWriteArrayList<>();

}