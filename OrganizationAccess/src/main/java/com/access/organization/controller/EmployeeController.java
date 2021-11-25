package com.access.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.access.organization.entity.Employee;
import com.access.organization.repository.EmployeeRepo;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeRepo emprepo;


	//Creating a employee
	@PostMapping(value="/employee", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Employee> save(@RequestBody Employee emp)
	{
		try 
		{
			return new ResponseEntity<>(emprepo.save(emp), HttpStatus.CREATED);
		} 
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	//Getting the list of employees
	@GetMapping(value="/employees", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try 
		{
			List<Employee> list = emprepo.findAllEmployee();

			if (list.isEmpty() || list.size() == 0) 
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Updating the Employee
	@PutMapping(value="/employee", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) 
	{
		try 
		{
			return new ResponseEntity<Employee>(emprepo.save(emp), HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Deleting Employee
	@DeleteMapping(value="/employee/{id}", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) 
	{
		try 
		{
			//System.out.println(emprepo.employeeExits(id));
			if(emprepo.employeeExits(id) != null)
			{
				emprepo.deleteEmployee(id);
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception " + e);
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
