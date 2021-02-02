package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	@Column(name="address",length = 50)
	private String address;
	@Column(name="city",length = 100)
	private String city;
	@Column(name="state",length = 100)
	private String state;
	@Column(name="country",length=100)
	private String country;
	@Column(name="zip")
	private  Integer zip;
	
	public Address() {
		System.out.println("Bean "+getClass().getName()+" Created...");
	}
}
