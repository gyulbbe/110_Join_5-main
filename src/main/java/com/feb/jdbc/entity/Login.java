package com.feb.jdbc.entity;

import org.apache.ibatis.type.Alias;

@Alias("Login")
public class Login {
	String memberId;
	String passWd;
	String email;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Login [memberId=" + memberId + ", passWd=" + passWd + ", email=" + email + "]";
	}
}
