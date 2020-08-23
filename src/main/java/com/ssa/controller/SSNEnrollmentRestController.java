package com.ssa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.domain.SSNEnrollment;
import com.ssa.services.SSNService;

@RestController
public class SSNEnrollmentRestController {
	
	@Autowired
	private SSNService ssaService;
	
	
	@PostMapping(value = "/saveSSL",
			       consumes = {
			    		   "application/json",
			    		   "application/xml"
			       })
	public ResponseEntity<String> saveSSN(@RequestBody SSNEnrollment ssnEnroll){
         ResponseEntity<String> response= null;
         String body = null;
		  Long ssnNumber = ssaService.saveSSNEnrollment(ssnEnroll);
			if(ssnNumber != null) {
				body = " Your Enrollment Completed Successfully."
						+ "Below is your SSN "+ssnNumber;
			}else {
				body = "Enrollment Failed";
			}
		 response = new ResponseEntity<String>(body, HttpStatus.CREATED);
		 return response;
	}
	
	

}
