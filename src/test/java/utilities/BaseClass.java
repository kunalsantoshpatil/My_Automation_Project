package utilities;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriver initializeDriver() {
        if (driver == null || isSessionInvalid(driver)) { // Check if session is invalid
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://automationexercise.com/");
        }
        return driver;
    }

    // Helper method to check if WebDriver session is invalid
    private static boolean isSessionInvalid(WebDriver driver) {
        try {
            driver.getTitle(); // Try accessing the page
            return false; // If successful, session is valid
        } catch (Exception e) {
            return true; // Exception means session is invalid
        }
    }

    public static void Verify_HomePage() {
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle); 
    }
    
    public static void Verify_signup_loginPage() {
        String expectedTitle = "Automation Exercise - Signup / Login";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle); 
      
    }
    public static void Verify_Successfull_Login() {
		boolean ele = driver.findElement(By.xpath("//a[.=' Logout']")).isDisplayed();
		Assert.assertTrue(ele);
	}
    
}
