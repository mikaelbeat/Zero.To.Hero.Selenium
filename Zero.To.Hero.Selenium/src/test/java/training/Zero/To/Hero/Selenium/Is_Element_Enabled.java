package training.Zero.To.Hero.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Is_Element_Enabled {
	
	WebDriver driver = new ChromeDriver();

	// It will open the browser & Application before Test
	@BeforeTest
	public void openBrowser() {
		// To maximize the Window
		driver.manage().window().maximize();
		// To Open the Application
		driver.get("http://www.facebook.com");
	}

	@Test
	public void Verify_Is_Create_Account_Element_Enabled() {
		// Finding button by ID locator
		WebElement createAccountButton = driver.findElement(By.id("u_0_n"));
		boolean flag = createAccountButton.isEnabled();
		System.out.println("Is Create Account Enabled : " +flag);
		Assert.assertTrue(flag);
	}
	
	// It will close the Browser after Test
	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}