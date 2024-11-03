package com.amisa.sprintevolution.digitalgoldwallet.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Physical_Gold_Transaction;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.*;
import com.amisa.sprintevolution.digitalgoldwallet.services.PhysicalGoldTransactionService;

@RestController
@RequestMapping("/api/v1/PhysicalGoldTransactions")
public class PhysicalGoldTransactionsController {
	@Autowired
	private PhysicalGoldTransactionService phygoldtranserv;

	// TO GET ALL TRANSACTIONS
	@GetMapping
	public List<Physical_Gold_Transaction> getAllTransactions() {
		List<Physical_Gold_Transaction> ph = phygoldtranserv.getAllTransactions();
		if(ph.isEmpty()) {
			throw new NoListFoundException("no physical transactions found");
		}
		return ph;
	}

	// TO GET TRANSACTION BY TRANSACTION ID
	@GetMapping("/{transaction_id}")
	public Physical_Gold_Transaction getTransactionById(@PathVariable("transaction_id") int transaction_id) {
		Physical_Gold_Transaction ph = phygoldtranserv.getTransactionById(transaction_id);
		if(ph == null) {
			throw new TransactionIdNotFoundException("transaction id not found");
		}
		return ph;
	}

	// TO GET TRANSACTION BY USER ID
	@GetMapping("/byUser/{user_id}")
	public List<Physical_Gold_Transaction> getTransactionsByUser(@PathVariable("user_id") int user_id) {
		List<Physical_Gold_Transaction> ph = phygoldtranserv.getTransactionsByUser(user_id);
		if(ph.isEmpty()) {
			throw new NoListFoundException("user id is not found");
		}
		return ph;
	}

	// TO GET TRANSACTION BY BRANCH ID
	@GetMapping("/by_branch/{branch_id}")
	public List<Physical_Gold_Transaction> getTransactionsByBranch(@PathVariable("branch_id") int branch_id) {
		List<Physical_Gold_Transaction> ph = phygoldtranserv.getTransactionsByBranch(branch_id);
		if(ph.isEmpty()) {
			throw new NoListFoundException("branch id is not found");
		}
		return ph;
	}

	// GET TRANSACTION BY DELIVERY CITY
	@GetMapping("/by_delivery_city/{city}")
	public List<Physical_Gold_Transaction> getTransactionsByDeliveryCity(@PathVariable("city") String city) {
		List<Physical_Gold_Transaction>ph = phygoldtranserv.getTransactionsByDeliveryCity(city);
		if(ph.isEmpty()) {
			throw new CityNameNotFoundException("city not found");
		}
		return ph;
	}

	// GET TRANSACTION BY DELIVERY STATE
	@GetMapping("/by_delivery_state/{state}")
	public List<Physical_Gold_Transaction> getTransactionsByDeliveryState(@PathVariable("state") String state) {
		List<Physical_Gold_Transaction>ph =  phygoldtranserv.getTransactionsByDeliveryState(state);
		if(ph.isEmpty()) {
			throw new StateNameNotFoundException("State not found");
		}
		return ph;
	}

 
	@PostMapping("/add")
	public ResponseEntity<SuccessResponse> addTransaction(@RequestBody Physical_Gold_Transaction transaction) {
		if(transaction.getAddresses()==null) {
			throw new ValidationFailedException("Validation Failed");
		}
		SuccessResponse sr=new SuccessResponse(LocalDate.now(),"physical gold transaction added successfully");
		return new ResponseEntity<>(sr, HttpStatus.CREATED);
	}

	@PutMapping("/update/{transaction_id}")
	public ResponseEntity<SuccessResponse> updateTransaction(
			@PathVariable("transaction_id") int transaction_id, @RequestBody Physical_Gold_Transaction transaction) {
		Physical_Gold_Transaction ps = phygoldtranserv.updateTransaction(transaction_id, transaction);
		if(ps == null) {
			throw new TransactionIdNotFoundException("transaction id not found");
		}
		
		SuccessResponse sr=new SuccessResponse(LocalDate.now(),"physical gold transaction updated successfully");
		return new ResponseEntity<>(sr, HttpStatus.CREATED);
	}
}