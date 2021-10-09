package com.customerpage.demo;

import java.io.Serializable;
import java.sql.Date;


public class Customer implements Serializable{
	
	private int id;
	private String pswd;
	private String name;
	private Long phone;
	private String interestedIn;//clothes,electronics,artsandcrafts
	private String city;
	private String createdDate;
	private String modifiedDate;
	
	public Customer(){
		
	}

	public Customer(int id, String pswd, String name, Long phone, String city,String interestedIn,String createdDate,String modifiedDate) {
		super();
		this.id = id;
		this.pswd = pswd;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.interestedIn=interestedIn;
		this.createdDate=createdDate;
		this.modifiedDate=modifiedDate;
	}

	


	@Override
	public String toString() {
		return "Customer [id=" + id + ", pswd=" + pswd + ", name=" + name + ", phone=" + phone + ", interestedIn="
				+ interestedIn + ", city=" + city + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInterestedIn() {
		return interestedIn;
	}

	public void setInterestedIn(String interestedIn) {
		this.interestedIn = interestedIn;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
	
	
	
}
