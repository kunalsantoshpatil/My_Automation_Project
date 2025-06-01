package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.BaseClass;

public class DDTstep {

	WebDriver driver;
	LoginPage lp;

	@Given("User navigates to the login page")
	public void user_navigates_to_login_page() {
		driver = Hooks.getDriver();
		lp = new LoginPage(driver);
		BaseClass.Verify_HomePage();
	}

	@When("User enters email {string} and password {string}")
	public void user_enters_credentials(String email, String password) {
		lp.click_on_signup_login();
//    	BaseClass.Verify_signup_loginPage();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@And("clicks on the login button")
	public void clicks_on_login_button() throws InterruptedException {
		lp.click_on_Login();
	}

	@Then("User should see message {string}")
	public void User_should_see_message(String message) throws InterruptedException {
		Assert.assertEquals(message, driver.getTitle());
	}

}
