package com.Yatra.bean;

public class SighinUpdetail {
	private String  FistName;
	private String Lastname;
	private double   MobileNo;
	private String emailId;
	private String password;
	private String conformpassword;

	public String getFistName() {
		return FistName;
	}
	public void setFistName(String fistName) {
		FistName = fistName;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public double getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(double mobileNo) {
		this.MobileNo =  mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConformpassword() {
		return conformpassword;
	}
	public void setConformpassword(String conformpassword) {
		this.conformpassword = conformpassword;
	}
	
	

}
