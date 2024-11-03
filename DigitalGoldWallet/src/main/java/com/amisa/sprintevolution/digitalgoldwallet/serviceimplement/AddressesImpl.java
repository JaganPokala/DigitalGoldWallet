package com.amisa.sprintevolution.digitalgoldwallet.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Addresses;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.AddressRepository;
import com.amisa.sprintevolution.digitalgoldwallet.services.AddressesService;

@Service
public class AddressesImpl implements AddressesService {
	
	@Autowired
	private AddressRepository addrrepo;
	
	
	
	public AddressesImpl(AddressRepository addrrepo) {
		super();
		this.addrrepo = addrrepo;
	}

	public AddressesImpl() {
		super();
	}


	@Override
	public List<Addresses> getAllAddresses() {
		return addrrepo.findAll();
	}

	@Override
	public List<Addresses> getAddressById(int id) {
		return addrrepo.findById(id);
	}

	@Override
	public Addresses addAddress(Addresses address) {
		return addrrepo.save(address);
	}

	@Override
	public Addresses updateAddress(int id, Addresses address) {
		if (addrrepo.existsById(id)) {
            //address.setAddress_id(id);
            return addrrepo.save(address);
        }
        return null;
	}

}
