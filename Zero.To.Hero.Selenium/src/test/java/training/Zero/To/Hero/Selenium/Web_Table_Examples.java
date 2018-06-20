package training.Zero.To.Hero.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Web_Table_Examples {
	
	WebDriver driver;

	// It will open the browser & Application before Test
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
	}

	@Test
	public void Count_Total_Rows_Test(){
		List<WebElement> allRows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		System.out.println("Total No of Rows : " +allRows.size());
	}
	
	@Test
	public void Print_All_Rows_Test(){
		List<WebElement> allRows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		
		System.out.println("********** Starting Table ************");
		for (int row = 0; row < allRows.size(); row++) {
			System.out.println(allRows.get(row).getText());
		}
		System.out.println("********** Ending Table ************");
	}
	
	@Test
	public void Count_All_Cols_Test(){
		List<WebElement> allCols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
		System.out.println("Total No of Cols : " +allCols.size());
	}
	
	@Test
	public void Print_Complete_Column_Test(){
		List<WebElement> firstColumn = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));
		for (int i = 0; i < firstColumn .size(); i++) {
			System.out.println(firstColumn.get(i).getText());
		}
	}
	
	@Test
	public void Print_Specific_Row_Test(){
		WebElement row = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[5]"));
		System.out.println(row.getText());
	}
	
	// It will close the Browser after Test
	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}