package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtons {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", chromePath);
		driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");	
	}
	
	@Test
	public void WorkingWithCheckBoxes() {
		
		WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		check1.click();
		WebElement check2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		if (check2.isSelected()) {
			check2.click();
			}
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
