package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_to_Cart {
	WebDriver driver;
	public Add_to_Cart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//i[@class='fa fa-shopping-cart'])[2]")
	private WebElement Add_to_Cart;
	
	@FindBy(xpath="//a[.=' Cart']")
	private WebElement View_Cart;
	
	
	@FindBy(xpath="//a[.='Green Side Placket Detail T-Shirt']")
	private WebElement Added_product;
	
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	private WebElement remove_product;
	
	
	public void click_on_Add_to_Cart() throws InterruptedException, TimeoutException
	{
		try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Add_to_Cart));
            element.click();
    		Thread.sleep(1500);

        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Element not clickable or found within 10 seconds.");
            quitOnFailure(driver);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (WebDriverException e) {
            System.out.println("WebDriver session is invalid.");
            quitOnFailure(driver);
        }
	}
	
	 private static void quitOnFailure(WebDriver driver) {
	        if (driver != null) {
	            driver.quit();
	        }
	        throw new RuntimeException("❌ Test aborted due to element failure or session expiration.");
	    }
	 
	 
	public void click_on_view_cart()
	{
		driver.findElement(By.xpath("//u")).click();
	}
	
	public void verify_added_product_toCart() throws InterruptedException
	{
		Assert.assertEquals("Green Side Placket Detail T-Shirt", Added_product.getText());
//		Proceed_to_checkout.isDisplayed();
	}
	
	public void remove_from_cart() throws InterruptedException
	{
		remove_product.click();
		Thread.sleep(1000);
	}
	
	public void verify_emptyCart()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());
		
	}
	

	

}
