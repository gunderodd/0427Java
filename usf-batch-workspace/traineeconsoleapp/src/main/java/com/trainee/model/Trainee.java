package com.trainee.model;

import java.util.Date;

public class Trainee {
private String id;
private String name;
private long contact;
private String email;
private Date dob;
private String city;

public Trainee() {
	// TODO Auto-generated constructor stub
}

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

public long getContact() {
	return contact;
}

public void setContact(long contact) {
	this.contact = contact;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

@Override
public String toString() {
	return "Trainee [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", dob=" + dob
			+ ", city=" + city + "]";
}

}
