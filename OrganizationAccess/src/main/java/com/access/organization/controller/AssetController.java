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

import com.access.organization.entity.Asset;
import com.access.organization.repository.AssetRepo;

@RestController
public class AssetController 
{
	@Autowired
	AssetRepo assetrepo;


	//Creating a asset
	@PostMapping(value="/asset", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Asset> save(@RequestBody Asset asset)
	{
		try 
		{
			return new ResponseEntity<>(assetrepo.save(asset), HttpStatus.CREATED);
		} 
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	//Getting the list of assets
	@GetMapping(value="/assets", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<List<Asset>> getAllAssets() {
		try 
		{
			List<Asset> list = assetrepo.findAllAsset();

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

	//Updating the Asset
	@PutMapping(value="/asset", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Asset> updateAsset(@RequestBody Asset asset) 
	{
		try 
		{
			return new ResponseEntity<Asset>(assetrepo.save(asset), HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Deleting asset
	@DeleteMapping(value="/asset/{id}", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<HttpStatus> deleteAsset(@PathVariable Long id) 
	{
		try 
		{
			if(assetrepo.assetExits(id) != null)
			{
				assetrepo.deleteAsset(id);
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
