package com.ssn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="States_Master")
@Data
public class StatesMasterEntity {
	@Id
	@Column(name="State_Id")
	private Integer stateId;
	
	@Column(name="State_Name")
	private String stateName;

}
