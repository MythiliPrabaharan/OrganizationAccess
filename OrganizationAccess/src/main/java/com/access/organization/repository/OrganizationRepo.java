package com.access.organization.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.organization.entity.Organization;

@Repository
@Primary
public interface OrganizationRepo extends JpaRepository<Organization, Long> 
{
}
