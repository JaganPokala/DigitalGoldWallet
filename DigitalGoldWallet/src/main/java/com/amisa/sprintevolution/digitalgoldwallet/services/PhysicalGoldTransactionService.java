package com.amisa.sprintevolution.digitalgoldwallet.services;

import java.util.List;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Physical_Gold_Transaction;

public interface PhysicalGoldTransactionService {

	public Physical_Gold_Transaction updateTransaction(int transaction_id, Physical_Gold_Transaction transaction);
	public Physical_Gold_Transaction addTransaction(Physical_Gold_Transaction transaction);
	public List<Physical_Gold_Transaction> getTransactionsByDeliveryState(String state);
	public List<Physical_Gold_Transaction> getTransactionsByDeliveryCity(String city);
	public List<Physical_Gold_Transaction> getTransactionsByBranch(int branch_id);
	public List<Physical_Gold_Transaction> getTransactionsByUser(int user_id);
	public Physical_Gold_Transaction getTransactionById(int transaction_id);
	public List<Physical_Gold_Transaction> getAllTransactions();
	
	
	
	
	
	
}
