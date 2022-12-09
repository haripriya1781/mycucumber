package org.pojo.classes;

import org.base.classes.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOJO extends Baseclass{

	public LoginPOJO() {
		PageFactory.initElements(driver, this);

	}
	@FindBy(id = "email")
	private WebElement emailtxt;
	@FindBy(id = "pass")
	private WebElement passtxt;
	@FindBy(name = "login")
	private WebElement loginbtn;
	@FindBy(xpath = "//a[text()='Create New Account']")
	private WebElement accBtn;
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement radio;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement signup;
	
     
	
	public WebElement getEmailtxt() {
		return emailtxt;
	}
	
	public WebElement getPasstxt() {
		return passtxt;
		
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getAccBtn() {
		return accBtn;
	}

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getSignup() {
		return signup;
	}
	
	
	
}
