package com.amisa.sprintevolution.digitalgoldwallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.amisa.sprintevolution.digitalgoldwallet.beans.*;

import jakarta.transaction.Transactional;

@Repository
public interface PhysicalGoldTransRepository extends JpaRepository<Physical_Gold_Transaction, Integer> {

//	Physical_Gold_Transaction findByUsers(Users userid);

	Physical_Gold_Transaction findById(int transaction_id);

	@Query("SELECT t FROM Physical_Gold_Transaction t WHERE t.user.user_id = :userId")
	List<Physical_Gold_Transaction> findByUserUserId(@Param("userId") int userId);

	@Query("SELECT t FROM Physical_Gold_Transaction t WHERE t.vendor_branches.branch_id = :branchId")
	List<Physical_Gold_Transaction> findByVendorBranchesBranchId(@Param("branchId") int branchId);

	@Query("SELECT t FROM Physical_Gold_Transaction t WHERE t.addresses.city = :city")
	List<Physical_Gold_Transaction> findByAddressesCity(@Param("city") String city);

	@Query("SELECT t FROM Physical_Gold_Transaction t WHERE t.addresses.state = :state")
	List<Physical_Gold_Transaction> findByAddressesState(@Param("state") String state);

	@Query("SELECT SUM(p.quantity) FROM Physical_Gold_Transaction p WHERE p.user.user_id = :userId")
	Float getPhysicalGoldHoldingByUserId(int userId);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO physical_gold_transactions (quantity, created_at, user_id, branch_id) "
			+ "VALUES (:quantity, CURRENT_TIMESTAMP, :userId, :branchId)", nativeQuery = true)
	void savePhysicalTransaction(@Param("userId") int userId, @Param("branchId") int branchId,
			@Param("quantity") float quantity);

}