package com.amisa.sprintevolution.digitalgoldwallet.services;

import java.util.List;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Vendor_Branches;

public interface VendorBranchService {
	
	public List<Vendor_Branches> getAllBranchesData();
	
	public Vendor_Branches getVendorBranchesByVendorId(int branchId);
	
	public Vendor_Branches updateuser(int id, Vendor_Branches vb);
	
	public List<Vendor_Branches> getVendorBranchesByCity(String city);
	
	public List<Vendor_Branches> getVendorBranchesByState(String state);
	
	public List<Vendor_Branches> getVendorBranchesByCountry(String country);
	
	public Vendor_Branches addVendorBranch(Vendor_Branches vendorBranch);
	
	public void transferBranch(int sourceBranchId, int destinationBranchId);
	
	public Vendor_Branches getVendorByVendorId(int vendorId);
	
	public List<Transaction_History> getTransactionsByBranchId(int branchId);
	
	
	

}
