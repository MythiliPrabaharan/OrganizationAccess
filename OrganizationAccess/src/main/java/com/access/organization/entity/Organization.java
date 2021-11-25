package com.access.organization.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "ORGANIZATION")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
public class Organization 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;

	private String departmentName;
	
	private String departmentLocation;

	private static final String orgName = "ABC Technologies";

	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
	
	public Organization(){
	}
	
	public Organization(String departmentName, String departmentLocation) 
	{
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static String getOrgname() {
		return orgName;
	}

	@Override
	public String toString() {
		return "Organization [departmentId=" + departmentId + ", departmentName=" + departmentName + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", orgName=" + orgName  + "]";
	}	
}