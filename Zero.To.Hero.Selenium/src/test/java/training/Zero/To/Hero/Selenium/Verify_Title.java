package training.Zero.To.Hero.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.testng.Assert;

public class Verify_Title {
	
	String ExpectedTitle = "Fantasiapelit - roolipeli- lautapeli- korttipeli- miniatyyri- sarjakuva- & manga-kauppa";
	
	@Test
	public void Verify() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fantasiapelit.com");
		String ActualTitle = driver.getTitle();
		System.out.println("EXPECTED: " +ExpectedTitle);
		System.out.println("ACTUAL: " + ActualTitle);
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		driver.close();
	}

}