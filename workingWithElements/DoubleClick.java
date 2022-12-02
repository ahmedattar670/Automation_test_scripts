package workingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClick {

	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");	
	}
	
	@Test
	public void DoubleClicks() throws InterruptedException {
		
		WebElement color = driver.findElement(By.id("message"));
		Assert.assertEquals("rgba(0, 0, 255, 1)",color.getCssValue("background-color"));
		Actions builder = new Actions(driver);
		builder.doubleClick(color).perform();
		Assert.assertEquals("rgba(255, 255, 0, 1)",color.getCssValue("background-color"));
		Thread.sleep(3000);
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
}
