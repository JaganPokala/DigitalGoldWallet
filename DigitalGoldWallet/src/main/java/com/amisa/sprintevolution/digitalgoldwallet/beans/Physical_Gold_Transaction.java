package com.amisa.sprintevolution.digitalgoldwallet.beans;
import java.time.*;
import jakarta.persistence.*;
 
 
@Entity
@Table(name = "physical_gold_transactions")
public class Physical_Gold_Transaction {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transaction_id ;

	@Column(name = "quantity",nullable = false,columnDefinition = "DECIMAL(18,2)")
	private float quantity;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;

	 @ManyToOne
	 @JoinColumn(name = "user_id") // name of the foreign key column
	 private Users user;

	 @ManyToOne
	 @JoinColumn(name = "branch_id") // name of the foreign key column
	 private Vendor_Branches vendor_branches;

	 @ManyToOne
	 @JoinColumn(name = "delivery_address_id") // name of the foreign key column
	 private Addresses addresses;
 
 
	public Physical_Gold_Transaction(int transaction_id, float quantity, LocalDateTime created_at, Users user,
			Vendor_Branches vendor_branches, Addresses addresses) {
		super();
		this.transaction_id = transaction_id;
		this.quantity = quantity;
		this.created_at = created_at;
		this.user = user;
		this.vendor_branches = vendor_branches;
		this.addresses = addresses;
	}
 
 
	public Physical_Gold_Transaction() {
		super();
	}
 
 
	public int getTransaction_id() {
		return transaction_id;
	}
 
 
//	public void setTransaction_id(int transaction_id) {
//		this.transaction_id = transaction_id;
//	}
 
 
	public float getQuantity() {
		return quantity;
	}
 
 
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
 
 
	public LocalDateTime getCreated_at() {
		return created_at;
	}
 
 
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
 
 
	public Users getUser() {
		return user;
	}
 
 
	public void setUser(Users user) {
		this.user = user;
	}
 
 
	public Vendor_Branches getVendor_branches() {
		return vendor_branches;
	}
 
 
	public void setVendor_branches(Vendor_Branches vendor_branches) {
		this.vendor_branches = vendor_branches;
	}
 
 
	public Addresses getAddresses() {
		return addresses;
	}
 
 
	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

 
	
}