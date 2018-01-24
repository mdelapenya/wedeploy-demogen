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

package com.wedeploy.tools.controller;

import static org.hamcrest.Matchers.equalTo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Manuel de la Peña
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(
				content().string(
					equalTo("Welcome to WeDeploy Service generator!"))
			);
	}

	@Test
	public void getServiceWithId() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get("/services/mdelapenya")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'id': 'mdelapenya'}"));
	}

	@Test
	public void getServiceWithCommandHealthCheck() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get(
				"/services/mdelapenya?healthCheck=command:rm -rf /")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(
				"{'id': 'mdelapenya', 'healthCheck': {'command': 'rm -rf /'}}"
			));
	}

	@Test
	public void getServiceWithCommandHealthCheckEmpty() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get(
				"/services/mdelapenya?healthCheck=command:")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'id': 'mdelapenya'}"));
	}

	@Test
	public void getServiceWithCommandHealthCheckIncomplete() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get(
				"/services/mdelapenya?healthCheck=command")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'id': 'mdelapenya'}"));
	}

	@Test
	public void getServiceWithUrlHealthCheck() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get(
				"/services/mdelapenya?healthCheck=url:localhost")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(
				"{'id': 'mdelapenya', 'healthCheck': {'url': 'localhost'}}"
			));
	}

	@Test
	public void getServiceWithUrlHealthCheckEmpty() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get("/services/mdelapenya?healthCheck=url:")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'id': 'mdelapenya'}"));
	}

	@Test
	public void getServiceWithUrlHealthCheckIncomplete() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get("/services/mdelapenya?healthCheck=url")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(
				"{'id': 'mdelapenya'}"
			));
	}

	@Test
	public void getServiceWithZeroDowntime() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get("/services/mdelapenya?zeroDowntime=1")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(
				"{'id': 'mdelapenya', 'zeroDowntime': true}")
			);
	}

	@Test
	public void getServiceWithZeroDowntimeFalse() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get("/services/mdelapenya?zeroDowntime=0")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'id': 'mdelapenya'}"));
	}

	@Test
	public void getTemplateLiferay() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get("/templates/liferay/my-service")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'id': 'my-service'}"))
			.andExpect(content().json("{'cpu': 3}"))
			.andExpect(content().json("{'memory': 4096}"))
			.andExpect(
				content().json(
					"{'image': 'wedeploy/liferay:dxp-sp6-20180123'}"));
	}

	@Test
	public void getTemplateMySQL() throws Exception {
		mvc.perform(
			MockMvcRequestBuilders.get("/templates/mysql/my-service")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'id': 'my-service'}"))
			.andExpect(content().json("{'volume': '/var/lib/mysql'}"))
			.andExpect(
				content().json(
					"{'env': {" +
							"'MYSQL_USER': 'root', " +
							"'MYSQL_ROOT_PASSWORD': 'Passw0rd'" +
						"}" +
					"}"))
			.andExpect(content().json("{'image': 'mysql:5.7'}"));
	}

}