package com.ssn.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.entity.SSNMasterEntity;
import com.ssn.model.SSNEnrollementRequest;
import com.ssn.repository.SSNMasterRepository;
import com.ssn.repository.StatesMasterRepository;

@Service
public class SSNServiceImpl implements SSNService{
	
	@Autowired
	private StatesMasterRepository statesrepo;
	
	@Autowired
	private SSNMasterRepository ssnrepo;

	@Override
	public List<String> getAllStates() {
		// TODO Auto-generated method stub
		return statesrepo.findStatesNames();
	}

	@Override
	public long ssnEnrollment(SSNEnrollementRequest req) {
		// TODO Auto-generated method stub
		SSNMasterEntity entity=new SSNMasterEntity();
		BeanUtils.copyProperties(req,entity);
		SSNMasterEntity savedEntity=ssnrepo.save(entity);
		if(savedEntity!=null)
		{
			return savedEntity.getSsn();
		}
		return 0 ;
	}

	@Override
	public String checkEnrollment(Long ssn, String statename) {
		// TODO Auto-generated method stub
		SSNMasterEntity entity=ssnrepo.findBySsnAndStateName(ssn, statename);
			if(entity!=null)
			{
				return "Valid";
			}
			return "In-Valid";
	}

}
