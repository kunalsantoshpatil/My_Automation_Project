package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.Add_to_Cart;

public class Add_to_cartStep {
	WebDriver driver;
	Add_to_Cart ap;

	@Given("User is on product details page")
	public void User_is_on_product_details_page() throws InterruptedException {
		driver = Hooks.getDriver();
		ap = new Add_to_Cart(driver);
		Assert.assertEquals("Automation Exercise - Product Details", driver.getTitle());
	}

	@When("user click on Add to cart")
	public void user_click_on_add_to_cart() throws InterruptedException, Throwable {
		ap.click_on_Add_to_Cart();
	}

	@Then("product should be added to cart")
	public void product_should_be_added_to_card() {
	}

	@Then("user click on View cart")
	public void user_click_on_view_cart() {
		ap.click_on_view_cart();
	}

	@Then("product should be visible")
	public void product_should_be_visible() throws InterruptedException {
		ap.verify_added_product_toCart();
	}

	// update scenario
	@When("update product quantity")
	public void update_product_quantity() throws InterruptedException {
		driver.findElement(By.xpath("//a[.='Green Side Placket Detail T-Shirt']")).click();
		Thread.sleep(1000);
	}

	@And("click on Add to cart again")
	public void click_addtocart_again() throws InterruptedException, Throwable {
		ap.click_on_Add_to_Cart();
	}


	@When("User remove product from cart")
	public void User_remove_product_from_page() throws InterruptedException {
		ap.remove_from_cart();
	}

	@Then("verify product should be deleted from cart")
	public void Verify_product_should_deleted() {
		ap.verify_emptyCart();
	}

}
