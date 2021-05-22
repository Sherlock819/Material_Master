package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserVerification {

	@Id
	@Column(name = "email", unique=true, columnDefinition="VARCHAR(64)")
	private String email;
	
	@Column(columnDefinition="INT(6)")
    private int verificationCode;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}

	
}
