package com.amisa.sprintevolution.digitalgoldwallet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;
import com.amisa.sprintevolution.digitalgoldwallet.enums.*;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<Transaction_History, Integer> {
	Transaction_History findByUsers(Users userId);

	Transaction_History findById(int transation_id);

	@Modifying
	@Query("SELECT th FROM Transaction_History th WHERE th.transaction_type = :transaction_type")
	List<Transaction_History> findByTransactionType(@Param("transaction_type") transaction_type type);

	@Query("SELECT th FROM Transaction_History th WHERE th.users.user_id = :userId")
	List<Transaction_History> findByUsersUserId(int userId);
	
	
}
