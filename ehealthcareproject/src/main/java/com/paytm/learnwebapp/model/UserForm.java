package com.paytm.learnwebapp.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

	@NotNull
	private int id;
	
	@NotNull
	@Size(min=2, max=30)
	private String name;

	@NotNull
	private String jobrole;
	
	@NotNull
	private String email;
	
	@NotNull
	private long phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", name=" + name + ", jobrole=" + jobrole + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
}
