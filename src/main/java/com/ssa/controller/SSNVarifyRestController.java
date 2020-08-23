package com.ssa.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.services.SSNService;

@RestController
public class SSNVarifyRestController {
	
	@Autowired
	private SSNService service;
	
	@GetMapping(value = "/checkSSN/{ssn}/{stateName}")
	public ResponseEntity<String> checkSSNEnrollment(@PathVariable("ssn") String ssn,@PathVariable("stateName")String stateName
			                                         ){
		
		ResponseEntity<String> responce = null;
		     String body = service.varifySSN(stateName, Long.parseLong(ssn));
		responce = new ResponseEntity<String>(body,HttpStatus.OK);
		return responce;
	}

}
