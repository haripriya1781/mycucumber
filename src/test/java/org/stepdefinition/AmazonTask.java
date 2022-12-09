package org.stepdefinition;

import java.util.List;

import org.base.classes.Baseclass;
import org.pojo.classes.AmazonLoginPOJO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AmazonTask extends Baseclass {
	AmazonLoginPOJO al;
	@Given("To launch the browser and maximize the window")
	public void to_launch_the_browser_and_maximize_the_window() {
	   browserLaunch("chrome");
	}

	@When("To launch the Amazon login page")
	public void to_launch_the_Amazon_login_page() {
	    launchUrl("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	}

	@When("To enter the  valid username in the email field")
	public void to_enter_the_valid_username_in_the_email_field(DataTable d) {
	    al = new AmazonLoginPOJO();
	    List<String> li = d.asList();
	    String email = li.get(0);
	    passText(al.getEmailtxt(),email );
	}

	@When("click the continue button")
	public void click_the_continue_button() {
		 al = new AmazonLoginPOJO();
	   click(al.getCont());
	}

	@When("To enter the invalid password in the password field")
	public void to_enter_the_invalid_password_in_the_password_field(DataTable dd) {
		 al = new AmazonLoginPOJO();
		 List<List<String>> lis = dd.asLists();
		 String pass = lis.get(1).get(2);
		 passText(al.getPasstxt(), pass);
	}

	@When("click the signin button")
	public void click_the_signin_button() {
		 al = new AmazonLoginPOJO();
		 click(al.getSign());
	}

	

	
}
