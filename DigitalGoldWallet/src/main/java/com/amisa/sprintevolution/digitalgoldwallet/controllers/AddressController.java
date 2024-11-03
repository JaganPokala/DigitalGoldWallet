package com.amisa.sprintevolution.digitalgoldwallet.controllers;
import java.time.LocalDate;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.amisa.sprintevolution.digitalgoldwallet.beans.Addresses;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.AddressIdNotFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.SuccessResponse;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.*;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.ValidationFailedException;
import com.amisa.sprintevolution.digitalgoldwallet.services.AddressesService;
 
@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
	@Autowired
	private AddressesService addrserv;

	 @GetMapping
	    public List<Addresses> getAllAddresses() {
		 List<Addresses> adr = addrserv.getAllAddresses();
		 if(adr.isEmpty()) {
	    		throw new NoListFoundException("Addresses not found");
		 }
		 return adr;
	    }
 
	    @GetMapping("/{address_id}")
	    public List<Addresses> getAddressById(@PathVariable int address_id) {
	    	List<Addresses> adr =addrserv.getAddressById(address_id);
	    	if(adr == null) {
	    		throw new AddressIdNotFoundException("Address id not found");
	    	}
	    	return adr;
	    }
 
	    @PostMapping("/add")
	    public ResponseEntity<SuccessResponse> addAddress(@RequestBody Addresses address) {
	    	if(address.getCity().isEmpty()||address.getPostal_code().isEmpty()||address.getState().isEmpty()) {
	    		throw new ValidationFailedException("Validation Failed");
	    	}
	    	
	    	SuccessResponse sr=new SuccessResponse(LocalDate.now(),"New Address added successfully");
			return new ResponseEntity<>(sr, HttpStatus.CREATED);
	    }
 
	    @PutMapping("/update/{address_id}")
	    public ResponseEntity<SuccessResponse> updateAddress(@PathVariable int address_id, @RequestBody Addresses address) {
	        Addresses addr= addrserv.updateAddress(address_id, address);
	        
	        if (addr == null) {
				throw new AddressIdNotFoundException("Address with ID " + address_id + " not found");
			}
	        SuccessResponse sr=new SuccessResponse(LocalDate.now()," Address updated successfully");
			return new ResponseEntity<>(sr, HttpStatus.CREATED);
	    }
	    
	    

	    
	}	