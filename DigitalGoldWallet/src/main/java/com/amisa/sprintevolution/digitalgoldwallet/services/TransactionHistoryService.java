package com.amisa.sprintevolution.digitalgoldwallet.services;

import java.util.List;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.enums.transaction_type;

public interface TransactionHistoryService {
	public List<Transaction_History> getAllTransactions();
	public List<Transaction_History> retrieveAllFailedTransactions();
	public List<Transaction_History> retrieveAllSuccessfulTransactions();
	public List<Transaction_History> getTransactionsByType(transaction_type type);
	public Transaction_History addtransactionhistory(Transaction_History transactionhistory);
	public List<Transaction_History> getTransactionsByUserId(int userId);
	public Transaction_History getTransactionById(int transactionId);
}
