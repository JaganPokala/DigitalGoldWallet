package com.amisa.sprintevolution.digitalgoldwallet.repositories;
import com.amisa.sprintevolution.digitalgoldwallet.beans.*;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
 
public interface VendorsRepository extends JpaRepository<Vendors, Integer>{

 
    List<Vendors> findByContactemail(String contactEmail);
    Vendors findByVendorName(String vendorName);
 
 
}