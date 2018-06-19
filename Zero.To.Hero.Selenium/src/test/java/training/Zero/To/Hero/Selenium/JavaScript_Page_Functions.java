package training.Zero.To.Hero.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScript_Page_Functions {
	
	WebDriver driver;

	// It will open the browser & Application before Test
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
	}
	
	@Test
	public void Get_Page_Text() throws InterruptedException{
		String javaScript = "return document.documentElement.innerText;";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String pageText = js.executeScript(javaScript).toString();
		System.out.println(pageText);
		Thread.sleep(5000);
	}
	
	@Test
	public void Get_Page_Title() throws InterruptedException{
		String javaScript = "return document.title;";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String pageTitle = js.executeScript(javaScript).toString();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Facebook - Log In or Sign Up");
		Thread.sleep(5000);
	}
	
	// It will close the Browser after Test
	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}