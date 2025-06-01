package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage {
	WebDriver driver;

	public checkoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[.='Proceed To Checkout']")
	private WebElement Proceed_to_checkout;

	@FindBy(xpath = "//a[.='Place Order']")
	private WebElement placeOrder;

	public void click_on_Proceedto_Checkout() {
		Proceed_to_checkout.click();
	}

	public void clickOn_placeOrder() {
		placeOrder.click();
	}

	public void enter_payment_details() {
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("kunalpatil");
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("12");
	}

	public void click_on_ConfirmOrder() {
		driver.findElement(By.xpath("//button[.='Pay and Confirm Order']")).click();
	}

}
