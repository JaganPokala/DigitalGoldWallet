package com.amisa.sprintevolution.digitalgoldwallet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Vendor_Branches;

@Repository
public interface VendorBranchesRepository extends JpaRepository<Vendor_Branches, Integer> {
	
	 List< Vendor_Branches> findByAddressesCity(String city);
	 List<Vendor_Branches> findByAddressesState(String state);
	 List< Vendor_Branches> findByAddressesCountry(String country);
}