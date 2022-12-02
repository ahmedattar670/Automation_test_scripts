package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownList {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", chromePath);
		driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");	
	}
	
	@Test
	public void WorkingWithDropdownList() {
		
		WebElement optionList = driver.findElement(By.id("dropdown"));
		Select selectedOption = new Select(optionList);
		
		Assert.assertFalse(selectedOption.isMultiple());
		Assert.assertEquals(3, selectedOption.getOptions().size());
		
		selectedOption.selectByVisibleText("Option 1");
		selectedOption.selectByValue("2");
		selectedOption.selectByIndex(1);
		Assert.assertEquals("Option 1", selectedOption.getFirstSelectedOption().getText());
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	

}
