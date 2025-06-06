package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.RegisterPage;
import utilities.BaseClass;

public class RegisterSteps {
    WebDriver driver;
    RegisterPage rp;

    @Given("User is on Automation-Exercise Home Page")
    public void user_is_on_nop_commerce_home_page() throws InterruptedException {
    	driver=Hooks.getDriver();
        rp = new RegisterPage(driver); // 🔹 Now pass the initialized driver
        BaseClass.Verify_HomePage();
    }

    @When("User click on Register")
    public void user_click_on_register() {
        rp.click_On_Register1();
        
    }

    @Then("Registration Page should open")
    public void registration_page_should_open() {
        rp.Verify_Registration_Page();
    }

    @When("user enters valid details with firstname, lastname, email, and password")
    public void user_enter_valid_details_firstname_lastname_email_password() throws InterruptedException {
        rp.Enter_Registrations_details();
        
    }

    @When("clicks on Register button")
    public void clicks_on_register_button() throws InterruptedException {
        rp.click_Create_Account();
    }

    @Then("user should be Successfully Registered")
    public void user_should_be_successfully_registered() throws InterruptedException {
        rp.verify_Successful_Registration();
        Thread.sleep(3000);
    }
    
    @And("click on Logout")
    public void click_on_Logout() throws InterruptedException {
        driver.findElement(By.xpath("//a[.=' Logout']")).click();
    }
   
    @When("User Enter Registered email and password & click on Sign In")
   public void enter_credentials_andclick_on_signIn() throws InterruptedException{
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys(RegisterPage.storedEmail);
        driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys(RegisterPage.storedPass);
        driver.findElement(By.xpath("//button[.='Login']")).click();
        Thread.sleep(2000);
    }
    
    @Then("Welcome page should be displayed")
    public void Welcome_page_should_display() {
    	BaseClass.Verify_HomePage();
    }
    
    @When("user click on Delete Account")
    public void user_clickOn_Delete_Account() throws InterruptedException {
        driver.findElement(By.xpath("//a[.=' Delete Account']")).click();
        Thread.sleep(3000);

    }
    
    @Then("Account Deleted message should be displayed")
    public void Account_deleted_message_should_display() throws InterruptedException {
        String text=driver.findElement(By.xpath("//p[.='Your account has been permanently deleted!']")).getText();
        Assert.assertEquals("Your account has been permanently deleted!", text);
        driver.findElement(By.xpath("//a[.='Continue']")).click();
        Thread.sleep(3000);
        BaseClass.Verify_HomePage();
        Thread.sleep(3000);
    }
}
