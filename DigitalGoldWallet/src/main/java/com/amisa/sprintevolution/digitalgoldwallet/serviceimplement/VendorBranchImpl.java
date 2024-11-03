package com.amisa.sprintevolution.digitalgoldwallet.serviceimplement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Vendor_Branches;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.TransactionHistoryRepository;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.VendorBranchesRepository;
import com.amisa.sprintevolution.digitalgoldwallet.services.VendorBranchService;

import jakarta.transaction.Transactional;


@Service
public class VendorBranchImpl implements VendorBranchService {
	
	@Autowired
	private VendorBranchesRepository vendorbrarepo;
	
	
	@Autowired
	private TransactionHistoryRepository trahisrepo;
	
	@Override
	public List<Vendor_Branches> getAllBranchesData() {
		return vendorbrarepo.findAll();
	}

	@Override
	public Vendor_Branches getVendorBranchesByVendorId(int branchId) {
		return vendorbrarepo.findById(branchId).get();
	}

	@Override
	public Vendor_Branches updateuser(int id, Vendor_Branches vb) {
		if((vendorbrarepo.existsById(id))) {
			vb.setBranch_id(id);
			return vendorbrarepo.save(vb);
		}
		return null;
	}
	
	
	//
	@Override
	public List<Vendor_Branches> getVendorBranchesByCity(String city) {
		return vendorbrarepo.findByAddressesCity(city);
	}

	@Override
	public List<Vendor_Branches> getVendorBranchesByState(String state) {
		return vendorbrarepo.findByAddressesState(state);
	}

	@Override
	public List<Vendor_Branches> getVendorBranchesByCountry(String country) {
		return vendorbrarepo.findByAddressesCountry(country);
	}

	@Override
	public Vendor_Branches addVendorBranch(Vendor_Branches vendorBranch) {
		return vendorbrarepo.save(vendorBranch);
	}
	
	
	@Transactional
	@Override
	public void transferBranch(int sourceBranchId, int destinationBranchId) {
		
		// Fetch the source branch from repository
    	Vendor_Branches sourceBranch = vendorbrarepo.findById(sourceBranchId).orElseThrow(() -> new RuntimeException("Source branch not found"));
    // Fetch the destination branch from repository
        Vendor_Branches destinationBranch = vendorbrarepo.findById(destinationBranchId).orElseThrow(() -> new RuntimeException("Destination branch not found"));

        destinationBranch.setQuantity(sourceBranch.getQuantity());

        
    vendorbrarepo.save(destinationBranch);
		
	}

	@Override
	public Vendor_Branches getVendorByVendorId(int vendorId) {
		return vendorbrarepo.findById(vendorId).get();
		
	}
	
	
	public List<Transaction_History> getTransactionsByBranchId(int branchId) {
        List<Transaction_History> allTransactions = trahisrepo.findAll();
        List<Transaction_History> result = new LinkedList<>();
        // Using an iterator to iterate over transactions
        Iterator iterator = (Iterator) allTransactions.iterator();
      //  Iterator i = v.listIterator();
        while (iterator.hasNext()) {
            Transaction_History transaction = (Transaction_History) iterator.next();
            Vendor_Branches branch = transaction.getVendor_branches();
            if (branch != null && branch.getBranch_id() == branchId) {
                result.add(transaction);
            }
        }
        return result;
    }

}
