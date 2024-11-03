package com.amisa.sprintevolution.digitalgoldwallet.repositories;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.amisa.sprintevolution.digitalgoldwallet.beans.Addresses;
 
 
@Repository
public interface AddressRepository extends JpaRepository<Addresses, Integer> {
	List<Addresses> findById(int address_id);
	List<Addresses> findByCity(String city);
    List<Addresses> findByState(String state);
    List<Addresses> findByCountry(String country);

}