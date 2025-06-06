package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.Search_ProductPage;


public class Search_Step {
	WebDriver driver;
	Search_ProductPage sp;
	
	@Given("User has already login and present on Home page")
	public void user_has_already_login_and_present_on_home_page() throws InterruptedException {
		driver=Hooks.getDriver();
		sp=new Search_ProductPage(driver);
	}

	@When("user click on products tab")
	public void user_click_on_products_tab() throws InterruptedException {
		sp.click_on_Products();
	}

	@Then("user should navigate to All product page")
	public void user_should_navigate_to_all_product_page() {
        Assert.assertEquals("Automation Exercise - All Products", driver.getTitle()); // ✅ Corrected order
		
	}

	@When("user search Tshirt in search box")
	public void user_search_tshirt_in_search_box() {
		sp.Search_product();
	}

	@When("click on Search icon")
	public void click_on_search_icon() {
		sp.click_on_SearchIcon();
	}

	@Then("searched product should be visible")
	public void searched_product_should_be_visible() throws InterruptedException {
		sp.verify_product();
	}

	@Then("Verify product details page should be visible")
	public void product_details_page_should_be_visible() throws InterruptedException {
		Assert.assertEquals("Automation Exercise - Product Details", driver.getTitle());
		Thread.sleep(3000);
	}


}
