package com.ssn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.model.SSNEnrollementRequest;
import com.ssn.service.SSNService;

@RestController
@CrossOrigin
public class SSNRestController {
	private static final Logger LOGGER=LoggerFactory.getLogger(SSNRestController.class);
	
	@Autowired
	private SSNService ssnService;
	
	@GetMapping("/hellomessage")
	public String dispalyMessage(String message)
	{
		message="Hello Welcome to IT Industry";
		return message;
	}
	
	@GetMapping("/getAllStates")
	public ResponseEntity<Object> getAllStates()
	{
		try
		{
		List<String> states= ssnService.getAllStates();
		if(states!=null)
		{
			LOGGER.debug("Displaying List Of States"+states);
		return new ResponseEntity<Object>(states,HttpStatus.OK);
		}
		LOGGER.debug("States List Is Empty");
		return new ResponseEntity<Object>("No Data Found",HttpStatus.NOT_FOUND);
	}catch(Exception e)
	{
		LOGGER.debug("Error While Retriving List Of States");
	return new ResponseEntity<Object>("Something Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	}
	@PostMapping("/enrollment")
	public ResponseEntity<Object> ssnEnrollment(@RequestBody SSNEnrollementRequest ssnEnroll)
	{
		try
		{
			ssnService.ssnEnrollment(ssnEnroll);
			if(ssnEnroll!=null)
			{
				LOGGER.debug("Enrollment Successfull"+ssnEnroll);
				return new ResponseEntity<Object>(ssnEnroll,HttpStatus.CREATED);
			}
			LOGGER.debug("Enrollment Failed");
			return new ResponseEntity<Object>(ssnEnroll,HttpStatus.NO_CONTENT);
		}catch(Exception e)
		{
			LOGGER.debug("Something Went Wrong While Enrollment");
		return new ResponseEntity<Object>(ssnEnroll,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@GetMapping("/validate/{ssn}/{state}")
	public ResponseEntity<String> validateSSN(@PathVariable long ssn,@PathVariable String state)
	{
		try
		{
		String response=ssnService.checkEnrollment(ssn,state);
		
			LOGGER.debug("SSN Verified"+response);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	    }catch(Exception e)
		{
	    LOGGER.debug("Something Went Wrong While Verifaction");
		return new ResponseEntity<String>("Something Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
}
