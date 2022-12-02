package finindingElements;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jdk.javadoc.internal.doclets.formats.html.markup.Links;

public class FindElementByFindElements {

ChromeDriver driver;
	
	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com");
	}
	
	@Test
	public void findElementsByFindElements() {
		//Get all the links displayed on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//verify there are 46 links displayed on the page
		Assert.assertEquals(46, links.size());
		
		
		//print each link value
		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));
		}
		
	}
	
     @AfterTest
	public void close() {
		driver.quit();
	 }    

	
}
