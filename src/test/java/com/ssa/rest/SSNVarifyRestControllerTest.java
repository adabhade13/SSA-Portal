package com.ssa.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ssa.controller.SSNVarifyRestController;
import com.ssa.services.SSNService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = SSNVarifyRestController.class)
public class SSNVarifyRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SSNService service;
	
	@Test
	@Ignore
	public void varifySSNTest() throws Exception {
		
		when(service.varifySSN("NJ", 101L)).thenReturn("IN-VALID");
		
		      MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/checkSSN/101/NJ");
		      
		       MvcResult andReturn = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		       
		         MockHttpServletResponse response = andReturn.getResponse();
		         
		         String contentAsString = response.getContentAsString();
		         
		         System.out.println("**** Responce For API **** "+contentAsString);
		         
		         assertEquals("IN-VALID", contentAsString);
	}
}
