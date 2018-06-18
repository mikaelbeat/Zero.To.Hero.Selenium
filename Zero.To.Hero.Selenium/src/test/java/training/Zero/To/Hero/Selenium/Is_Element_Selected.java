package training.Zero.To.Hero.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Is_Element_Selected {
	
	WebDriver driver = new ChromeDriver();

	// It will open the browser & Application before Test
	@BeforeTest
	public void openBrowser() {

		// To maximize the Window
		driver.manage().window().maximize();
		// To Open the Application
		driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
	}

	@Test
	public void Verify_Selected_Elements() throws InterruptedException {

		WebElement restCheckBox = driver.findElement(By.id("restapibox"));
		boolean flag = restCheckBox.isSelected();

		System.out.println("is Rest API CheckBox Selected - " +flag);
		
		WebElement seleniumCheckBox = driver.findElement(By.id("seleniumbox"));
		boolean selFlag = seleniumCheckBox.isSelected();
		
		System.out.println("is Selenium CheckBox Selected - " +selFlag);
	}
	
	// It will close the Browser after Test
	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}