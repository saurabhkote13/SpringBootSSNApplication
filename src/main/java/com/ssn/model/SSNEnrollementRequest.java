package com.ssn.model;

import java.util.Date;

import lombok.Data;

@Data
public class SSNEnrollementRequest {
	
	private String fname;
	private String lname;
	private Date dob;
	private String gender;
	private String stateName;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "SSNEnrollementRequest [fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", gender=" + gender
				+ ", stateName=" + stateName + "]";
	}
	
}
