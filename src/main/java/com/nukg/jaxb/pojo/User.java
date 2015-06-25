package com.nukg.jaxb.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
	private String userid;
	private String name;
	private String phone;
	
	private Addresses addresses;

	@XmlElement(name = "id")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement(name = "addresses")
	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}
	
	

}
