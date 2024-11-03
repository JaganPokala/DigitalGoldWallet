package com.amisa.sprintevolution.digitalgoldwallet.repositories;
import com.amisa.sprintevolution.digitalgoldwallet.beans.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import java.util.List;
 
@Repository
public interface VirtualGoldHoldingRepository extends JpaRepository<Virtual_Gold_Holdings, Integer> {
 
	//	List<Virtual_Gold_Holdings> findByUsersUser_id(int userId);
		Virtual_Gold_Holdings findByUsers(Users userid);
	
	  @Query("SELECT vh FROM Virtual_Gold_Holdings vh WHERE vh.users.user_id = id")
	   List<Virtual_Gold_Holdings> findByUsersUserId(int userId);

	   
	   @Query("SELECT vh FROM Virtual_Gold_Holdings vh WHERE vh.users.user_id = ?1 or vh.vendor_branches.branch_id = ?2")
		List<Virtual_Gold_Holdings> findByUserIdAndVendorId(int userId, int vendorId);
}