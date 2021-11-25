package com.access.organization.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.access.organization.entity.Asset;

@Repository
public interface AssetRepo extends OrganizationRepo
{

	@Query("SELECT NEW com.access.organization.entity.Asset(a.assetId, a.departmentName, a.departmentLocation, a.assetmodel, a.assetVendor) "
			+ "FROM Asset a")
	public List<Asset> findAllAsset();


	@Query("SELECT NEW com.access.organization.entity.Asset(a.assetId, a.departmentName, a.departmentLocation, a.assetmodel, a.assetVendor)"
			+ " FROM Asset a where a.assetId = ?1")
	public Asset findAssetById(Long id);

	@Query("SELECT a.assetId FROM Asset a where a.assetId = ?1")
	public Object assetExits(Long id);

	@Transactional
	@Modifying
	@Query("DELETE FROM Asset a where a.assetId = ?1")
	public void deleteAsset(Long id);
}
