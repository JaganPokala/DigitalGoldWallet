package com.amisa.sprintevolution.digitalgoldwallet.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Payments;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Physical_Gold_Transaction;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.enums.payment_method;
import com.amisa.sprintevolution.digitalgoldwallet.enums.transaction_type;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.NoListFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.SuccessResponse;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.TransactionTypeNotFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.ValidationFailedException;
import com.amisa.sprintevolution.digitalgoldwallet.services.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
	@Autowired
	private PaymentsService paymentservice;

	//1) get all payments
	@GetMapping
	public ResponseEntity<List<Payments>> getAllPayments() {
		List<Payments> payments = paymentservice.getAllPayments();
		if (payments.isEmpty()) {
			throw new NoListFoundException("Payments not found");
		}

		return new ResponseEntity<>(payments, HttpStatus.OK);
	}

	
	//2) Endpoint to retrieve a specific payment by ID
	@GetMapping("/{payment_id}")
	public ResponseEntity<Payments> getPaymentById(@PathVariable("payment_id") int paymentId) {
		Payments payment = paymentservice.getPaymentById(paymentId);
		if (payment != null) {
			return new ResponseEntity<>(payment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//3) get all successful payments
	@GetMapping("/successful")
	public ResponseEntity<List<Payments>> retrieveSuccessfulTransactions() {
		List<Payments> ps = paymentservice.retrieveAllSuccessfulTransactions();
		if (ps.isEmpty()) {
			throw new TransactionTypeNotFoundException("no successful paymnts");
		}
		return new ResponseEntity(ps, HttpStatus.OK);
	}
	
	
	//4) get all failed payments

	@GetMapping("/failed")
	public ResponseEntity<List<Payments>> retrieveFailTransactions() {
		List<Payments> ps = paymentservice.retrieveAllFailedTransactions();
		if (ps.isEmpty()) {
			throw new TransactionTypeNotFoundException("no failed paymnts");
		}
		return new ResponseEntity(ps, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<SuccessResponse> addPayments(@RequestBody Payments payments) {
		Payments pay = paymentservice.addPayment(payments);
		if (pay.getPayment_method() == null || pay.getPayment_status() == null || pay.getTransaction_type() == null) {
			throw new ValidationFailedException("Validation Failed");
		}
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "new payments added successfully");
		return new ResponseEntity<>(sr, HttpStatus.CREATED);

	}

	@GetMapping("/by_user/{user_id}")
	public ResponseEntity<List<Payments>> findByUserId(@PathVariable("user_id") int user_id) {
		List<Payments> payments = paymentservice.getPaymentByUser(user_id);
		if (payments.isEmpty()) {
			throw new NoListFoundException("Payments not found for user id" + user_id);
		}

		return new ResponseEntity<>(payments, HttpStatus.OK);
	}

	@GetMapping("/by_payment_method/{payment_method}")
	public ResponseEntity<List<Payments>> getTransactionHistoryByType(
			@PathVariable("payment_method") payment_method paymentmethod) {
		List<Payments> transactionhistory = paymentservice.getPaymentBypaymentmethod(paymentmethod);
		if (transactionhistory.isEmpty()) {
			throw new NoListFoundException("Payments not found by payment method");
		}
		return ResponseEntity.ok().body(transactionhistory);
	}

}