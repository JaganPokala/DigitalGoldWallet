package com.amisa.sprintevolution.digitalgoldwallet.services;

import java.util.List;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Addresses;

public interface AddressesService {
	public List<Addresses> getAllAddresses();
	public List<Addresses> getAddressById(int id);
	public Addresses addAddress(Addresses address);
	public Addresses updateAddress(int id, Addresses address);
	
}
