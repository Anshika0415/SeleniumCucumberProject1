package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonutils.CommonUtils;
import io.cucumber.java.Scenario;

public class EcomWebSiteLogin {
	WebDriver driver;
	CommonUtils cu;
	Scenario scenario;
	WebDriverWait wait;
	
	//Constructor

	public EcomWebSiteLogin(WebDriver driver, CommonUtils cu, Scenario scenario) {
		
		this.driver=driver;
		this.cu=cu;
		this.scenario=scenario;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Locators
	
	@FindBy(xpath="//a[@class='dynamic-link dropdown-toggle']")
	WebElement PracticeDD;
	@FindBy(xpath="//a[text()='eCommerce Practice']")
	WebElement EcomPractice;
	@FindBy(xpath="//a[@aria-label='Orders']")
	WebElement EcomOrders;
	@FindBy(id="email")
	WebElement EcomUsername;
	@FindBy(id="password")
	WebElement EcomPassword;
	@FindBy(xpath="//button[text()='LOG IN']")
	WebElement EcomLoginBtn;

	//Methods
	
	public void enterEcomPage() {
		
    	cu.click(PracticeDD);
    	String parentWindow=driver.getWindowHandle();
    	cu.click(EcomPractice);
    	Set<String> set=driver.getWindowHandles();
    	for(String window:set)
    	{
    		if(!window.equalsIgnoreCase(parentWindow))
    		{
    			driver.switchTo().window(window);
    		}
    	}
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Orders']")));
    	cu.click(EcomOrders);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Please enter')]")));
		EcomUsername.sendKeys("test@test.com");
		EcomPassword.sendKeys("1234");
		cu.click(EcomLoginBtn);
	}

	

}
