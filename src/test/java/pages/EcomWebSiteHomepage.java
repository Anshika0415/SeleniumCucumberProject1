package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonutils.CommonUtils;
import io.cucumber.java.Scenario;
import junit.framework.Assert;

public class EcomWebSiteHomepage {
	
	WebDriver driver;
	CommonUtils cu;
	Scenario scenario;
	WebDriverWait wait;
	
	//constructor
	
	public EcomWebSiteHomepage(WebDriver driver, CommonUtils cu, Scenario scenario) {
		this.driver=driver;
		this.cu=cu;
		this.scenario=scenario;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Locators
	
	@FindBy(xpath="//a[@href='/shop' and text()='Shop']")
	WebElement shopLink;
	@FindBy(xpath="//span[text()='men']/following-sibling::ul//a[@href='/shop' and text()='All clothing']")
	WebElement clothingOption;
	@FindBy(xpath="//img[@alt='relaxed t shirt woman' and @src='/products/woman1.jpeg']")
	WebElement womenTshirtLink;
	@FindBy(xpath="//img[@alt='relaxed t shirt woman' and @src='/products/woman1.jpeg']/following-sibling::div[1]")
	WebElement womenTshirtAddToCart;
	@FindBy(xpath="//button[text()='Add to Bag']")
	WebElement addToCartBtn;
	@FindBy(xpath="//button[@aria-label='Cart']")
	WebElement cart;
	@FindBy(xpath="//button[text()='checkout']")
	WebElement checkout;
	@FindBy(xpath="//span[text()='Order Status']")
	WebElement orderstatus;
	
	//Methods
	
	public void addItems() {
		// TODO Auto-generated method stub
		Actions a=new Actions(driver);
		WebElement shopLink=driver.findElement(By.xpath("//a[@href='/shop' and text()='Shop']"));
		a.moveToElement(shopLink).perform();
		
		WebElement clothingOption=driver.findElement(By.xpath("//span[text()='men']/following-sibling::ul//a[@href='/shop' and text()='All clothing']"));
		a.moveToElement(clothingOption).click().perform();
		
		WebElement womenTshirtLink=driver.findElement(By.xpath("//img[@alt='relaxed t shirt woman' and @src='/products/woman1.jpeg']"));
		a.moveToElement(womenTshirtLink).perform();
		
		WebElement womenTshirtAddToCart=driver.findElement(By.xpath("//img[@alt='relaxed t shirt woman' and @src='/products/woman1.jpeg']/following-sibling::div[1]"));
		a.moveToElement(womenTshirtAddToCart).click().perform();
		
		WebElement addToCartBtn=driver.findElement(By.xpath("//button[text()='Add to Bag']"));
		cu.click(addToCartBtn);
	}

	public void checkOut() {
		cu.click(cart);
		cu.click(checkout);
		cu.click(checkout);
		
		}

	public void checkOrderStatus() {
		
		cu.click(orderstatus);
	}


}
