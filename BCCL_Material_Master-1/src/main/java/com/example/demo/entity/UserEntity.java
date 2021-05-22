package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


//aliasing - bean created would named as "a1" instead of alien(default)
//So, along with "@autowire" , it can be injected using "@Qualifier("a1")"
//@Component("a1")
@Entity
public class UserEntity {

	
	private String fname;
	private String lname;
	@Id
	@Column(name = "email", unique=true, columnDefinition="VARCHAR(64)")
	private String email;
	
	private java.sql.Date dob;
	private String password;
	private boolean status = false;
	
	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	
	
	
	
	public void show()
	{
		System.out.println("In SHOW");
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
