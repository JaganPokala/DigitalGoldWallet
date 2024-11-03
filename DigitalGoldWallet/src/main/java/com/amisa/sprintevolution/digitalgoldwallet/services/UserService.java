package com.amisa.sprintevolution.digitalgoldwallet.services;

import java.util.List;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Payments;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;

public interface UserService {
	public List<Users> getAllUsers();
	public Users getUserById(int userId);
	 public List<Users> getUsersByName(String name);
	 public float getUserBalance(int userId);
	 public List<Users> getUserBycity(String city);
	 public List<Users> getUserBystate(String state);
	 public Users updateuser(int id, Users usr);
	 public Users updateBalance(int id, float bal,Users usr);
	 public Users addUser(Users user);
	 public Users updateAddress(int userId, int addressId, Users user);
	 public float getTotalVirtualGoldHoldingsByUserId(int userId);
	 public float getPhysicalGoldHoldingByUserId(int userId);
	 public List<Transaction_History> getTransactionsByUserId(int userId);
	 public List<Payments> getPaymentsByUid(int userId);
}
