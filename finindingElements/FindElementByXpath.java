package finindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXpath {
	
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
	public void FindElementsByXpath() {
	
			WebElement usernametxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			WebElement passwordtxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button")); 
			System.out.println(usernametxt.getTagName());
			System.out.println(passwordtxt.getTagName());
			System.out.println(loginbtn.getText());
			
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
