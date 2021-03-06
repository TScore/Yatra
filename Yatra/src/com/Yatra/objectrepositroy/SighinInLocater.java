package com.Yatra.objectrepositroy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/*@Authore:tapana
 *@version:1.0 
 * Descrption:all the sighin locater.licke email text box,password textbox
 * 
 * */
public class SighinInLocater {
	//sighin button
	@FindBy(xpath="//div[@id='signinPanel']/input")
	private WebElement sighiIn;
	//emailId text locater
	@FindBy(id="emailId")
	private WebElement emailIdtextbox;
	//password edit text box
	@FindBy(id="password")
	private WebElement password;
	//forget password link
	@FindBy(xpath="//a[text()='Forgot Password?']")
	private WebElement ForgotPassword;
	@FindBy(name="Sign In")
	private WebElement sighInButton;
	public WebElement getEmailIdtextbox() {
		return emailIdtextbox;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getForgotPassword() {
		return ForgotPassword;
	}

	public WebElement getSighInButton() {
		return sighInButton;
	}

	public WebElement getSighiIn() {
		return sighiIn;
	}
}
