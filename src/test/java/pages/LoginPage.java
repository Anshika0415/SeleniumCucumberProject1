package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonutils.CommonUtils;
import io.cucumber.java.Scenario;

public class LoginPage {
WebDriver driver;
CommonUtils cu;
Scenario scenario;

	public LoginPage(WebDriver driver, CommonUtils cu, Scenario scenario) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.cu=cu;
		this.scenario=scenario;
	}

	public void agentEntersDetails(String name, String pass) {
		// TODO Auto-generated method stub
		String baseURL = "http://www.letskodeit.com/";
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		WebElement signIn=driver.findElement(By.xpath("//a[text()='Sign In']"));
		cu.click(signIn);
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		emailField.sendKeys(name);
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
		passwordField.sendKeys(pass);
		WebElement loginBtn=driver.findElement(By.id("login"));
    	cu.click(loginBtn);
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.invisibilityOf(loginBtn));
	}

	public void practicePageTasks() throws InterruptedException {
		
		WebElement PracticeDD=driver.findElement(By.xpath("//a[@class='dynamic-link dropdown-toggle']"));
    	cu.click(PracticeDD);
    	String parentWindow=driver.getWindowHandle();
    	WebElement ElementPractice=driver.findElement(By.xpath("//a[text()='Element Practice']"));
    	cu.click(ElementPractice);
    	Set<String> set=driver.getWindowHandles();
    	for(String window:set)
    	{
    		if(!window.equalsIgnoreCase(parentWindow))
    		{
    			driver.switchTo().window(window);
    		}
    	}
    	WebElement selectDD=driver.findElement(By.id("carselect"));
    	Select sel=new Select(selectDD);
    	sel.selectByValue("honda");
    	
    	WebElement multiselectDD=driver.findElement(By.id("multiple-select-example"));
    	Select sel1=new Select(multiselectDD);
    	sel1.selectByValue("orange");
    	sel1.selectByValue("peach");
    	
    	WebElement disableBtn=driver.findElement(By.id("disabled-button"));
    	cu.click(disableBtn);
    	WebElement disabledTextBox=driver.findElement(By.id("enabled-example-input"));
    	System.out.println(disabledTextBox.isEnabled());
    	
    	WebElement hideBtn=driver.findElement(By.id("hide-textbox"));
    	cu.click(hideBtn);
    	WebElement hiddenTextBox=driver.findElement(By.id("displayed-text"));
    	System.out.println(hiddenTextBox.isDisplayed());
    	
    	WebElement alertBtn=driver.findElement(By.id("alertbtn"));
    	cu.click(alertBtn);
    	Thread.sleep(3000);
    	driver.switchTo().alert().accept();
    	
    	Actions act =new Actions(driver);
    	WebElement mousehoverBtn=driver.findElement(By.id("mousehover"));
    	act.moveToElement(mousehoverBtn).perform();
      //act.contextClick(mousehoverBtn).perform();
    	
    	WebElement iframe=driver.findElement(By.id("courses-iframe"));
    	driver.switchTo().frame(iframe);
    	WebElement searchTB=driver.findElement(By.name("course"));
    	searchTB.sendKeys("Anshika won!");
    	
	}

}
