package com.amisa.sprintevolution.digitalgoldwallet.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Payments;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Physical_Gold_Transaction;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Virtual_Gold_Holdings;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.*;
import com.amisa.sprintevolution.digitalgoldwallet.repositories.*;
import com.amisa.sprintevolution.digitalgoldwallet.services.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
public class UsersImpl implements UserService {
	
	
	@Autowired
	private UsersRepository usrrepo;
	@Autowired
	private VirtualGoldHoldingRepository vghrepo;
	@Autowired
	private PhysicalGoldTransRepository pgtrepo;
	@Autowired
	private TransactionHistoryRepository threpo;
	@Autowired
	private PaymentRepository payrepo;
	
	

	@Override
	public List<Users> getAllUsers() {
		return usrrepo.findAll();
	}

	@Override
	public Users getUserById(int userId) {
		return usrrepo.findById(userId).orElseThrow(() -> new UserIdNotFoundException("User with ID " + userId + " not found"));
	}

	@Override
	public List<Users> getUsersByName(String name) {
		 List<Users> nameusers = usrrepo.findByName(name);
	        return nameusers;
	}

	@Override
	public float getUserBalance(int userId) {
		Users user = usrrepo.findById(userId)
                .orElseThrow(() -> new UserIdNotFoundException("User with ID " + userId + " not found"));
return user.getBalance();
	}

	@Override
	public List<Users> getUserBycity(String city) {
		return usrrepo.findByAddressesCity(city);
	}

	@Override
	public List<Users> getUserBystate(String state) {
		return usrrepo.findByAddressesState(state);
	}

	@Override
	public Users updateuser(int id, Users usr) {
		if((usrrepo.existsById(id))) {
			usr.setUser_id(id);
			return usrrepo.save(usr);
		}
		return null;
	}

	@Override
	public Users updateBalance(int id, float bal, Users usr) {
		 if(usrrepo.existsById(id)) {
			 	usr.setUser_id(id);
			   usr.setBalance(bal);
			   return usrrepo.save(usr);
		   }  
		   return null;
	}

	@Override
	public Users addUser(Users user) {
		return usrrepo.save(user);
	}

	@Override
	public Users updateAddress(int userId, int addressId, Users user) {
		 Users existingUser = usrrepo.findById(userId).orElse(null);
	        if (existingUser != null && existingUser.getAddresses() != null && existingUser.getAddresses().getAddress_id() == addressId) {
	            existingUser.getAddresses().setStreet(user.getAddresses().getStreet());
	            existingUser.getAddresses().setCity(user.getAddresses().getCity());
	            existingUser.getAddresses().setState(user.getAddresses().getState());
	            existingUser.getAddresses().setPostal_code(user.getAddresses().getPostal_code());
	            existingUser.getAddresses().setCountry(user.getAddresses().getCountry());
	            return usrrepo.save(existingUser);
	        } else {
	            return null;
	        }
	}

	@Override
	public float getTotalVirtualGoldHoldingsByUserId(int userId) {
		  Users usrid = usrrepo.getById(userId);
		   Virtual_Gold_Holdings vgh = vghrepo.findByUsers(usrid);
		   float val = 0.0f;
		   if(vgh!=null) {
			   val = vgh.getQuantity();
			 
		   }
		   return val;
	}

	@Override
	public float getPhysicalGoldHoldingByUserId(int userId) {

			
		 float physicalGoldHolding = pgtrepo.getPhysicalGoldHoldingByUserId(userId);
	        
	        return physicalGoldHolding;
	}

	@Override
	public List<Transaction_History> getTransactionsByUserId(int userId) {
		return usrrepo.getTransactionHistoryByUserId(userId);
	}

	@Override
	public List<Payments> getPaymentsByUid(int userId) {
		// TODO Auto-generated method stub
		return usrrepo.getPaymentsByUserId(userId);
	}

}
