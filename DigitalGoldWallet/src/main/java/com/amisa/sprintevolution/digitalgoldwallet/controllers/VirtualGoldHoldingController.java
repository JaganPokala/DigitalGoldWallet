package com.amisa.sprintevolution.digitalgoldwallet.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Physical_Gold_Transaction;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Virtual_Gold_Holdings;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.*;
import com.amisa.sprintevolution.digitalgoldwallet.services.PhysicalGoldTransactionService;
import com.amisa.sprintevolution.digitalgoldwallet.services.VirtualGoldHoldingService;

@RestController
@RequestMapping("/api/v1/virtual_Gold_Holding")
public class VirtualGoldHoldingController {
	@Autowired
	private VirtualGoldHoldingService virtgoldholdingserv;
	
	@Autowired
	private PhysicalGoldTransactionService pgtserv;
	
	
	public VirtualGoldHoldingController(VirtualGoldHoldingService virtgoldholdingserv,
			PhysicalGoldTransactionService pgtserv) {
		super();
		this.virtgoldholdingserv = virtgoldholdingserv;
		this.pgtserv = pgtserv;
	}


	public VirtualGoldHoldingController() {
		super();
	}


	public VirtualGoldHoldingController(VirtualGoldHoldingService virtgoldholdingserv) {
		super();
		this.virtgoldholdingserv = virtgoldholdingserv;
	}


	//all users
	 @GetMapping
	    public ResponseEntity<List<Virtual_Gold_Holdings>> getAllVirtualGoldHoldings() {
	        List<Virtual_Gold_Holdings> holdings = virtgoldholdingserv.getAllVirtualGoldHoldings();
	        if(holdings.isEmpty()) {
	        	throw new NoListFoundException("virtual gold holdings not found");
	        }
	        return new ResponseEntity<>(holdings, HttpStatus.OK);
	    }
	 
	 
	 //by holding id
	 @GetMapping("/{holding_id}")
	    public ResponseEntity<Virtual_Gold_Holdings> getVirtualGoldHoldingById(@PathVariable("holding_id") int holdingId) {
	        Virtual_Gold_Holdings holding = virtgoldholdingserv.getVirtualGoldHoldingById(holdingId);
	        if(holding == null) {
	        	throw new HoldingIdNotFoundException("holdings id not found");

	        }
	        return new ResponseEntity<>(holding, HttpStatus.OK);
	    }
	    
	    
	    
	    //usr id
	    @GetMapping("/users/{user_id}")
	    public ResponseEntity<Optional<Virtual_Gold_Holdings>> getVirtualGoldHoldingsByUserId(@PathVariable("user_id") int userId) {
	        Optional<Virtual_Gold_Holdings> h = virtgoldholdingserv.getVirtualGoldHoldingsByUserId(userId);
	        if(h.isEmpty())
	        {
	        	throw new HoldingIdNotFoundException("User not found with Id:"+ userId);
	        }
			return new ResponseEntity<>(h,HttpStatus.OK);
	    }
	    
	    //by user and vendor id get list of virtual holdings
	    
	    @GetMapping("/byUserAndVendor/{userId}/{vendorId}")
	    public ResponseEntity<List<Virtual_Gold_Holdings>> getByUserAndVendor(
	            @PathVariable("userId") int userId,
	            @PathVariable("vendorId") int vendorId) {
	        List<Virtual_Gold_Holdings> holdings = virtgoldholdingserv.findByUserIdAndVendorId(userId, vendorId);
	        if (holdings.isEmpty()) {
	            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        	    throw new HoldingIdNotFoundException("User Id and Vendor Id not found:"+userId+ " "+vendorId);
	        	//throw new HoldingIdNotFoundException("User not found with Id:"+ userId);
	        }
	        return new ResponseEntity<>(holdings, HttpStatus.OK);
	    }
	    
	    //add vgh
	    @PostMapping("/add")
	    public ResponseEntity<Virtual_Gold_Holdings> addVirtualGoldHolding(@RequestBody Virtual_Gold_Holdings holding) {
	        Virtual_Gold_Holdings newHolding = virtgoldholdingserv.addVirtualGoldHolding(holding);
	        return new ResponseEntity<>(newHolding, HttpStatus.CREATED);
	    }
	    
	    
	    //update by holding id
	    @PutMapping("/update/{holding_id}")
	    public Virtual_Gold_Holdings updateVendor(@PathVariable int holding_id, @RequestBody Virtual_Gold_Holdings updatedVendor) {
	    	Virtual_Gold_Holdings updated = virtgoldholdingserv.updateVendor(holding_id, updatedVendor);
	        return updated;
	    }
    
	    
	    
}