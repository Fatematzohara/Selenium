package pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//new, you have to manually write it to get access of common method
//this is possible when they are static in nature, * means all
//This is called static import
import static common.CommonActions.*;

public class HomePage {
	@FindBy(id = "header_sign_in")
	WebElement signInButton;
	@FindBy(id = "signInName")
	WebElement signInName;
	@FindBy(xpath = "//a[text()=\'Sign In / Register\']")
	WebElement signingElement;

	// 3rd way to write the WebElement with "By" Class: Not common, here I used
	// unlock web element from the home page
	// instead of xpath, we can use id, name, class etc as locator.
	// By unlock = By.id("cms-unlock-account"); // or
	By unlock = By.xpath("//a[text()=\\'Sign In / Register\\']");
	// How to test implicitlyWait()? or
	// Used it to show the common action method exception: NoSuchElementException
	@FindBy(id = "wrongheader_sign_in")
	WebElement wrongNewUserRegistration;

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickSignInButton() throws InterruptedException {
		signingElement.click();
		Thread.sleep(4000);
	}
	
	//common actions
//	public void clickUserId() {
//		clickElement(signInButton); // common method is used from here
//	}

	public void clicksignInName() throws InterruptedException {
		signInName.click();
		Thread.sleep(4000);
	}

	// How to test implicitlyWait()?
	public void clickWrongNewUserRegistration() {
		wrongNewUserRegistration.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Not common, just for your reference
	public void clickUnlock() throws InterruptedException {
		Thread.sleep(5000);
		// This is the new way to call the web element
		driver.findElement(unlock).click();
		Thread.sleep(5000);
	}
	




}
