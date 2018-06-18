package training.Zero.To.Hero.Selenium;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import training.Zero.To.Hero.Selenium.Utils.Get_Reponse_Code;

public class Find_Broken_Links {
	
	WebDriver driver = new ChromeDriver();
	private static Logger log = LogManager.getLogger(Find_Broken_Links.class.getName());
	String url = "http://fantasiapelit.fi";

	// It will open the browser & Application before Test
	@BeforeTest
	public void openBrowser() {
		//To maximize the Window
		driver.manage().window().maximize();
		//To Open the Application
		driver.get(url);
	}
	
	@Test
	 public void Verify_Links() {
		log.info("STARTING TO VERIFY LINKS IN URL: " + url);
		 // Find all Elements on the page with 'a' tag
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		 System.out.println("Total Number of Links : " +allLinks.size());
		 //Iterate over all available Links on webpage
		 for (WebElement link : allLinks) {
			String linkURL = link.getAttribute("href");
			//Call VerifyURL form GetResponse Code Class
			Get_Reponse_Code.verifyUrl(linkURL);
		}
		 System.out.println("Total Number of Links : " +allLinks.size());
		 Get_Reponse_Code.getInvalidLinkCount(); 
	}
	
	@AfterTest
	public void tearDown() {
		log.info("ENDING VERIFYING LINKS IN URL: " + url);
		if (driver != null)
			driver.close();
	}

}