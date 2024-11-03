package com.amisa.sprintevolution.digitalgoldwallet.beans;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "user_id" )
	private int user_id;
	
	@Column(name = "email", length = 100 , unique = true ,nullable = false)
	private String email;
	
	@Column(name = "name", length = 100 , nullable = false)
	private String name;

//	private int address_id ;
	
	@Column(name = "balance",  columnDefinition = "DECIMAL(18,2) DEFAULT 0.00")
	private float balance;
	 
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	 
	 @ManyToOne(cascade=CascadeType.PERSIST)
	 @JoinColumn(name = "address_id" ,nullable = false,referencedColumnName = "address_id") // name of the foreign key column nullable = false
	 private Addresses addresses;
	
	 @OneToMany(mappedBy = "users")
	  private List<Virtual_Gold_Holdings> virtualGoldHoldings;
	 
	 
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public int getAddress_id() {
//		return address_id;
//	}
//	public void setAddress_id(int address_id) {
//		this.address_id = address_id;
//	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
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
	public Users(int user_id, String email, String name, float balance, LocalDateTime created_at, Addresses addresses) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.name = name;
		this.balance = balance;
		this.created_at = created_at;
		this.addresses = addresses;
	}
	public Users() {
	
	}
	
}
