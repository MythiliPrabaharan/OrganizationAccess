package com.access.organization.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends Organization
{
	private Long empId;
	
	private String empName;
	private String empBaseLocation;
	private String empDesignation;
	
	
	public Employee() {
	}
	
	public Employee(Long empId, String departmentName, String departmentLocation
			, String empName, String empBaseLocation, String empDesignation) 
	{
		super(departmentName, departmentLocation);
		this.empId = empId;
		this.empName = empName;
		this.empBaseLocation = empBaseLocation;
		this.empDesignation = empDesignation;
	}

	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpBaseLocation() {
		return empBaseLocation;
	}
	public void setEmpBaseLocation(String empBaseLocation) {
		this.empBaseLocation = empBaseLocation;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
}
