package finindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindingElementsByID {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	public void FindElementsByTheID() {
		
		WebElement element1 = driver.findElement(By.id("username"));
		WebElement element2 = driver.findElement(By.id("password"));
		System.out.println(element1.getTagName());
		System.out.println(element2.getTagName());
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
