package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
@PrimaryKeyJoinColumn(name = "personID")
public class Admin extends Person{
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
