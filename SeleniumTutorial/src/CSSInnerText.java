import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSSInnerText {
	public static void main(String[] args) throws InterruptedException{
		//Set up testing url
		String url = "https://www.facebook.com/";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Open Instagram via Facebook
		driver.findElement(By.cssSelector("a[title*='Instagram']")).click();
		Thread.sleep(2000);
		
		//switch to newly opened tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		//Fill out signing credentials 
		driver.findElement(By.cssSelector("input[aria-label*='username']")).sendKeys("nada.alnoory@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("CodingDojo1234");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(4000);

		//closing the browser
		driver.quit();
	}
}