package com.amisa.sprintevolution.digitalgoldwallet.beans;
import java.time.LocalDateTime;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "virtual_gold_holdings")
public class Virtual_Gold_Holdings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int holding_id;
 

	@Column(name = "quantity", columnDefinition = "DECIMAL(18,2)",nullable = false)
	private float quantity;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;

	@ManyToOne(cascade=CascadeType.PERSIST)
	 @JoinColumn(name = "user_id" ,referencedColumnName = "user_id") // name of the foreign key column
	 private Users users;
	 @ManyToOne(cascade=CascadeType.PERSIST)	 
	 @JoinColumn(name = "branch_id",referencedColumnName = "branch_id") // name of the foreign key column
	 private Vendor_Branches vendor_branches;
 
	public int getHolding_id() {
		return holding_id;
	}
 
	public void setHolding_id(int holding_id) {
		this.holding_id = holding_id;
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
 
	public Users getUsers() {
		return users;
	}
 
	public void setUsers(Users users) {
		this.users = users;
	}
 
	public Vendor_Branches getVendor_branches() {
		return vendor_branches;
	}
 
	public void setVendor_branches(Vendor_Branches vendor_branches) {
		this.vendor_branches = vendor_branches;
	}
	public void setVendorId(int vendorId) {
        vendor_branches.setBranch_id(vendorId);
    }
 
	public Virtual_Gold_Holdings(int holding_id, float quantity, LocalDateTime created_at, Users users,
			Vendor_Branches vendor_branches) {
		super();
		this.holding_id = holding_id;
		this.quantity = quantity;
		this.created_at = created_at;
		this.users = users;
		this.vendor_branches = vendor_branches;
	}
 
	public Virtual_Gold_Holdings() {
		super();
	}


 
}