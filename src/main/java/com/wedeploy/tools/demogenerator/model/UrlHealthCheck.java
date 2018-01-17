package com.wedeploy.tools.demogenerator.model;
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

/**
 * @author Manuel de la Peña
 */
public class UrlHealthCheck implements HealthCheck {

	public UrlHealthCheck(String url) {
		_url = url;
	}

	@Override
	public String getHealthCheckKey() {
		return "url";
	}

	@Override
	public String getHealthCheckValue() {
		return _url;
	}

	private String _url;

}
