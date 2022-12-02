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

public class WorkingWithTextBoxAndButton {

	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver2.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void textboxAndButton() {
		
		WebElement txtusername= driver.findElement(By.id("username"));
		WebElement txtPassword= driver.findElement(By.id("password"));
		WebElement btnlogin = driver.findElement(By.className("radius"));
		
		txtusername.clear();
		txtusername.sendKeys("tomsmith");
		
		txtPassword.clear();
		txtPassword.sendKeys("SuperSecretPassword!");
		
		btnlogin.click();
		
		WebElement successNotfication = driver.findElement(By.id("flash"));
		Assert.assertTrue(successNotfication.getText().contains("You logged into a secure area!"));
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	
}
