package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//a[.=' Signup / Login']")
	private WebElement signup_login;
	
	@FindBy (xpath="(//input[@name='email'])[1]")
	private WebElement email;
	
	@FindBy(xpath="(//input[@name='password'])[1]")
	private WebElement password;
	
	@FindBy(xpath="//button[.='Login']")
	public WebElement Login;
	
	@FindBy(xpath="//a[.=' Logout']")
	public WebElement LogOut;
	
	public void click_on_signup_login()
	{
		signup_login.click();
	}
	
	public void enter_valid_Email_Password()
	{
		email.sendKeys("ytkunalpatil@gmail.com");
		password.sendKeys("12345678");
	}
	
	public void click_on_Login()
	{
		try {
			if (Login.isDisplayed() == true) {
				Login.click();
				Thread.sleep(2000);
				BaseClass.Verify_Successfull_Login();
			}
		} catch (Exception e) {
			System.out.println("You have Entered Wrong Credentials");
		}
	}
	
	public void click_on_LogOut()
	{
		LogOut.click();
	}

}
