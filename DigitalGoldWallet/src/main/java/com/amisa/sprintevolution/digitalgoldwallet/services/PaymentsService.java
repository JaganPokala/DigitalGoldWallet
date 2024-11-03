package com.amisa.sprintevolution.digitalgoldwallet.services;

import java.util.List;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Payments;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;
import com.amisa.sprintevolution.digitalgoldwallet.enums.payment_method;

public interface PaymentsService {
	public List<Payments> getAllPayments();
	public Payments getPaymentById(int paymentId);
	public Payments addPayment(Payments payments);
	public List<Payments> retrieveAllSuccessfulTransactions();
	public List<Payments> retrieveAllFailedTransactions();
	public List<Payments> getPaymentBypaymentmethod(payment_method paymentmethod);
	public List<Payments> getPaymentByUser(int user_id);
}
