package com.ssn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="SSN_Master")
@Data
public class SSNMasterEntity {
	
	@Id
	@GeneratedValue
	@Column(name="SSN_Number")
	private long ssn;

	@Column(name = "First_Name")
	private String fname;

	@Column(name = "Last_Name")
	private String lname;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "DOB")
	private Date dob;
	
	@Column(name="State_Name")
	private String stateName;
	
	@Column(name="Created_Date",updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="Updated_Date",insertable=false)
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Override
	public String toString() {
		return "SSNMasterEntity [ssn=" + ssn + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", dob="
				+ dob + ", stateName=" + stateName + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	
}
