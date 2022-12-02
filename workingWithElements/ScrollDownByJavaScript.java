package workingWithElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollDownByJavaScript {

	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestScrollDown() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,4500)");
		Thread.sleep(2000);
		WebElement logo = driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
		Assert.assertTrue(logo.isDisplayed());
		
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
