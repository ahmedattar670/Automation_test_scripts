package workingWithElements;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeScreenShot {

	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver2.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");	
	}
	
	@Test
	public void testScreenShot() {
		
		WebElement txt = driver.findElement(By.id("twotabsearchtextboxm"));
		txt.sendKeys("Selenium Webdriver Book");
		txt.submit();
		Assert.assertTrue(driver.getTitle().contains("Selenium Webdriver"));
	}
	
	@AfterMethod
	public void screenShot(ITestResult result) throws IOException {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShot/"+result.getName()+".png"));	
		}	
	}
		
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	
}
