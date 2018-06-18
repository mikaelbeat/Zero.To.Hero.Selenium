package training.Zero.To.Hero.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Implicit_Wait_Example {

	WebDriver driver = new ChromeDriver();

	// It will open the browser & Application before Test
	@BeforeTest
	public void openBrowser() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}

	@Test
	public void Implicit_Wait_Test() throws InterruptedException {
		WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
		boolean isDisplayed = submitButton.isEnabled();
		Assert.assertTrue(isDisplayed);
	}
	
	// It will close the Browser after Test
	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}