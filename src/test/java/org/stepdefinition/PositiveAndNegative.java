package org.stepdefinition;

import org.base.classes.Baseclass;
import org.pojo.classes.LoginPOJO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PositiveAndNegative extends Baseclass {
LoginPOJO l;

@Given("user has to launch the  bowser and max the window")
public void user_has_to_launch_the_bowser_and_max_the_window() {
 browserLaunch("chrome");
}

@When("user has to launch the url")
public void user_has_to_launch_the_url() {
   launchUrl("https://www.facebook.com/");
}

@When("user has to enter  username {string}in email field")
public void user_has_to_enter_username_in_email_field(String email) {
	l=new LoginPOJO();
	passText(l.getEmailtxt(), email);
   
}

@When("user has to enter  password in password field{string}")
public void user_has_to_enter_password_in_password_field(String pass) {
   l=new LoginPOJO();
   passText(l.getPasstxt(), pass);
}

@When("click the login button")
public void click_the_login_button() {
  l= new LoginPOJO();
  click(l.getLoginbtn());
}

@Then("close the browser")
public void close_the_browser() {
  
}
}
