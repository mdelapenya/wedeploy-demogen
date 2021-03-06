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

import com.wedeploy.tools.demogenerator.model.healtcheck.HealthCheck;
import com.wedeploy.tools.demogenerator.model.service.WeDeployService;
import com.wedeploy.tools.demogenerator.model.service.WeDeployServiceBuilder;

import java.util.Map;
import java.util.Optional;

/**
 * @author Manuel de la Peña
 */
public class WeDeployServiceImpl implements WeDeployService {

	@Override
	public Optional<Integer> getCpu() {
		return _cpu;
	}

	@Override
	public Optional<String[]> getCustomDomains() {
		return _customDomains;
	}

	@Override
	public Optional<String[]> getDependencies() {
		return _dependencies;
	}

	@Override
	public Optional<Map<String, String>> getEnv() {
		return _env;
	}

	@Override
	public Optional<HealthCheck> getHealthCheck() {
		return _healthCheck;
	}

	@Override
	public String getId() {
		return _id;
	}

	@Override
	public Optional<String> getImage() {
		return _image;
	}

	@Override
	public Optional<Integer> getMemory() {
		return _memory;
	}

	@Override
	public Optional<Integer> getPort() {
		return _port;
	}

	@Override
	public Optional<Integer> getScale() {
		return _scale;
	}

	@Override
	public Optional<String> getVolume() {
		return _volume;
	}

	@Override
	public Boolean isZeroDowntime() {
		return _zeroDowntime;
	}

	public static class Builder implements WeDeployServiceBuilder {

		public Builder(String id) {
			_weDeployDescriptor = new WeDeployServiceImpl();

			_weDeployDescriptor._id = id;
		}

		@Override
		public WeDeployService build() {
			WeDeployService weDeployService = _weDeployDescriptor; 

			_weDeployDescriptor = new WeDeployServiceImpl();

			return weDeployService;
		}

		@Override
		public Builder withCpu(int cpu) {
			_weDeployDescriptor._cpu = Optional.of(cpu);

			return this;
		}

		@Override
		public Builder withCustomDomains(String... customDomains) {
			_weDeployDescriptor._customDomains = Optional.of(customDomains);

			return this;
		}

		@Override
		public Builder withDependencies(String... dependencies) {
			_weDeployDescriptor._dependencies = Optional.of(dependencies);

			return this;
		}

		@Override
		public Builder withEnv(Map<String, String> env) {
			_weDeployDescriptor._env = Optional.of(env);

			return this;
		}

		@Override
		public Builder withHealthCheck(HealthCheck healthCheck) {
			_weDeployDescriptor._healthCheck = Optional.of(healthCheck);

			return this;
		}

		@Override
		public Builder withImage(String image) {
			_weDeployDescriptor._image = Optional.of(image);

			return this;
		}

		@Override
		public Builder withMemory(int memory) {
			_weDeployDescriptor._memory = Optional.of(memory);

			return this;
		}

		@Override
		public Builder withPort(int port) {
			_weDeployDescriptor._port = Optional.of(port);

			return this;
		}

		@Override
		public Builder withScale(int scale) {
			_weDeployDescriptor._scale = Optional.of(scale);

			return this;
		}

		@Override
		public Builder withVolume(String volume) {
			_weDeployDescriptor._volume = Optional.of(volume);

			return this;
		}

		@Override
		public Builder withZeroDowntime() {
			_weDeployDescriptor._zeroDowntime = true;

			return this;
		}

		private WeDeployServiceImpl _weDeployDescriptor;

	}

	private WeDeployServiceImpl() {
	}

	private Optional<Integer> _cpu;
	private Optional<String[]> _customDomains;
	private Optional<String[]> _dependencies;
	private Optional<Map<String, String>> _env;
	private Optional<HealthCheck> _healthCheck;
	private String _id;
	private Optional<String> _image;
	private Optional<Integer> _memory;
	private Optional<Integer> _port;
	private Optional<Integer> _scale;
	private Optional<String> _volume;
	private Boolean _zeroDowntime;

}