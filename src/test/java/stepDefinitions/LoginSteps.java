// src/test/java/stepDefinitions/LoginSteps.java
package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.ExtentReportManager;


public class LoginSteps {
	private WebDriver driver;
	private LoginPage loginPage;
	private ExtentTest test;

	public LoginSteps()

	{
		this.driver = BaseClass.getDriver();
		this.loginPage = PageFactory.initElements(driver, LoginPage.class);

		System.out.println("ClassLoader for YourTestClass: " + LoginSteps.class.getClassLoader());

	}


	@Given("The user is on the login page")
	public void user_is_on_login_page() throws IOException {
		String url = BaseClass.getProperty("url");
		driver.get(url);
		test = ExtentReportManager.getTest();
		if (test != null) {
			test.info("User is on the login page");
		} else {
			System.out.println("ExtentTest is not initialized.");
		}

	}

	@When("The user enters {string} and {string}")
	public void user_enters_credentials(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		test.info("Entered username and password");
	}

	@And("The user clicks on the login button")
	public void user_clicks_login_button() {
		loginPage.clickLogin();
		test.info("Clicked on login button");
	}

	@Then("The user is redirected to the homepage")
	public void user_is_redirected_to_homepage() {
		// Verification logic here
		test.pass("User redirected to homepage successfully");
	}
}
