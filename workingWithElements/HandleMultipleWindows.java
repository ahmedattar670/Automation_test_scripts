package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleMultipleWindows {

	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");	
	}
	
	
	@Test
	public void handleMultipleWindowsByTitle() throws InterruptedException {
		
		String WindowId = driver.getWindowHandle();
		System.out.println(WindowId);
		driver.findElement(By.id("visitbutton")).click();;
		Thread.sleep(3000);
		for (String WindowID : driver.getWindowHandles()) {
			String title = driver.switchTo().window(WindowId).getTitle();
			if (driver.equals("Visit Us"))
			{
				Assert.assertEquals("Visit Us", driver.getTitle());
				
				driver.close();
			}
			driver.switchTo().window(WindowId);
		}
	}
}
