package com.ssa.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssa.controller.SSNEnrollmentRestController;
import com.ssa.domain.SSNEnrollment;
import com.ssa.services.SSNService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SSNEnrollmentRestController.class)
public class SSNEnrollmentRestControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private SSNService service;
	
	@Test
	public void ssnEnrollmentTest() throws Exception {
		
		when(service.saveSSNEnrollment(Mockito.any(SSNEnrollment.class))).thenReturn(192939094L);
		
		SSNEnrollment ssn = new SSNEnrollment();
		ssn.setFirstname("Test01");
		ssn.setLastname("Test02");
		ssn.setGender("M");
		ssn.setDob(new Date());
		ssn.setState("NJ");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonObj = objectMapper.writeValueAsString(ssn);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveSSL")
		                      .contentType(MediaType.APPLICATION_JSON)
		                      .content(jsonObj);
		
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
		
		System.out.println(" ******API Response is***** ::"+mvcResult.getResponse().getContentAsString());
		
		   int status = mvcResult.getResponse().getStatus();
		   
		   
		   assertEquals(201, status);
	}
	
	
	
	
	
}
