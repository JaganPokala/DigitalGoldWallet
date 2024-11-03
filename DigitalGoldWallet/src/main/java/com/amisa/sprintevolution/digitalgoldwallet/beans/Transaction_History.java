package com.amisa.sprintevolution.digitalgoldwallet.beans;

import java.time.*;
import jakarta.persistence.*;
import com.amisa.sprintevolution.digitalgoldwallet.enums.*;


@Entity
@Table(name = "transaction_history")
public class Transaction_History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	

	
	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type")
	private transaction_type transaction_type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_status")
	private transaction_status transaction_status;
	
	@Column(name = "quantity",nullable = false,columnDefinition = "DECIMAL(10,2)")
	private float quantity;
	
	@Column(name = "amount",nullable = false, columnDefinition = "DECIMAL(18,2)")
	private float amount;
	
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	
	
	
	 @ManyToOne
	 @JoinColumn(name = "user_id") // name of the foreign key column
	 private Users users;
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "branch_id") // name of the foreign key column
	 private Vendor_Branches vendor_branches;


	public int getTransaction_id() {
		return transaction_id;
	}


	public transaction_type getTransaction_type() {
		return transaction_type;
	}


	public void setTransaction_type(transaction_type transaction_type) {
		this.transaction_type = transaction_type;
	}


	public transaction_status getTransaction_status() {
		return transaction_status;
	}


	public void setTransaction_status(transaction_status transaction_status) {
		this.transaction_status = transaction_status;
	}


	public float getQuantity() {
		return quantity;
	}


	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
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


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public Transaction_History(int transaction_id,transaction_type transaction_type,transaction_status transaction_status, float quantity,float amount, LocalDateTime created_at, Users users, Vendor_Branches vendor_branches) {
		super();
		this.transaction_id = transaction_id;
		this.transaction_type = transaction_type;
		this.transaction_status = transaction_status;
		this.quantity = quantity;
		this.amount = amount;
		this.created_at = created_at;
		this.users = users;
		this.vendor_branches = vendor_branches;
	}


	public Transaction_History() {
		super();
	}


	
	
	
	
	
}
