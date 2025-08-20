package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutils.CommonUtils;
import io.cucumber.java.Scenario;

public class EcomWebSiteLogin {
	WebDriver driver;
	CommonUtils cu;
	Scenario scenario;
	
	//Constructor

	public EcomWebSiteLogin(WebDriver driver, CommonUtils cu, Scenario scenario) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.cu=cu;
		this.scenario=scenario;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	
	@FindBy(xpath="//a[@class='dynamic-link dropdown-toggle']")
	WebElement PracticeDD;
	@FindBy(xpath="//a[text()='eCommerce Practice']")
	WebElement EcomPractice;

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
		
	}

}
