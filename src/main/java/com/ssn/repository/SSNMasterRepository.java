package com.ssn.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssn.entity.SSNMasterEntity;

@Repository
public interface SSNMasterRepository extends JpaRepository<SSNMasterEntity,Serializable> {
	public SSNMasterEntity findBySsnAndStateName(long ssn,String stateName);

}
