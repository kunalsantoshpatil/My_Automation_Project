package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.BaseClass;

public class LoginSteps {
	WebDriver driver;
	LoginPage lp;
	
	@Given("User has already registered and present on Home page")
	public void user_has_already_registered_and_present_on_home_page() throws InterruptedException {
        driver=Hooks.getDriver();
		lp=new LoginPage(driver);
		BaseClass.Verify_HomePage();
	}

	@When("User click on signup_login button")
	public void user_click_on_signup_login_button() {
		lp.click_on_signup_login();
	}

	@Then("verify login page should open")
	public void verify_login_page_should_open() {
		BaseClass.Verify_signup_loginPage();
		
	}

	@When("User enter valid Credentials")
	public void user_enter_valid_credentials() {
		lp.enter_valid_Email_Password();
	}

	@When("click on Login")
	public void click_on_login() {
		lp.click_on_Login();
	}

	@Then("welcome page should displayed")
	public void welcome_page_should_displayed() {
		BaseClass.Verify_Successfull_Login();
		lp.click_on_LogOut();
		BaseClass.Verify_signup_loginPage();
	}

}
