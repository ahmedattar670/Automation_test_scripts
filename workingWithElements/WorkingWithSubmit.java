package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSubmit {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/?hl=ar");
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void submitCommand() {
		
		WebElement txtSearch = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
		txtSearch.clear();
		txtSearch.sendKeys("Selenium Webdriver");
		txtSearch.submit();
		WebElement tSearch = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
		tSearch.clear();
		tSearch.sendKeys("Selenium Webdriver Book");
		tSearch.submit();
		
		
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
