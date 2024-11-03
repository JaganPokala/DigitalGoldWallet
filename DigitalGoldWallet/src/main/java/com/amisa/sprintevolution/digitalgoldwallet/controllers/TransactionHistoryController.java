package com.amisa.sprintevolution.digitalgoldwallet.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;
import com.amisa.sprintevolution.digitalgoldwallet.enums.transaction_type;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.NoListFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.SuccessResponse;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.TransactionIdNotFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.TransactionTypeNotFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.ValidationFailedException;
import com.amisa.sprintevolution.digitalgoldwallet.services.TransactionHistoryService;

@RestController
@RequestMapping("/api/v1/transaction_history")
public class TransactionHistoryController {
	@Autowired
	private TransactionHistoryService tranhistserv;

	public TransactionHistoryController(TransactionHistoryService tranhistserv) {
		super();
		this.tranhistserv = tranhistserv;
	}

	@GetMapping
	public List<Transaction_History> getAllTransactions() {
		List<Transaction_History> th = tranhistserv.getAllTransactions();
		if(th.isEmpty()) {
			throw new NoListFoundException("transaction history not found");
		}
		return th;
	}

    
	 @GetMapping("/{transaction_id}")
	    public ResponseEntity<Transaction_History> getTransactionById(@PathVariable("transaction_id") int transactionId) {
	        Transaction_History transaction = tranhistserv.getTransactionById(transactionId);
	        if (transaction == null) {
				throw new TransactionIdNotFoundException("transaction id not found");
	        } 
	        return new ResponseEntity(transaction, HttpStatus.OK);
	    }


	@GetMapping("/failed")
	public ResponseEntity<List<Transaction_History>> retrieveFailTransactions() {
		List<Transaction_History> th = tranhistserv.retrieveAllFailedTransactions();
		if(th.isEmpty()) {
			throw new NoListFoundException("no failed transactions found");
		}
		 return new ResponseEntity(th, HttpStatus.OK);
	} 

	// GET
	@GetMapping("/successful")
	public ResponseEntity<List<Transaction_History>> retrieveSuccessfulTransactions() {
		List<Transaction_History> th = tranhistserv.retrieveAllSuccessfulTransactions();
		if(th.isEmpty()) {
			throw new NoListFoundException("no success transactions found");
		}
		 return new ResponseEntity(th, HttpStatus.OK);
	}

	@GetMapping("/by_type/{transactionType}")
	public ResponseEntity<List<Transaction_History>> getTransactionHistoryByType(
			@PathVariable transaction_type transactionType) {
		List<Transaction_History> transactionhistory = tranhistserv.getTransactionsByType(transactionType);
		if(transactionhistory.isEmpty()) {
			throw new TransactionTypeNotFoundException("no failed transactions found");
		}
		
		return ResponseEntity.ok().body(transactionhistory);
	}

	@PostMapping("/add")
	public ResponseEntity<SuccessResponse> addtransactionhistory(@RequestBody Transaction_History th) {
		Transaction_History th1 = tranhistserv.addtransactionhistory(th);
		if(th1.getTransaction_status()==null||th1.getTransaction_type()==null) {
			throw new ValidationFailedException("Validation Failed");
		}
		SuccessResponse sr=new SuccessResponse(LocalDate.now(),"Transaction history added successfully");
		return new ResponseEntity<>(sr, HttpStatus.CREATED);
	}
	
	
	 @GetMapping("/by_user/{user_id}")
	    public ResponseEntity<List<Transaction_History>> getTransactionHistoryByUserId(@PathVariable("user_id") int userId) {
	        List<Transaction_History> transactionHistory = tranhistserv.getTransactionsByUserId(userId);
	        if(transactionHistory.isEmpty()) {
	        	
	        	throw new NoListFoundException("transaction history not found for this user id");
	        }
	        
	        return ResponseEntity.ok().body(transactionHistory);
	    }

//	    
}
