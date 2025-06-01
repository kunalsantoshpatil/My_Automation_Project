package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.checkoutPage;

public class checkoutStep {
	WebDriver driver;
	checkoutPage cp;
	
	@Given("User has added product to the cart")
	public void user_has_added_product_to_the_cart() throws InterruptedException {
		driver = Hooks.getDriver();
		cp=new checkoutPage(driver);
	}

	@When("User click on Proceed to checkout")
	public void user_click_on_proceed_to_checkout() {
		cp.click_on_Proceedto_Checkout();
	}

	@When("click on Place order")
	public void click_on_place_order() {
		cp.clickOn_placeOrder();
	}

	@Then("Payement page should open")
	public void payement_page_should_open() {
	}

	@When("user enter payment detailclick on Pay & confirm order")
	public void user_enter_payment_detailclick_on_pay_confirm_order() {
		cp.enter_payment_details();
		cp.click_on_ConfirmOrder();
	}

	@Then("your order has been placed successfully this msg should come")
	public void your_order_has_been_placed_successfully_this_msg_should_come() {
	}


}
