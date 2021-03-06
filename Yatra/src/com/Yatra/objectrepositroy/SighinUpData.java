package com.Yatra.objectrepositroy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/*@Authore:Tapana 
 *@Version:1.0 
 *@Descrptinon:All the sighup locater store hear.
 * 
 * */
public class SighinUpData {
	//sigh up button locater 
	@FindBy(xpath="//input[@value='Sign Up']")
	private WebElement getSighinup;
	//first name of locater
	@FindBy(id="fname")
	private WebElement getFirstName;
	//last name of lacater
	@FindBy(id="lname")
	private WebElement getlastname;
	//mobile no of lacater
	@FindBy(id="mobile")
	private WebElement getMobile;
	//email id locater
	@FindBy(id="pemail")
	private WebElement getEmail;
	//password  locater
	@FindBy(id="password")
	private WebElement getPassword;
	//confermation password
	@FindBy(id="cpassword")
	private WebElement getConpassword;
	//condisation radiobutton
	@FindBy(id="offers")
	private WebElement getCondradioButton;
	//regrister button;
	@FindBy(id="register")
	private WebElement getregisterButon;
	
	//anthore page detail..
	//title button
	@FindBy(id="title")
	private WebElement title;
	//first name
	@FindBy(id="fname")
	private WebElement firstname;
	//Last name
	@FindBy(id="lname")
	private WebElement lastName;
	//mobile no
	@FindBy(id="mobile")
	private WebElement mobile;
	//sms alart button
	@FindBy(id="subscriptionList1")
	private WebElement smsradioButton;
	//Low fear aleart
	@FindBy(id="subscriptionList2")
	private WebElement LowFearAlart;
	//email id name
	@FindBy(id="pemail")
	private WebElement emailId;
	@FindBy(xpath="//a[text()='Change Password']")
	private WebElement ChangePasswordLink;
	//secandary email id
	@FindBy(id="secondary_email")
	private WebElement secandryEmail;
	//adress deatil text
	@FindBy(id="address")
	private WebElement address;
	//city of text
	@FindBy(id="city")
	private WebElement city;
	//state of selecttion 
	@FindBy(id="state")
	private WebElement state;
	//pin code 
	@FindBy(id="pincode")
	private WebElement pincode;
	//update button 
	@FindBy(id="updateProfile")
	private WebElement updateProfileButton;
	//reset button
	@FindBy(id="//input[@class='resetButtonHeight']")
	private WebElement resetButtonHeight;
	
	
	
	
	public WebElement getTitle() {
		return title;
	}
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getSmsradioButton() {
		return smsradioButton;
	}
	public WebElement getLowFearAlart() {
		return LowFearAlart;
	}
	public WebElement getEmailId() {
		return emailId;
	}
	public WebElement getChangePasswordLink() {
		return ChangePasswordLink;
	}
	public WebElement getSecandryEmail() {
		return secandryEmail;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getState() {
		return state;
	}
	public WebElement getPincode() {
		return pincode;
	}
	public WebElement getUpdateProfileButton() {
		return updateProfileButton;
	}
	public WebElement getResetButtonHeight() {
		return resetButtonHeight;
	}
	public WebElement getGetSighinup() {
		return getSighinup;
	}
	public WebElement getGetFirstName() {
		return getFirstName;
	}
	public WebElement getGetlastname() {
		return getlastname;
	}
	public WebElement getGetMobile() {
		return getMobile;
	}
	public WebElement getGetEmail() {
		return getEmail;
	}
	public WebElement getGetPassword() {
		return getPassword;
	}
	public WebElement getGetConpassword() {
		return getConpassword;
	}
	public WebElement getGetCondradioButton() {
		return getCondradioButton;
	}
	public WebElement getGetregisterButon() {
		return getregisterButon;
	}
}
