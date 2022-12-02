package workingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver2.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");	
	}
	
	@Test(priority = -1)
	public void showAlert() throws InterruptedException {
		
		WebElement btnAlert = driver.findElement(By.id("simple"));
		btnAlert.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Hello! I am an alert box!", alert.getText());
		alert.accept();
	}
	
	
	@Test(priority = 0)
	public void promptAlert() throws InterruptedException {
		
		WebElement btnAlert = driver.findElement(By.id("prompt"));
		btnAlert.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Ahmed");
		alert.accept();
		Thread.sleep(3000);
		WebElement txtprompt = driver.findElement(By.id("prompt_demo"));
		Assert.assertEquals("Hello Ahmed! How are you today?",txtprompt.getText());
		
	}
	
	@Test(priority = 1)
	public void confirmAlert() throws InterruptedException {
		
		WebElement btnConfirm = driver.findElement(By.id("confirm"));
		btnConfirm.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		WebElement txtConfirm = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Accepted Alert!", txtConfirm.getText());
		
		Thread.sleep(1500);
	}
	
	@Test(priority = 2)
	public void dismissAlert() throws InterruptedException {
		
		WebElement btnConfirm = driver.findElement(By.id("confirm"));
		btnConfirm.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		Thread.sleep(3000);
		WebElement txtDismiss = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Dismissed Alert!", txtDismiss.getText());
		Thread.sleep(1500);
	}
	
	
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
