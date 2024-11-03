package com.amisa.sprintevolution.digitalgoldwallet.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Addresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int address_id;
	
	@Column(name = "street", nullable = false ,length =255)
	private String street;
	
	@Column(name = "city", nullable = false,length =100)
	private String city;
	
	@Column(name = "state", nullable = false,length =100)
	private String state;
	
	@Column(name = "postal_code", length =20)
	private String postal_code;
	
	@Column(name = "country",length =100, nullable = false)
	private String country;
	
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Addresses(int address_id, String street, String city, String state, String postal_code, String country) {
		super();
		this.address_id = address_id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postal_code = postal_code;
		this.country = country;
	}
	public Addresses() {
		super();
	}
	
}
