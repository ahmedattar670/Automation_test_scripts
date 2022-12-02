package workingWithElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadImage {

	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver2.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testUploadImage() throws InterruptedException {
		
		String image = "avatar-blank.jpg";
		String imgPath = System.getProperty("user.dir")+"/uploads/"+image;
		
		WebElement FileUpload = driver.findElement(By.id("file-upload"));
		FileUpload.sendKeys(imgPath);
		
		WebElement FileUploadbtn = driver.findElement(By.id("file-submit"));
		FileUploadbtn.click();
		
		WebElement UploadedFile = driver.findElement(By.id("uploaded-files"));
		System.out.println(UploadedFile.getText());
		
		Thread.sleep(2000);
		Assert.assertEquals(image, UploadedFile.getText());
		
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
}
