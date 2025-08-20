package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonutils.CommonUtils;
import io.cucumber.java.Scenario;

public class LoginPage {
WebDriver driver;
CommonUtils cu;
Scenario scenario;

// constructor

	public LoginPage(WebDriver driver, CommonUtils cu, Scenario scenario) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.cu=cu;
		this.scenario=scenario;
		PageFactory.initElements(driver, this); // Initialize WebElements
	}

//Locators
	@FindBy(xpath="//a[text()='Sign In']") 
	WebElement signIn;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath="//input[@id='login-password']")
	WebElement passwordField;
	@FindBy(id="login")
	WebElement loginBtn;
	@FindBy(xpath="//a[@class='dynamic-link dropdown-toggle']")
	WebElement PracticeDD;
	@FindBy(xpath="//a[text()='Element Practice']")
	WebElement ElementPractice;
	@FindBy(id="carselect")
	WebElement selectDD;
	@FindBy(id="multiple-select-example")
	WebElement multiselectDD;
	@FindBy(id="disabled-button")
	WebElement disableBtn;
	@FindBy(id="enabled-example-input")
	WebElement disabledTextBox;
	@FindBy(id="hide-textbox")
	WebElement hideBtn;
	@FindBy(id="displayed-text")
	WebElement hiddenTextBox;
	@FindBy(id="alertbtn")
	WebElement alertBtn;
	@FindBy(id="mousehover")
	WebElement mousehoverBtn;
	@FindBy(id="courses-iframe")
	WebElement iframe;
	
//Functions
	
	public void agentEntersDetails(String name, String pass) {
		// TODO Auto-generated method stub
		String baseURL = "http://www.letskodeit.com/";
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		cu.click(signIn);
		emailField.sendKeys(name);
		passwordField.sendKeys(pass);
    	cu.click(loginBtn);
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.invisibilityOf(loginBtn));
	}

	public void practicePageTasks() throws InterruptedException {
		
		
    	cu.click(PracticeDD);
    	String parentWindow=driver.getWindowHandle();
    	cu.click(ElementPractice);
    	Set<String> set=driver.getWindowHandles();
    	for(String window:set)
    	{
    		if(!window.equalsIgnoreCase(parentWindow))
    		{
    			driver.switchTo().window(window);
    		}
    	}
    	
    	Select sel=new Select(selectDD);
    	sel.selectByValue("honda");
    	
    	
    	Select sel1=new Select(multiselectDD);
    	sel1.selectByValue("orange");
    	sel1.selectByValue("peach");
    	
    	cu.click(disableBtn);
    	System.out.println(disabledTextBox.isEnabled());
    	
    	cu.click(hideBtn);
    	System.out.println(hiddenTextBox.isDisplayed());
    	
    	
    	cu.click(alertBtn);
    	Thread.sleep(3000);
    	driver.switchTo().alert().accept();
    	
    	Actions act =new Actions(driver);
    	act.moveToElement(mousehoverBtn).perform();
      //act.contextClick(mousehoverBtn).perform();
    	
    	
    	driver.switchTo().frame(iframe);
    	WebElement searchTB=driver.findElement(By.name("course"));
    	searchTB.sendKeys("Anshika won!");
    	
	}

}
