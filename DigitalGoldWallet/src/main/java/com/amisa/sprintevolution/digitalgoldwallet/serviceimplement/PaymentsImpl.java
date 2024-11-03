package com.amisa.sprintevolution.digitalgoldwallet.serviceimplement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Payments;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;
import com.amisa.sprintevolution.digitalgoldwallet.enums.payment_method;
import com.amisa.sprintevolution.digitalgoldwallet.enums.payment_status;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.PaymentRepository;
import com.amisa.sprintevolution.digitalgoldwallet.services.PaymentsService;

@Service
public class PaymentsImpl implements PaymentsService{
	
	@Autowired
	private PaymentRepository paymentrepository;
	
	
	
	public PaymentsImpl() {
		super();
	}

	public PaymentsImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentrepository = paymentRepository;
	}

	@Override
	public List<Payments> getAllPayments() {
		return paymentrepository.findAll();
	}

	@Override
	public Payments getPaymentById(int paymentId) {
		Optional<Payments> optionalPayment = paymentrepository.findById(paymentId);
        return optionalPayment.orElse(null);
	}

	@Override
	public Payments addPayment(Payments payments) {
		return paymentrepository.save(payments);
	}

	@Override
	public List<Payments> retrieveAllSuccessfulTransactions() {
		List<Payments> alapayments = paymentrepository.findAll();
        List<Payments> successfulTransactions = new ArrayList<>();
        for (Payments transaction : alapayments) {
            if (transaction.getPayment_status().equals(payment_status.Success)) {
                successfulTransactions.add(transaction);
            }
        }
        return successfulTransactions;
	}

	@Override
	public List<Payments> retrieveAllFailedTransactions() {
		List<Payments> allTransactions = paymentrepository.findAll();
	    List<Payments> failedTransactions = new ArrayList<>();
	    for (Payments transaction : allTransactions) {
	        if (transaction.getPayment_status().equals(payment_status.Failed)) {
	            failedTransactions.add(transaction);
	        }
	    }
	    return failedTransactions;
	}

	

//	return trahisrepo.findByTransactionType(type);
	
	@Override
	public List<Payments> getPaymentBypaymentmethod(payment_method payment_method) {
		return paymentrepository.findByPaymentMethod(payment_method);
	}

	@Override
	public List<Payments>getPaymentByUser(int user_id) {
		return paymentrepository.findByUserId(user_id);
	}

}
