package com.amisa.sprintevolution.digitalgoldwallet.services;

import java.util.List;
import java.util.Optional;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Virtual_Gold_Holdings;

public interface VirtualGoldHoldingService {
	
	public List<Virtual_Gold_Holdings> getAllVirtualGoldHoldings();
	public Virtual_Gold_Holdings getVirtualGoldHoldingById(int holdingId);
	public Optional<Virtual_Gold_Holdings> getVirtualGoldHoldingsByUserId(int userId);
	public List<Virtual_Gold_Holdings> findByUserIdAndVendorId(int userId, int vendorId);
	public Virtual_Gold_Holdings addVirtualGoldHolding(Virtual_Gold_Holdings holding);
	public Virtual_Gold_Holdings convertToPhysical(int holdingId);
	public Virtual_Gold_Holdings updateVendor(int branchid,Virtual_Gold_Holdings updatedVendor);
	public Virtual_Gold_Holdings updateVirtualGoldHolding(int holdingId, Virtual_Gold_Holdings holding);

	
	
	
	
}
