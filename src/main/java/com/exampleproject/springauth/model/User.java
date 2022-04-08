package com.exampleproject.springauth.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

	@Id
	private String email;

	private String firstName;
	private String lastName;
	private String dateOfBirth;

	private HashMap<String, String> contactInfo = new HashMap<String, String>();

	private HashMap<String, String> address = new HashMap<String, String>();

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
		return contactInfo.get("email");
	}

	public void setEmail(String email) {
		this.email = email;
		if (this.contactInfo.keySet().contains("email")) {
			contactInfo.replace("email", email);
		} else {
			contactInfo.put("email", email);
		}
	}

	public String getMobilePhone() {
		return contactInfo.get("mobilePhone");
	}

	public void setMobilePhone(String mobilePhone) {
		if (this.contactInfo.keySet().contains("mobilePhone")) {
			contactInfo.replace("mobilePhone", mobilePhone);
		} else {
			contactInfo.put("mobilePhone", mobilePhone);
		}
	}

	public String getHomePhone() {
		return contactInfo.get("homePhone");
	}

	public void setHomePhone(String homePhone) {
		if (this.contactInfo.keySet().contains("homePhone")) {
			contactInfo.replace("homePhone", homePhone);
		} else {
			contactInfo.put("homePhone", homePhone);
		}
	}

	public String getAddressLine1() {
		return address.get("addressLine1");
	}

	public void setAddressLine1(String addressLine1) {
		if (this.address.keySet().contains("addressLine1")) {
			address.replace("addressLine1", addressLine1);
		} else {
			address.put("addressLine1", addressLine1);
		}
	}

	public String getAddressLine2() {
		return address.get("addressLine2");
	}

	public void setAddressLine2(String addressLine2) {
		if (this.address.keySet().contains("addressLine2")) {
			address.replace("addressLine2", addressLine2);
		} else {
			address.put("addressLine2", addressLine2);
		}
	}

	public String getState() {
		return address.get("state");
	}

	public void setState(String state) {
		if (this.address.keySet().contains("state")) {
			address.replace("state", state);
		} else {
			address.put("state", state);
		}
	}

	public String getZip() {
		return address.get("zip");
	}

	public void setZip(String zip) {
		if (this.address.keySet().contains("zip")) {
			address.replace("zip", zip);
		} else {
			address.put("zip", zip);
		}
	}

}
