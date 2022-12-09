package org.stepdefinition;

import org.base.classes.Baseclass;
import org.pojo.classes.LoginPOJO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBTask extends Baseclass{
	LoginPOJO l;
	@Given("user has to launch the chrome bowser and max the window")
	public void user_has_to_launch_the_chrome_bowser_and_max_the_window() {
	    browserLaunch("chrome");
	}

	@When("user has to launch the fb application in browser")
	public void user_has_to_launch_the_fb_application_in_browser() {
	    launchUrl("https://www.facebook.com/");
	}

	@When("user has to enter invalid username in email field")
	public void user_has_to_enter_invalid_username_in_email_field() {
	   l=new LoginPOJO();
	   passText(l.getEmailtxt(), "haripriya");
	}

	@When("user has to enter invalid password in password field")
	public void user_has_to_enter_invalid_password_in_password_field() {
		l=new LoginPOJO();
	   passText(l.getPasstxt(), "124563245");
	}

	@When("user has to click the login button")
	public void user_has_to_click_the_login_button() {
	  click(l.getLoginbtn());
	}

	@Then("user has to close the browser")
	public void user_has_to_close_the_browser() {
	    closeTheBrowser();
	}


}
