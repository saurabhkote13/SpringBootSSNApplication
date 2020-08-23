package com.ssn.service;

import java.util.List;
import com.ssn.model.SSNEnrollementRequest;

public interface SSNService {

	public List<String> getAllStates();
	public long ssnEnrollment(SSNEnrollementRequest req);
	public String checkEnrollment(Long ssn,String statename);
}
