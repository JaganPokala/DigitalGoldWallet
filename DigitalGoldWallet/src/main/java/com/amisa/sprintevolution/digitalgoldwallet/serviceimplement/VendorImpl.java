package com.amisa.sprintevolution.digitalgoldwallet.serviceimplement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Vendors;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.VendorsRepository;
import com.amisa.sprintevolution.digitalgoldwallet.services.VendorService;


@Service
public class VendorImpl implements VendorService {
	
	@Autowired
	private VendorsRepository vendorrepo;
	
	
	
	public VendorImpl() {
		super();
	}

	public VendorImpl(VendorsRepository vendorrepo) {
		super();
		this.vendorrepo = vendorrepo;
	}

	@Override
	public List<Vendors> getAllVendorsData() {
		return vendorrepo.findAll();
	}

	@Override
	public Vendors getVendorByVendorId(int vendor_id) {
		return vendorrepo.findById(vendor_id).get();
	}

	@Override
	public List<Vendors> getVendorByVendorName(String vendor_name) {
		List<Vendors> v = vendorrepo.findAll();
		 List<Vendors> result = new LinkedList<>();
		 Iterator i = v.listIterator();
		 while(i.hasNext()) {
			 Vendors v1 = (Vendors) i.next();
			 String name1 = v1.getVendorName().replace(" ", "");
			 String name2 = vendor_name.replace(" ", "");
			 //System.out.println(name1+" "+name2);
			 if(name1.equals(name2)) {
				 result.add(v1);
			 }
		 }
		 return result;
	}

	@Override
	public Vendors getVendorsByVendorName(String vendorName) {
		return vendorrepo.findByVendorName(vendorName);
	}

	@Override
	public List<Vendors> getVendorsByContactEmail(String contactemail) {
		return vendorrepo.findByContactemail(contactemail);
	}

	@Override
	public List<Vendors> getAllVendors() {
		return vendorrepo.findAll();
	}

	@Override
	public Vendors getVendorById(int vendorId) {
		return vendorrepo.findById(vendorId).orElse(null);
	}

	@Override
	public Vendors addVendor(Vendors vendor) {
		return vendorrepo.save(vendor);
	}

	@Override
	public Vendors updateVendor(int vendorId, Vendors updatedVendor) {
		Vendors existingVendor = vendorrepo.findById(vendorId).orElse(null);
        if (existingVendor != null) {
            existingVendor.setVendorName(updatedVendor.getVendorName());
            existingVendor.setDescription(updatedVendor.getDescription());
            existingVendor.setContact_person_name(updatedVendor.getContact_person_name());
            existingVendor.setContactemail(updatedVendor.getContactemail());
            existingVendor.setContact_phone(updatedVendor.getContact_phone());
            existingVendor.setWebsite_url(updatedVendor.getWebsite_url());
            existingVendor.setTotal_gold_quantity(updatedVendor.getTotal_gold_quantity());
            existingVendor.setCurrent_gold_price(updatedVendor.getCurrent_gold_price());
            existingVendor.setCreated_at(updatedVendor.getCreated_at());
            vendorrepo.save(existingVendor);
        }
        return existingVendor;
	}

	@Override
	public String updateTotalGoldQuantity(int vendorId, float quantity) {
		Vendors existingVendor = vendorrepo.findById(vendorId).orElse(null);
        if (existingVendor != null) {
            existingVendor.setTotal_gold_quantity(quantity);
            vendorrepo.save(existingVendor);
            return "Total gold quantity updated successfully";
        }
        return "Vendor not found";
	}

	@Override
	public String updateCurrentGoldPrice(int vendorId, float newPrice) {
		Vendors existingVendor = vendorrepo.findById(vendorId).orElse(null);
        if (existingVendor != null) {
            existingVendor.setCurrent_gold_price(newPrice);
            vendorrepo.save(existingVendor);
            return "Current gold price updated successfully";
        }
        return "Vendor not found";
    }
	
	}


