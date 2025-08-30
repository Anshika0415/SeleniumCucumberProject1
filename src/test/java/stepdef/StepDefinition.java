package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.DriverFactory;
import commonutils.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EcomWebSiteHomepage;
import pages.EcomWebSiteLogin;
import pages.LoginPage;

public class StepDefinition {
	WebDriver driver;
	LoginPage lp;
	CommonUtils cu;
	static ExtentReports extent;
	ExtentTest test;
	EcomWebSiteLogin ecom;
	EcomWebSiteHomepage ecomHome;
	
	@BeforeAll
	public static void createReportFunc()
	{
		 String reportPath = "reports/chromeFile.html";
		if(extent==null)
		{
			ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
			spark.config().setDocumentTitle("Automation Test Report");
			spark.config().setTheme(Theme.STANDARD);
			extent=new ExtentReports();
			extent.attachReporter(spark);
		}
	}	
	
	@Before
	public void setup(Scenario scenario)
	{
		//this piece of code will run before every scenario
		driver=DriverFactory.getDriver();;
	    cu=new CommonUtils(driver);
		lp=new LoginPage(driver,cu,scenario);
		test=extent.createTest(scenario.getName());
		ecom=new EcomWebSiteLogin(driver,cu,scenario);
		ecomHome=new EcomWebSiteHomepage(driver,cu,scenario);
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String path=cu.takeScreenshot(scenario.getName());
			test.fail("Step Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		
		 //DriverFactory.quitDriver();
	}
	
	@BeforeStep
	public void stepWiseSS(Scenario scenario)
	{
		String path=cu.takeScreenshot(scenario.getName());
		test.info("Step Execution Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
	
	@AfterAll
	public static void tearDown() {
	    extent.flush(); // Writes everything to the report
	}
	
	
	@Given("agent enters {string} and {string} and logins")
	public void agent_enters_and(String name, String pass) {
	    lp.agentEntersDetails(name,pass);
	}
	
	@Then("agent performs tasks on practice page")
	public void agent_performs_tasks_on_practice_page() throws InterruptedException {
	    lp.practicePageTasks();
	}
	// Functions for new ecom page
	
	@Then("enter into ecom website and register")
	public void enter_into_ecom_website() {
	    ecom.enterEcomPage();
	}
	@When("agent tries to add an item")
	public void agent_tries_to_add_an_item() {
	    ecomHome.addItems();
	}
	@Then("agent should be able to checkout")
	public void agent_should_be_able_to_checkout() {
	    ecomHome.checkOut();
	}
	
	@Then("agent should be able to check order status")
	public void agent_should_be_able_to_check_order_status() {
		ecomHome.checkOrderStatus();
	}

}
