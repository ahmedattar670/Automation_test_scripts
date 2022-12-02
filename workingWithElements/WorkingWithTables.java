package workingWithElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTables {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");	
	}
	
	@Test
	public void Tables() {
		
		WebElement table = driver.findElement(By.id("table1"));
		
		//find rows
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Assert.assertEquals(5, rows.size());
		
		//get all cells data
		for (WebElement row : rows) {
			
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.println(col.getText()+"\t");
			}
			System.out.println();
		}
	}
	

	@AfterTest
	public void close() {
		driver.quit();
	}


}
