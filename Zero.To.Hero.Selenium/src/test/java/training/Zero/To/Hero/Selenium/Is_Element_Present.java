package training.Zero.To.Hero.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Is_Element_Present {
	
	WebDriver driver = new ChromeDriver();

	// It will open the browser & Application before Test
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D://Drivers//chromedriver.exe");
		

		// To maximize the Window
		driver.manage().window().maximize();
		// To Open the Application
		driver.get("http://www.facebook.com");
	}

	@Test
	public void verifyCreateAccountText() {

		WebElement createAccountLabel = driver.findElement(By.cssSelector("div[class='mbs _52lq fsl fwb fcb'] span"));
		boolean flag = createAccountLabel.isDisplayed();

		System.out.println("Text is Present : " + flag);
		System.out.println("Text is : " +createAccountLabel.getText());
		Assert.assertTrue(flag);
	}
	
	// It will close the Browser after Test
	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}