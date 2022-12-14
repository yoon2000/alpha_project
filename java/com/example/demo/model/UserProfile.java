package com.example.demo.model;

public class UserProfile {
	private String id;
	private String name;
	private String phone;
	private String address;
	
	//spring tool이 제공하는 sourcecode generate를 이용하여 생성자를 만듬
	public UserProfile(String id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	//spring tool generate 활용하여 getter setter 만듬
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
