import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AncestorXpath {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String aramcoUrl = "https://www.aramco.com/";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desried URL and maximize window
		driver.get(aramcoUrl);
		driver.manage().window().maximize();
		Thread.sleep(4000);

		//Wait for the Cookies notice
		WebElement cookie = driver.findElement(By.xpath("//a[@class='cta cta__primary cookie-policy__cta']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cookie));
		//Accept cookies
		cookie.click();

		//Navigate to View Overview via "who we are" > "overview" > "view overview"
		driver.findElement(By.xpath("//span[text()='Who we are']/ancestor::a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Overview']/ancestor::a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='View Overview']/ancestor::a")).click();

		Thread.sleep(5000);
		
		//closing the browser
		driver.quit();
	}
}