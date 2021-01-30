package com.paytm.learnwebapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	private String id;
	//private String username;
	//private String password;
	private String name;
	private String jobrole;
	private String email;
	private String phone;
	
	public User(String id, /*String username, String password,*/ String name, String jobrole, String email, String phone)
	{
		this.id = id;
		//this.username = username;
		//this.password = password;
		this.name = name;
		this.jobrole = jobrole;
		this.email = email;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", jobrole=" + jobrole + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
}
