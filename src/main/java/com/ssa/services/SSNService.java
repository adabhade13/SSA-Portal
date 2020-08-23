package com.ssa.services;

import java.util.List;

import com.ssa.domain.SSNEnrollment;

public interface SSNService {
	
	public Long saveSSNEnrollment(SSNEnrollment pinfo);
	
	
	public List<String> getAllStates();
	
	
	public String varifySSN(String stateName , Long ssnNo);
	
	
	
	

}
