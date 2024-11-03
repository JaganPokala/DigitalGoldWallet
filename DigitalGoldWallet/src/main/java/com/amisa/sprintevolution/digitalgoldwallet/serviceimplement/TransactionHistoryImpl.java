package com.amisa.sprintevolution.digitalgoldwallet.serviceimplement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.enums.transaction_status;
import com.amisa.sprintevolution.digitalgoldwallet.enums.transaction_type;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.TransactionHistoryRepository;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.UsersRepository;
import com.amisa.sprintevolution.digitalgoldwallet.services.TransactionHistoryService;


@Service
public class TransactionHistoryImpl implements TransactionHistoryService{
	
	@Autowired
    private TransactionHistoryRepository trahisrepo;
	
	private UsersRepository usrepo;
	
	
	
	public TransactionHistoryImpl() {
		super();
	}

	public TransactionHistoryImpl(TransactionHistoryRepository trahisrepo, UsersRepository usrepo) {
		super();
		this.trahisrepo = trahisrepo;
		this.usrepo = usrepo;
	}

	@Override
	public List<Transaction_History> getAllTransactions() {
			return trahisrepo.findAll();
	}
//
//	@Override
//	public Transaction_History getTransactionsByUserId(int transation_id) {
//		return trahisrepo.findById(transation_id);
//	}

	@Override
	public List<Transaction_History> retrieveAllFailedTransactions() {
		List<Transaction_History> allTransactions = trahisrepo.findAll();
	    List<Transaction_History> failedTransactions = new ArrayList<>();
	    for (Transaction_History transaction : allTransactions) {
	        if (transaction.getTransaction_status().equals(transaction_status.Failed)) {
	            failedTransactions.add(transaction);
	        }
	    }
	    return failedTransactions;
	}

	@Override
	public List<Transaction_History> retrieveAllSuccessfulTransactions() {
		List<Transaction_History> allTransactions = trahisrepo.findAll();
	    List<Transaction_History> successfulTransactions = new ArrayList<>();
	    for (Transaction_History transaction : allTransactions) {
	        if (transaction.getTransaction_status().equals(transaction_status.Success)) {
	            successfulTransactions.add(transaction);
	        }
	    }
	    return successfulTransactions;
	}

	@Override
	public List<Transaction_History> getTransactionsByType(transaction_type type) {
		return trahisrepo.findByTransactionType(type);
	}

	@Override
	public Transaction_History addtransactionhistory(Transaction_History transactionhistory) {
		return trahisrepo.save(transactionhistory);
	}

	@Override
	public List<Transaction_History> getTransactionsByUserId(int userId) {
		return trahisrepo.findByUsersUserId(userId);
	}

	@Override
	public Transaction_History getTransactionById(int transactionId) {
		 return trahisrepo.findById(transactionId);
	}

}
