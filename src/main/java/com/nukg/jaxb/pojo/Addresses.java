package com.nukg.jaxb.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "addresses")
public class Addresses {

	private Address[] address;

	@XmlElement(name = "address")
	public Address[] getAddress() {
		return address;
	}

	public void setAddress(Address[] address) {
		this.address = address;
	}
	
	
}
