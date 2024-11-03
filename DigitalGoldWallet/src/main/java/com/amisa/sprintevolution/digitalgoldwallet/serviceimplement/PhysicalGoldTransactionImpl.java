package com.amisa.sprintevolution.digitalgoldwallet.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Physical_Gold_Transaction;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.PhysicalGoldTransRepository;
import com.amisa.sprintevolution.digitalgoldwallet.services.PhysicalGoldTransactionService;


@Service
public class PhysicalGoldTransactionImpl implements PhysicalGoldTransactionService{

	@Autowired
	private PhysicalGoldTransRepository phygoldtrarepo;
	
	
	
	
	public PhysicalGoldTransactionImpl() {
		super();
	}


	public PhysicalGoldTransactionImpl(PhysicalGoldTransRepository phygoldtrarepo) {
		super();
		this.phygoldtrarepo = phygoldtrarepo;
	}


	@Override
	public Physical_Gold_Transaction updateTransaction(int transaction_id, Physical_Gold_Transaction transaction) {
		Physical_Gold_Transaction existingTransaction = phygoldtrarepo.findById(transaction_id);
		  //if (existingTransaction != null) {
		    return phygoldtrarepo.save(transaction);
		}
	

	@Override
	public Physical_Gold_Transaction addTransaction(Physical_Gold_Transaction transaction) {
		return phygoldtrarepo.save(transaction);
	}

	@Override
	public List<Physical_Gold_Transaction> getTransactionsByDeliveryState(String state) {
		return phygoldtrarepo.findByAddressesState(state);
	}

	@Override
	public List<Physical_Gold_Transaction> getTransactionsByDeliveryCity(String city) {
		return phygoldtrarepo.findByAddressesCity(city);
	}

	@Override
	public List<Physical_Gold_Transaction> getTransactionsByBranch(int branch_id) {
		return phygoldtrarepo.findByVendorBranchesBranchId(branch_id);
	}

	@Override
	public List<Physical_Gold_Transaction> getTransactionsByUser(int user_id) {
		return phygoldtrarepo.findByUserUserId(user_id);
	}

	@Override
	public Physical_Gold_Transaction getTransactionById(int transaction_id) {
		return phygoldtrarepo.findById(transaction_id);
	}

	@Override
	public List<Physical_Gold_Transaction> getAllTransactions() {
		return phygoldtrarepo.findAll();
	}


	
}
