package com.amisa.sprintevolution.digitalgoldwallet.beans;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_branches")
public class Vendor_Branches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branch_id;

	@Column(name = "quantity", columnDefinition = "DECIMAL(18,2) DEFAULT 0.00",nullable = false)
	private float quantity;
	
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	
	 @ManyToOne
	 @JoinColumn(name = "address_id") 
	 private Addresses addresses;
	
	 @ManyToOne
	 @JoinColumn(name = "vendor_id")
	 private Vendors vendors;

 
	
	public int getBranch_id() {
		return branch_id;
	}
 
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
 
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
 
 
	public Addresses getAddresses() {
		return addresses;
	}
 
	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}
 
	public Vendors getVendors() {
		return vendors;
	}
 
	public void setVendors(Vendors vendors) {
		this.vendors = vendors;
	}
 
	public Vendor_Branches() {
	}
 
	public Vendor_Branches(int branch_id, float quantity, LocalDateTime created_at, Addresses addresses,
			Vendors vendors) {
		this.branch_id = branch_id;
		this.quantity = quantity;
		this.created_at = created_at;
		this.addresses = addresses;
		this.vendors = vendors;
	}
 
 
	

 
 
}