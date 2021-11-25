package com.access.organization.controller;

import java.util.List;
import java.util.Optional;

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

import com.access.organization.entity.Organization;
import com.access.organization.repository.OrganizationRepo;

@RestController
public class OrganizationController 
{
	@Autowired
	OrganizationRepo orgrepo;
	
		
	//Creating a department
	@PostMapping(value="/organization", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Organization> save(@RequestBody Organization org)
	{
		try 
		{
			return new ResponseEntity<>(orgrepo.save(org), HttpStatus.CREATED);
		} 
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Getting the list of department added
	@GetMapping(value="/organization", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<List<Organization>> getAllDepartments() {
		try 
		{
			List<Organization> list = orgrepo.findAll();
			
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
	
	//Updating the department
	@PutMapping(value="/organization", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Organization> updateDepartment(@RequestBody Organization org) 
	{
		try 
		{
			return new ResponseEntity<Organization>(orgrepo.save(org), HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Deleting department
	@DeleteMapping(value="/organization/{id}", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable Long id) 
	{
		try 
		{
			Optional<Organization> org = orgrepo.findById(id);
			if (org.isPresent())
			{
				orgrepo.delete(org.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
