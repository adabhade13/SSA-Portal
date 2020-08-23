package com.ssa.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.domain.SSNEnrollment;
import com.ssa.entity.SSNEnrollmentEntity;
import com.ssa.exception.NoSSNNumberFoundexception;
import com.ssa.exception.SSNInformationNotFount;
import com.ssa.repository.SSNMasterRepository;
import com.ssa.repository.SSNStatesRepository;

@Service
public class SSNServiceImpl implements SSNService {
	
	@Autowired
	private SSNMasterRepository ssnInfoRepo;
	
	@Autowired
	private SSNStatesRepository ssnStateRepo;

	@Override
	public Long saveSSNEnrollment(SSNEnrollment ssnInfo) {
		SSNEnrollmentEntity entity = new SSNEnrollmentEntity();
		BeanUtils.copyProperties(ssnInfo, entity);
		SSNEnrollmentEntity info = ssnInfoRepo.save(entity);
	   if(info !=null) {
		   return info.getSsnNumber();
	   }
		throw new SSNInformationNotFount("Enable to process request..!");
	}

	@Override
	public List<String> getAllStates() {
		return ssnStateRepo.findStateName();
	}

	@Override
	public String varifySSN(String stateName, Long ssnNo) {
		SSNEnrollmentEntity entity = ssnInfoRepo.findByStateAndSsnNumber(stateName, ssnNo);
		if(entity != null) {
			return "VALID";
		}
		return "IN-VALID";
		//throw new NoSSNNumberFoundexception("IN-Valid SSN Number");
	}

	

}
