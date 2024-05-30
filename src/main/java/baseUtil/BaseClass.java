package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;

public class BaseClass {

	public WebDriver driver;
	public HomePage homePage;

	@BeforeMethod
	public void setUp() {
		// 1st way
//	System.setProperty("webdriver.chrome.driver",
//	"C:\\Users\\silia\\eclipse-workspace\\com.costco\\driver\\chromedriver.exe");

//2nd way, to show the location of the chrome driver
//	This is a dynamic way (relative path)
// user.dir means --> System set the property to User Directory
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		// + "/driver/chromedriver.exe");

		// 3rd way and will be used most
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();// instantiated the driver here

		driver.manage().window().maximize();
		// deleteAllCookies do delete the cookies
		driver.manage().deleteAllCookies();
		driver.get("https://www.costco.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}
