package com.amisa.sprintevolution.digitalgoldwallet.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Vendors;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.*;
import com.amisa.sprintevolution.digitalgoldwallet.services.VendorService;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorController {
	@Autowired
	private VendorService vendserv;

	
	public VendorController(VendorService vendserv) {
		super();
		this.vendserv = vendserv;
	}

	@GetMapping
    public ResponseEntity<List<Vendors>> getAllVendors() {
        List<Vendors> vendors = vendserv.getAllVendors();
        if(vendors.isEmpty()) {
        	throw new NoListFoundException("Vendors not found");
        }
        return ResponseEntity.ok(vendors);
    }
 
    @GetMapping("/{vendorId}")
    public ResponseEntity<Vendors> getVendorById(@PathVariable int vendorId) {
        Vendors vendor = vendserv.getVendorById(vendorId);
        if(vendor == null) {
        	throw new VendorIdNotFoundException("vendor id not found");
        }
        return ResponseEntity.ok(vendor);
    }
 
    @GetMapping("/name/{vendorName}")
    public ResponseEntity<Vendors> getVendorByVendorName(@PathVariable String vendorName) {
        Vendors vendor = vendserv.getVendorsByVendorName(vendorName);
        if(vendor == null) {
        	throw new  VendorNameNotFoundException("Vendor name not found");
        }
        return ResponseEntity.ok(vendor);
    }
 
    @PostMapping("/add")
    public ResponseEntity<SuccessResponse> addVendor(@RequestBody Vendors vendor) {
    	if(vendor.getContact_person_name()==null||vendor.getContact_phone()==null) {
    		throw new ValidationFailedException("Validation Failed");
    	}
        Vendors addedvendor = vendserv.addVendor(vendor);
        SuccessResponse sr=new SuccessResponse(LocalDate.now(),"New vendors added successfully");
		return new ResponseEntity<>(sr, HttpStatus.CREATED);
        
    }
 
    @PutMapping("/update/{vendorId}")
    public ResponseEntity<SuccessResponse> updateVendor(@PathVariable int vendorId, @RequestBody Vendors updatedVendor) {
        Vendors updated = vendserv.updateVendor(vendorId, updatedVendor);
        if(updated == null) {
        	throw new VendorIdNotFoundException("vendor id not found");
        }
        SuccessResponse sr=new SuccessResponse(LocalDate.now(),"New vendors updated successfully");
		return new ResponseEntity<>(sr, HttpStatus.OK);
        
    }
 
    @PutMapping("/{vendorId}/total_gold_quantity/{quantity}")
    public ResponseEntity<SuccessResponse> updateTotalGoldQuantity(@PathVariable int vendorId, @PathVariable float quantity) {
        String result = vendserv.updateTotalGoldQuantity(vendorId, quantity);
        if(result == null) {
        	throw new VendorIdNotFoundException("vendor id not found");
        }
        SuccessResponse sr=new SuccessResponse(LocalDate.now(),"New quantity added successfully");
       return new ResponseEntity<>(sr, HttpStatus.OK);
    }
 
    @PutMapping("/new_current_gold_price/{vendorId}/{newPrice}")
    public ResponseEntity<SuccessResponse> updateCurrentGoldPrice(@PathVariable int vendorId, @PathVariable float newPrice) {
        String result = vendserv.updateCurrentGoldPrice(vendorId, newPrice);
        if(result == null) {
        	throw new VendorIdNotFoundException("vendor id not found");
        }
        SuccessResponse sr=new SuccessResponse(LocalDate.now(),"New price added successfully");
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }
}
