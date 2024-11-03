package com.amisa.sprintevolution.digitalgoldwallet.serviceimplement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Physical_Gold_Transaction;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Virtual_Gold_Holdings;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.PhysicalGoldTransRepository;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.VirtualGoldHoldingRepository;
import com.amisa.sprintevolution.digitalgoldwallet.services.VirtualGoldHoldingService;

@Service
public class VirtualGoldHoldingImpl implements VirtualGoldHoldingService {

	@Autowired
	private VirtualGoldHoldingRepository virtgoldHoldrepo;

	private PhysicalGoldTransRepository pgtrepo;
	
	
	
	
	public VirtualGoldHoldingImpl() {
		super();
	}

	public VirtualGoldHoldingImpl(VirtualGoldHoldingRepository virtgoldHoldrepo, PhysicalGoldTransRepository pgtrepo) {
		super();
		this.virtgoldHoldrepo = virtgoldHoldrepo;
		this.pgtrepo = pgtrepo;
	}

	@Override
	public List<Virtual_Gold_Holdings> getAllVirtualGoldHoldings() {
		return virtgoldHoldrepo.findAll();
	}

	@Override
	public Virtual_Gold_Holdings getVirtualGoldHoldingById(int holdingId) {
		return virtgoldHoldrepo.findById(holdingId).orElse(null);
	}

	@Override
	public Optional<Virtual_Gold_Holdings> getVirtualGoldHoldingsByUserId(int userId) {
		// TODO Auto-generated method stub
		return virtgoldHoldrepo.findById(userId);
	}

	// not working
	public List<Virtual_Gold_Holdings> findByUserIdAndVendorId(int userId, int vendorId) {
		// TODO Auto-generated method stub
		 return virtgoldHoldrepo.findByUserIdAndVendorId(userId, vendorId);
	}

	@Override
	public Virtual_Gold_Holdings addVirtualGoldHolding(Virtual_Gold_Holdings holding) {
		return virtgoldHoldrepo.save(holding);
	}

	@Override
	public Virtual_Gold_Holdings convertToPhysical(int holdingId) {

		
	        return null;
    
	}
	


	@Override
	public Virtual_Gold_Holdings updateVendor(int branchid, Virtual_Gold_Holdings updatedVendor) {
		return virtgoldHoldrepo.save(updatedVendor);

	}

	@Override
	public Virtual_Gold_Holdings updateVirtualGoldHolding(int holdingId, Virtual_Gold_Holdings holding) {
		Virtual_Gold_Holdings existingHolding = virtgoldHoldrepo.findById(holdingId).orElse(null);
		if (existingHolding != null) {
			existingHolding.setQuantity(holding.getQuantity());
			existingHolding.setCreated_at(holding.getCreated_at());
			return virtgoldHoldrepo.save(existingHolding);
		}
		return null;

	}

	

}
