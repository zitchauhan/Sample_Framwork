// src/main/java/pageObjects/LoginPage.java
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='pass']")
	WebElement password;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement loginButton;

	public void enterUsername(String user) {
		WaitUtils.waitForVisibility(driver, username);
		username.sendKeys(user);
	}

	public void enterPassword(String pass) {
		WaitUtils.waitForVisibility(driver, password);
		password.sendKeys(pass);
	}

	public void clickLogin() {
		WaitUtils.waitForElementToBeClickable(driver, loginButton);
		loginButton.click();
	}
}
