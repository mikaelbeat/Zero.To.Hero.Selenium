package training.Zero.To.Hero.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Verify_Title {
	
	String ExpectedTitle = "Fantasiapelit - roolipeli- lautapeli- korttipeli- miniatyyri- sarjakuva- & manga-kauppa";
	
	@Test
	public void Verify() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fantasiapelit.com");
		
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		driver.close();
		
	}

}