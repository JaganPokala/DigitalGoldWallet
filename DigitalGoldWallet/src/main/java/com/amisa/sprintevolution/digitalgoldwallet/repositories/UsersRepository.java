package com.amisa.sprintevolution.digitalgoldwallet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Payments;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	List<Users> findByName(String name);

	List<Users> findByAddressesCity(String city);

	List<Users> findByAddressesState(String state);

	@Query("SELECT th FROM Transaction_History th WHERE th.users.user_id = :userId")
	List<Transaction_History> getTransactionHistoryByUserId(int userId);
	
	
	@Query("SELECT p FROM Payments p WHERE p.users.user_id = :userId")
    List<Payments> getPaymentsByUserId(int userId);
}