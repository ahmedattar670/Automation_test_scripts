package finindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByName {
	
	
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
	public void FindElementsByTheName() {
		try {
			WebElement usernametxt = driver.findElement(By.name("username"));
			WebElement passwordtxt = driver.findElement(By.name("password"));
			System.out.println(usernametxt.getTagName());
			System.out.println(passwordtxt.getTagName());
		} catch (NoSuchElementException e) {
			System.out.println("Please enter the attribute name right or choose another attribute");
		}
			
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
