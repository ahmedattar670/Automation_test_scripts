package workingWithElements;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetBrokenImages {
	
	WebDriver driver;

	private int invalidImage=0;
	
	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver2.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testBrokenImages() {
		
		List<WebElement> imgs = driver.findElements(By.tagName("img"));
		
		for(WebElement photo : imgs) {
			if (photo != null) {
				VerifyBrokenImages(photo);
			}
		}
		
		//for (int i = 0 ; i<imgs.size(); i++) {
			//WebElement element = imgs.get(i);
			//VerifyBrokenImages(element);
		//}
		
		System.out.println("The number of invalid images is : "+invalidImage);
	}
	
	public void VerifyBrokenImages(WebElement img) {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(img.getAttribute("src"));
		try {
			HttpResponse response = client.execute(request);
			
			if(response.getStatusLine().getStatusCode() != 200) {		
				invalidImage++;
			}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	

}
