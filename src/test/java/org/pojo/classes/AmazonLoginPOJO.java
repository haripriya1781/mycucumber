package org.pojo.classes;

import org.base.classes.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPOJO extends Baseclass{
	public AmazonLoginPOJO() {
		PageFactory.initElements(driver, this);
		}
	@FindBy(id ="ap_email")
	private WebElement emailtxt;
	@FindBy(id="continue")
	private WebElement cont;
	
	@FindBy(id="ap_password")
	private WebElement passtxt;
	@FindBy(id = "signInSubmit")
	private WebElement sign;
	
	public WebElement getEmailtxt() {
		return emailtxt;
	}
	public WebElement getCont() {
		return cont;
	}
	public WebElement getPasstxt() {
		return passtxt;
	}
	public WebElement getSign() {
		return sign;
	}
	

}
