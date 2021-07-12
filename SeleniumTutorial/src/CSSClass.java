import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSSClass {
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

		//Change language to English
		driver.findElement(By.cssSelector("a._sv4[title='English (US)']")).click();
		Thread.sleep(4000);

		//closing the browser
		driver.quit();
	}
}