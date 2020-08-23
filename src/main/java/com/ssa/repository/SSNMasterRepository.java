package com.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssa.entity.SSNEnrollmentEntity;

public interface SSNMasterRepository extends JpaRepository<SSNEnrollmentEntity, Serializable> {

	public SSNEnrollmentEntity findByStateAndSsnNumber(String stateName,Long ssnNumber);
}
