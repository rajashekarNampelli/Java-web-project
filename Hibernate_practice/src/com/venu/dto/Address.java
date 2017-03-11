package com.venu.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable // To embed Address variables into Table created by Venu
public class Address {
	
	private String street;
	
	@Column(name ="city")
	private String city;
	
	@Column(name ="zipcode")
	private int zip;
	
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
}
