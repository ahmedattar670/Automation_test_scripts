package workingWithElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWait {

	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");	
		driver.manage().window().maximize();
	}
	
	@Test
	public void testExplicitWait() {
		
		WebElement txtQuery = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
		txtQuery.sendKeys("Selenium Webdriver");
		txtQuery.submit();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Selenium"));
		assertTrue(driver.getTitle().toLowerCase().contains("selenium webdriver"));
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
