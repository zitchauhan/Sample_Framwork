package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LoginPage;
import pageObjects.MicrosoftPage;

public class microsofSteps {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private MicrosoftPage mspage;
	private ExtentTest test;

	public microsofSteps()

	{
		this.driver = BaseClass.getDriver();
		this.loginPage = PageFactory.initElements(driver, LoginPage.class);
		this.mspage = PageFactory.initElements(driver, MicrosoftPage.class);
		
	}
	@Given("user click on loginbutton")
	public void user_click_on_loginbutton()
	
		{
		mspage.signIN();
	  	}

	@Then("user enter the loginId and cick on next")
	public void user_enter_the_login_id_and_cick_on_next() 
	{
	    
	mspage.enterEmail();
	mspage.clickOnNext();
	}
}
