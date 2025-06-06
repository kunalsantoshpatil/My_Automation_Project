package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

public class RegisterPage {
    WebDriver driver;
    public static String storedEmail = null;
    public static String storedPass = null;
    Faker faker = new Faker();
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
    	this.driver=driver;
        PageFactory.initElements(driver, this); // 🔹 Initialize Page Factory
    }

    @FindBy(xpath = "//a[contains(text(),' Signup / Login')]")
    private WebElement Register1;

    @FindBy(xpath= "//input[@name='name']")
    private WebElement name;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    private WebElement email;
    
    @FindBy(xpath = "//button[.='Signup']")
    private WebElement SignUp;

    @FindBy(id = "password")
    private WebElement Password;

    @FindBy(id = "first_name")
    private WebElement first_name;
    
    @FindBy(id = "last_name")
    private WebElement last_name;
    
    @FindBy(id = "address1")
    private WebElement address1;
    
    @FindBy(id = "state")
    private WebElement state;
    
    @FindBy(id = "city")
    private WebElement city;
    
    @FindBy(id = "zipcode")
    private WebElement zipcode;
    
    @FindBy(id = "mobile_number")
    private WebElement mobile_number;
    
    @FindBy(xpath = "(//span[.='Create an Account'])[1]")
    private WebElement Register2;
    
    @FindBy(xpath = "//button[.='Create Account']")
    private WebElement Create_Account;

    public void click_On_Register1() {
    	try {
        Register1.click();
    	}
    	catch(Exception e)
    	{
    		System.out.println("Did not click on Register");
    		driver.close();
    	}
    }

    public void Enter_Registrations_details() throws InterruptedException {
        name.sendKeys(faker.name().firstName());
        email.sendKeys(faker.internet().emailAddress().replaceAll("@.*", "@gmail.com"));
        storedEmail = email.getAttribute("value"); 
        SignUp.click();
        String fakePassword = faker.internet().password(8, 16, true, true, true);
        Password.sendKeys(fakePassword);
        storedPass = Password.getAttribute("value");  // 🔹 Corrected storing password
        first_name.sendKeys(faker.name().firstName());
        last_name.sendKeys(faker.name().lastName());
        address1.sendKeys(faker.address().fullAddress());
        state.sendKeys(faker.address().state());
        city.sendKeys(faker.address().cityName());
        zipcode.sendKeys(faker.address().zipCode());
        mobile_number.sendKeys(faker.phoneNumber().cellPhone());
    }

    public void click_Create_Account() throws InterruptedException {
    	Create_Account.click();
        Thread.sleep(3000);

    }

    public void Verify_Registration_Page() {  // Fixed typo
        String expectedTitle = "Automation Exercise - Signup / Login";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public void verify_Successful_Registration() { // Fixed typo
        String expectedTitle = "Automation Exercise - Account Created";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.findElement(By.xpath("//a[.='Continue']")).click();
    }
}
