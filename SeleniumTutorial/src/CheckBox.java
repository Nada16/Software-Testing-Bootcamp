import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String url = "https://www.demoqa.com/radio-button";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Locate yes radio button and click on it to check it
		driver.findElement(By.cssSelector("div.custom-control:nth-child(2) > label:nth-child(2)")).click();
		Thread.sleep(3000);
		
		//closing the browser
		driver.quit();
	}
}