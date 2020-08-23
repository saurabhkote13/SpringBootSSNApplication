package com.ssn.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ssn.entity.StatesMasterEntity;

@Repository
public interface StatesMasterRepository extends JpaRepository<StatesMasterEntity,Serializable> {
	
	@Query(value="select State_Name from States_Master",nativeQuery=true)
	List<String> findStatesNames();

}
