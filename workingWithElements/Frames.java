package workingWithElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames {

	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver2.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testFrames () {
		
		driver.switchTo().frame("left");
		WebElement msg = driver.findElement(By.tagName("p"));
		assertTrue(msg.getText().contains("This is Left Frame"));
		System.out.println(msg.getText());
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		WebElement msg2 = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This Frame doesn't have id or name", msg2.getText());
		System.out.println(msg2.getText());
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("right");
		WebElement msg3 = driver.findElement(By.tagName("p"));
		assertTrue(msg3.getText().contains("This is Right Frame"));
		System.out.println(msg3.getText());
		driver.switchTo().defaultContent();

	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
