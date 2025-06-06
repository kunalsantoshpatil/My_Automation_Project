package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_ProductPage {
	WebDriver driver;

	public Search_ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	private WebElement Products;
	
	@FindBy(id="search_product")
	private WebElement search_product;
	
	@FindBy(id="submit_search")
	private WebElement submit_search;
		
	@FindBy(xpath="(//a[.='View Product'])[3]")
	private WebElement visible_product;
	
	public void click_on_Products() throws InterruptedException
	{
		Products.click();
		Thread.sleep(2000);
	}
	
	public void Search_product()
	{
		search_product.sendKeys("Tshirt");
	}
	
	public void click_on_SearchIcon()
	{
		submit_search.click();
	}
	
	public void verify_product() throws InterruptedException
	{
		visible_product.click();
		Thread.sleep(3000);
		WebElement product=driver.findElement(By.xpath("(//h2)[3]"));
		if(product.isDisplayed()==true)
		{
			System.out.println("Product Displayed successfully");
		}
		Thread.sleep(4000);

	}
}
