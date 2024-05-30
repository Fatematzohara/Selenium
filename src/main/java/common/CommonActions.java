package common;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

public class CommonActions {

	public static void clickElement(WebElement element) {
		try {
			element.click();
		} catch (NoSuchElementException | NullPointerException e) {
			// e.printStackTrace();
			System.out.println("Exception is: " + e);
		}
	}

	// common method for sendKeys()
	public static void inputText(WebElement element, String input) {
		// what is the element and what we want to write
		try {
			element.sendKeys(input);
		} catch (NoSuchElementException | NullPointerException f) {
			f.printStackTrace();
		}
	}

	// common method for sleep()
	public static void pause(long sec) {
		try {
			Thread.sleep(sec * 1000);// sleep only takes milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
