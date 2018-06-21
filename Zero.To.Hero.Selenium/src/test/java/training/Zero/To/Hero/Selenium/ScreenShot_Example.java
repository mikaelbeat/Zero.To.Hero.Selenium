package training.Zero.To.Hero.Selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import training.Zero.To.Hero.Selenium.Utils.CaptureScreenShot;

public class ScreenShot_Example {


	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	WebDriver driver;

	@BeforeTest
	public void startTest() {
		reports = new ExtentReports();

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\Report\\Report.html");
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine", "Anshul-772G");
		reports.setSystemInfo("Env", "DevOps");
		reports.setSystemInfo("Build", "Integration");
		reports.setSystemInfo("Browser", "IE");
	}

	@BeforeMethod
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}

	@Test
	public void verifyTittleTest() {
		test = reports.createTest("verifyTittleTest");
		String expetedTitle = "Facebook – log in or sign up";
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expetedTitle);
	}

	@Test
	public void fillRegistrationformTest() {
		test = reports.createTest("fillRegistrationformTest");

		WebElement firstName = driver.findElement(By.cssSelector("input[id='u_0_2']"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement submitButton = driver.findElement(By.id("u_0_m"));

		firstName.sendKeys("Anshul");
		lastName.sendKeys("Chauhan");
		submitButton.click();
		String expectedTitle = "FaceBook Home";
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expectedTitle);
	}

	@AfterMethod
	public void setTestResult(ITestResult result) throws IOException {

		String screenShot = CaptureScreenShot.captureScreen(driver);

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			test.log(Status.FAIL,result.getThrowable());
			test.fail("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
			test.pass("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Case : " + result.getName() + " has been skipped");
		}
 
		reports.flush();
		driver.close();
	}

	@AfterTest
	public void endTest() {
		
		reports.flush();
	}

}