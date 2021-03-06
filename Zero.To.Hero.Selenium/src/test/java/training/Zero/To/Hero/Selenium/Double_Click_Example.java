package training.Zero.To.Hero.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Double_Click_Example {

	WebDriver driver = new ChromeDriver();

	// It will open the browser & Application before Test
	@BeforeMethod
	public void openBrowser() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	}

	@Test
	public void Perform_Double_Click() throws InterruptedException{
		WebElement ele = driver.findElement(By.xpath("//button[contains(.,'Double-Click Me To See Alert')]"));

		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		act.doubleClick().perform();
		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
	}
	
	// It will close the Browser after Test
	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.close();
	}
}