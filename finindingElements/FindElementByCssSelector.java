package finindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByCssSelector {

ChromeDriver driver;
	
	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	public void FindElementsByCssSelector() {
		
		WebElement txtname = driver.findElement(By.cssSelector("input#username"));
		WebElement txtpassword = driver.findElement(By.cssSelector("input#password"));
		WebElement header = driver.findElement(By.cssSelector("h2"));		
		WebElement btnlogin = driver.findElement(By.cssSelector("button.radius"));
		System.out.println(btnlogin.getText());
		System.out.println(txtpassword.getTagName());
		System.out.println(txtname.getTagName());
		System.out.println(header.getText());
	
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	
}
