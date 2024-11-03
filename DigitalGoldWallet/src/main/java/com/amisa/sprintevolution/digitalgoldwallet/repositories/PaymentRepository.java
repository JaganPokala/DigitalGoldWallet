package com.amisa.sprintevolution.digitalgoldwallet.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.amisa.sprintevolution.digitalgoldwallet.beans.*;
import com.amisa.sprintevolution.digitalgoldwallet.enums.payment_method;
import com.amisa.sprintevolution.digitalgoldwallet.enums.transaction_type;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Integer> {

 
	Payments findByUsers(Users uid);

	 @Query("SELECT p FROM Payments p WHERE p.users.user_id = :userId")
	    List<Payments> findByUserId(@Param("userId") int userId);




	 @Query("SELECT p FROM Payments p WHERE p.payment_method = :paymentMethod")
	    List<Payments> findByPaymentMethod(@Param("paymentMethod") payment_method paymentMethod);
}