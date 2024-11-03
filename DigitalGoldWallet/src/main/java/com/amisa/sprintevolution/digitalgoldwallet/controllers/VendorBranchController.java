package com.amisa.sprintevolution.digitalgoldwallet.controllers;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Addresses;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Vendor_Branches;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.*;
import com.amisa.sprintevolution.digitalgoldwallet.services.VendorBranchService;

@RestController
@RequestMapping("/api/v1/vendor_branches")
public class VendorBranchController {
	@Autowired
	private VendorBranchService venbranchserv;

	// 1) GET ALL VENDOR BRANCHES
	@GetMapping
	public List<Vendor_Branches> getAllVendorBranches() {
		List<Vendor_Branches> vb = venbranchserv.getAllBranchesData();
		if (vb.isEmpty()) {
			throw new NoListFoundException("vendor branches not found");
		}
		return vb;

	}

	// 2)GET VENDOR BY BRANCH ID
	@RequestMapping("/{branch_id}")
	public Vendor_Branches getVendorBranchesByVendorId(@PathVariable int branch_id) {
		Vendor_Branches vb = venbranchserv.getVendorBranchesByVendorId(branch_id);
		if (vb == null) {
			throw new BranchIdNotFoundException("branch id not found");
		}
		return vb;
	}

//	//3)Get Vendor Branch by vendor_id
	@RequestMapping(value = "/by_vendor/{vendor_id}")
	public Vendor_Branches getVendorByVendorId(@PathVariable int vendor_id) {
		Vendor_Branches vb = venbranchserv.getVendorByVendorId(vendor_id);
		if (vb == null) {
			throw new VendorIdNotFoundException("branch id not found");
		}
		return vb;
	}

	// 4)Get Vendor Branch by city
	@GetMapping("/by_city/{city}")
	public List<Vendor_Branches> getVendorBranchesByCity(@PathVariable String city) {
		List<Vendor_Branches> vb = venbranchserv.getVendorBranchesByCity(city);
		if (vb.isEmpty()) {
			throw new CityNameNotFoundException("no branches present in this city");
		}
		return vb;
	}

	// 5)Get Vendor Branch by state
	@GetMapping("/by_state/{state}")
	public List<Vendor_Branches> getVendorBranchesByState(@PathVariable String state) {
		List<Vendor_Branches> vb = venbranchserv.getVendorBranchesByState(state);
		if (vb.isEmpty()) {
			throw new StateNameNotFoundException("no branches present in this state");
		}
		return vb;
	}

	// 6)Get Vendor Branch by Country
	@GetMapping("/by_country/{country}")
	public List<Vendor_Branches> getVendorBranchesByCountry(@PathVariable String country) {
		List<Vendor_Branches> vb = venbranchserv.getVendorBranchesByCountry(country);
		if (vb.isEmpty()) {
			throw new StateNameNotFoundException("no branches present in this country");
		}
		return vb;
	}

	// 7) add new vendor branch
	@PostMapping("/add")
	public ResponseEntity<SuccessResponse> addVendorBranch(@RequestBody Vendor_Branches vb) {
		if (vb.getAddresses() == null) {
			throw new ValidationFailedException("Validation Failed");
		}
		Vendor_Branches vd = venbranchserv.addVendorBranch(vb);
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "New vendor branch added successfully");
		return new ResponseEntity<>(sr, HttpStatus.CREATED);
	}

	// 8)update vendor branch details by branch id
	@PutMapping("/update/{branch_id}")
	public ResponseEntity<SuccessResponse> updateuser(@PathVariable("branch_id") int id,
			@RequestBody Vendor_Branches vb) {
		Vendor_Branches usrr = venbranchserv.updateuser(id, vb);
		if (usrr == null) {
			throw new BranchIdNotFoundException("branch id not found");
		}
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "New vendor branch added successfully");
		return new ResponseEntity<>(sr, HttpStatus.CREATED);

	}

	// 9)Transfers a specified quantity of gold from one vendor branch to another
	@PostMapping("/transfer/{source_branch_id}/{destination_branchId}")
	public ResponseEntity<String> transferBranch(@PathVariable int source_branch_id,
			@PathVariable int destination_branchId) {
		venbranchserv.transferBranch(source_branch_id, destination_branchId);
		return ResponseEntity.ok("Branch transfer successful");
	}
	
	

	// 10 )Get Vendor Branch transactions by branch_id
	@GetMapping("/transactions/{branch_id}")
	public ResponseEntity<List<Transaction_History>> getTransactionsByBranchId(
			@PathVariable("branch_id") int branchId) {
		List<Transaction_History> transactions = venbranchserv.getTransactionsByBranchId(branchId);
		if (transactions.isEmpty()) {
			throw new BranchIdNotFoundException("branch id not found");
		}
		return ResponseEntity.ok().body(transactions);
	}
	
	
	
}
