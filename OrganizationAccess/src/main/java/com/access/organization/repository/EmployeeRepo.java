package com.access.organization.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.access.organization.entity.Employee;



@Repository
public interface EmployeeRepo extends OrganizationRepo 
{
	@Query("SELECT NEW com.access.organization.entity.Employee(e.empId, e.departmentName, e.departmentLocation, e.empName, e.empBaseLocation, e.empDesignation) "
			+ "FROM Employee e")
	public List<Employee> findAllEmployee();


	@Query("SELECT NEW com.access.organization.entity.Employee(e.empId, e.departmentName, e.departmentLocation, e.empName, e.empBaseLocation, e.empDesignation)"
			+ " FROM Employee e where e.empId = ?1")
	public Employee findEmployeeById(Long id);

	@Query("SELECT e.empId FROM Employee e where e.empId = ?1")
	public Object employeeExits(Long id);

	@Transactional
	@Modifying
	@Query("DELETE FROM Employee e where e.empId = ?1")
	public void deleteEmployee(Long id);

}
