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

package com.wedeploy.tools.demogenerator.model.healtcheck;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author Manuel de la Peña
 */
public class HealthCheckSerializer extends StdSerializer<HealthCheck> {

	public HealthCheckSerializer() {
		this(null);
	}

	public HealthCheckSerializer(Class<HealthCheck> t) {
		super(t);
	}

	@Override
	public void serialize(
			HealthCheck value, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
		throws IOException {

		jsonGenerator.writeStartObject();

		jsonGenerator.writeStringField(
			value.getHealthCheckKey(), value.getHealthCheckValue());

		jsonGenerator.writeEndObject();
	}

}