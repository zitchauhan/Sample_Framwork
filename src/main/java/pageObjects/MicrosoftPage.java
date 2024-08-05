package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class MicrosoftPage {

	WebDriver driver;

	public MicrosoftPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(text(), 'Sign in')]")
	WebElement Singinbutton;

	public void signIN() {
		WaitUtils.waitForElementToBeClickable(driver, Singinbutton);
		Singinbutton.click();
	}

	@FindBy(xpath = "//input[@type='email']")
	WebElement EmailBox;

	public void enterEmail() {
		WaitUtils.waitForVisibility(driver, EmailBox);
		EmailBox.sendKeys("zitchauhan@gmail.com");
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement next;

	public void clickOnNext() {
		WaitUtils.waitForElementToBeClickable(driver, next);
		next.click();
	}

}
