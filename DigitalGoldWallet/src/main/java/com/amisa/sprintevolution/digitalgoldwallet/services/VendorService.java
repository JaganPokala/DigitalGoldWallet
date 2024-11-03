package com.amisa.sprintevolution.digitalgoldwallet.services;

import java.util.List;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Vendors;

public interface VendorService {
	
	public List<Vendors> getAllVendorsData();
	public Vendors getVendorByVendorId(int vendor_id);
	public List<Vendors> getVendorByVendorName(String vendor_name);
	public Vendors getVendorsByVendorName(String vendorName);
	public List<Vendors> getVendorsByContactEmail(String contactemail);
	public List<Vendors> getAllVendors();
	public Vendors getVendorById(int vendorId);
	public Vendors addVendor(Vendors vendor);
	public Vendors updateVendor(int vendorId, Vendors updatedVendor);
	public String updateTotalGoldQuantity(int vendorId, float quantity);
	public String updateCurrentGoldPrice(int vendorId, float newPrice);

}
