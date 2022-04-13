package com.exampleproject.springregister.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

	@Id
	private String email;

	private String firstName;
	private String lastName;
	private String dateOfBirth;

	private ContactInfo contactInfo;
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		contactInfo.setEmail(email);
	}

	public String getMobilePhone() {
		return contactInfo.getMobilePhone();
	}

	public void setMobilePhone(String mobilePhone) {
		contactInfo.setMobilePhone(mobilePhone);
	}

	public String getHomePhone() {
		return contactInfo.getHomePhone();
	}

	public void setHomePhone(String homePhone) {
		contactInfo.setHomePhone(homePhone);
	}

	public String getAddressLine1() {
		return address.getAddressLine1();
	}

	public void setAddressLine1(String addressLine1) {
		address.setAddressLine1(addressLine1);
	}

	public String getAddressLine2() {
		return address.getAddressLine2();
	}

	public void setAddressLine2(String addressLine2) {
		address.setAddressLine2(addressLine2);
	}

	public String getState() {
		return address.getState();
	}

	public void setState(String state) {
		address.setState(state);
	}

	public String getZip() {
		return address.getZip();
	}

	public void setZip(String zip) {
		address.setZip(zip);
	}

}
