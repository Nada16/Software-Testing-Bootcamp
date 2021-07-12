import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollKeys {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String url = "https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Scroll down to the bottom of the page
		driver.findElement(By.xpath("//body")).sendKeys(Keys.END);
		Thread.sleep(3000);
		
		//closing the browser
		driver.quit();
	}
}