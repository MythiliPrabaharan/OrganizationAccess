package com.access.organization.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET")
public class Asset extends Organization
{
	private Long assetId;

	private String assetmodel;

	private String assetVendor;

	public Asset() {
	}

	public Asset(Long assetId, String departmentName, String departmentLocation, String assetmodel,
			String assetVendor)
	{
		super(departmentName, departmentLocation);
		this.assetId = assetId;
		this.assetmodel = assetmodel;
		this.assetVendor = assetVendor;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getAssetmodel() {
		return assetmodel;
	}

	public void setAssetmodel(String assetmodel) {
		this.assetmodel = assetmodel;
	}

	public String getAssetVendor() {
		return assetVendor;
	}

	public void setAssetVendor(String assetVendor) {
		this.assetVendor = assetVendor;
	}




}
