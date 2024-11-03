package com.amisa.sprintevolution.digitalgoldwallet.beans;
import java.time.*;
 
import jakarta.persistence.*;
 
 
@Entity
@Table(name = "vendors")
public class Vendors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendor_id;
	
	@Column(name = "vendor_name", length = 100, nullable = false)
	private String vendorName;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "contact_person_name" , length = 100)
	private String contact_person_name;
	
	@Column(name = "contact_email" , length = 100)
	private String contactemail;
	
	@Column(name = "contact_phone" , length = 20)
	private String contact_phone;
	
	
	@Column(name = "website_url" , length = 255)
	private String website_url;
	
	@Column(name = "total_gold_quantity",  columnDefinition = "DECIMAL(18,2) DEFAULT 0.00",nullable = false)
	private float total_gold_quantity;
	
	@Column(name = "current_gold_price", columnDefinition = "DECIMAL(18,2) DEFAULT 5700.00",nullable = false)
	private float current_gold_price;
	
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact_person_name() {
		return contact_person_name;
	}

	public void setContact_person_name(String contact_person_name) {
		this.contact_person_name = contact_person_name;
	}

	public String getContactemail() {
		return contactemail;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getWebsite_url() {
		return website_url;
	}

	public void setWebsite_url(String website_url) {
		this.website_url = website_url;
	}

	public float getTotal_gold_quantity() {
		return total_gold_quantity;
	}

	public void setTotal_gold_quantity(float total_gold_quantity) {
		this.total_gold_quantity = total_gold_quantity;
	}

	public float getCurrent_gold_price() {
		return current_gold_price;
	}

	public void setCurrent_gold_price(float current_gold_price) {
		this.current_gold_price = current_gold_price;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public Vendors(int vendor_id, String vendorName, String description, String contact_person_name,
			String contactemail, String contact_phone, String website_url, float total_gold_quantity,
			float current_gold_price, LocalDateTime created_at) {
		super();
		this.vendor_id = vendor_id;
		this.vendorName = vendorName;
		this.description = description;
		this.contact_person_name = contact_person_name;
		this.contactemail = contactemail;
		this.contact_phone = contact_phone;
		this.website_url = website_url;
		this.total_gold_quantity = total_gold_quantity;
		this.current_gold_price = current_gold_price;
		this.created_at = created_at;
	}

	public Vendors() {
		super();
	}

	
}