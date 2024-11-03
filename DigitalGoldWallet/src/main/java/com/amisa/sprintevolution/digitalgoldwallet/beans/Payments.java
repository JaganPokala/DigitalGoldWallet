package com.amisa.sprintevolution.digitalgoldwallet.beans;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.amisa.sprintevolution.digitalgoldwallet.enums.*;

@Entity
@Table(name = "payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id" )
	private int payment_id;


	@Column(name = "amount", columnDefinition = "DECIMAL(18,2)", nullable = false)
	private float amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private payment_method payment_method;
 
	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type")
	private transaction_type transaction_type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private payment_status payment_status;
	
	
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
 
	 @ManyToOne(cascade=CascadeType.PERSIST)
	 @JoinColumn(name = "user_id",nullable = false ,referencedColumnName = "user_id") // name of the foreign key column
	 private Users users;

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public payment_method getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(payment_method payment_method) {
		this.payment_method = payment_method;
	}

	public transaction_type getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(transaction_type transaction_type) {
		this.transaction_type = transaction_type;
	}

	public payment_status getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(payment_status payment_status) {
		this.payment_status = payment_status;
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


 
 
	public Payments(int payment_id, float amount,payment_method payment_method,transaction_type transaction_type,payment_status payment_status, LocalDateTime created_at,Users users) {
		super();
		this.payment_id = payment_id;
		this.amount = amount;
		this.payment_method = payment_method;
		this.transaction_type = transaction_type;
		this.payment_status = payment_status;
		this.created_at = created_at;
		this.users = users;
	}

	public Payments() {
	}
 
 
}
