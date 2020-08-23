package com.ssa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssa.entity.SSNStatesEntity;

public interface SSNStatesRepository  extends JpaRepository<SSNStatesEntity, Serializable>{

	@Query(value = "select stateName from SSNStatesEntity")
	public List<String> findStateName();
}
