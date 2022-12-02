package workingWithElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetBrokenLinks {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver2.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testBrokenURLs() throws IOException {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of links is : "+links.size());
		
		for(int i =0 ; i<links.size() ; i++) {
			
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyLinks(url);
			
		}
		
	}
	
	public static void verifyLinks(String urlLink) throws IOException {
		
		try {
			URL link = new URL(urlLink);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			if (httpConn.getResponseCode() == 200 ) {
				System.out.println(urlLink +" - "+httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 400 ) {
				System.out.println(urlLink +" - "+httpConn.getResponseMessage());
			}
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
}
