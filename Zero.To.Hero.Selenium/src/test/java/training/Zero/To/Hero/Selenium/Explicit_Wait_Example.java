package training.Zero.To.Hero.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Explicit_Wait_Example {
	
	WebDriver driver = new ChromeDriver();

	// It will open the browser & Application before Test
	@BeforeMethod
	public void openBrowser() {
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}
	
	@Test
	public void verifySampleTest(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
		boolean isDisplayed = submitButton.isEnabled();
		Assert.assertTrue(isDisplayed);
	}
	
	// It will close the Browser after Test
	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}