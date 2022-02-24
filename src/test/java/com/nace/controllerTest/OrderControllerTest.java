package com.nace.controllerTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nace.NaceModuleApplication;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NaceModuleApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void verifyOrderById() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/dbclm/nace/getDetails/byid?id=1").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.orderid").exists()).andExpect(jsonPath("$.level").exists())
				.andExpect(jsonPath("$.code").exists()).andExpect(jsonPath("$.parent").exists())
				.andExpect(jsonPath("$.description").exists()).andExpect(jsonPath("$.includes").exists())
				.andExpect(jsonPath("$.addons").exists()).andExpect(jsonPath("$.rulings").exists())
				.andExpect(jsonPath("$.excludes").exists()).andExpect(jsonPath("$.isicref").exists())
				.andExpect(jsonPath("$.orderid").value(1)).andExpect(jsonPath("$.level").value(22222))
				.andExpect(jsonPath("$.code").value("xyz")).andExpect(jsonPath("$.parent").value("xyz"))
				.andExpect(jsonPath("$.description").value("xyz")).andExpect(jsonPath("$.includes").value("xyz"))
				.andExpect(jsonPath("$.addons").value("xyz")).andExpect(jsonPath("$.rulings").value("xyz"))
				.andExpect(jsonPath("$.excludes").value("xyz")).andExpect(jsonPath("$.isicref").value("xyz"))
				.andDo(print());
	}

	@Test
	public void shouldSaveOrder() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/dbclm/nace/addDetails")
				.contentType(MediaType.APPLICATION_JSON)
				.content(
						"{\"orderid\":1,\"level\": 22222,\"includes\" : \"xyz\",\"code\" : \"xyz\",\"parent\" : \"xyz\",\"description\" : \"xyz\",\"addons\" : \"xyz\",\"rulings\" : \"xyz\",\"excludes\" : \"xyz\",\"isicref\" : \"xyz\"}")
				.accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.*").value("ORDER has been saved successfully!")).andReturn();

	}

}
