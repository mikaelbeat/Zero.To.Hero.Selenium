package training.Zero.To.Hero.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Right_Click_Example {
	
	WebDriver driver = new ChromeDriver();

	// It will open the browser & Application before Test
	@BeforeMethod
	public void openBrowser() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	}

	@Test
	public void Perform_Right_Click() throws InterruptedException{
		WebElement rightClick = driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));
		
		Actions act = new Actions(driver);
		act.moveToElement(rightClick).perform();
		act.contextClick().perform();
		Thread.sleep(5000);
	}
	
	// It will close the Browser after Test
	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}