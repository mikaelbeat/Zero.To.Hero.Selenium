package training.Zero.To.Hero.Selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
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
		String expetedTitle = "Facebook – log in or sign upP";
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expetedTitle);
	}

	  @AfterMethod
	  public void afterMethod(ITestResult testResult) throws IOException {
		  if (testResult.getStatus() == ITestResult.FAILURE) {
			  String path = training.Zero.To.Hero.Selenium.Utils.Screenshot.takeScreenshot(driver, testResult.getName());
			  ExtentTest imagePath = test.addScreenCaptureFromPath(path);
			  test.log(Status.FAIL, "Verify Welcome Text Failed.");
//			  test.log(LogStatus.FAIL, "Verify Welcome Text Failed.", imagePath);
	
		  }
	  }

	@AfterTest
	public void endTest() {
		  driver.quit();
		  reports.flush();
	}

}