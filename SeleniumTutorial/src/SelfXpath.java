import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelfXpath {
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

		//Click on learn more
		driver.findElement(By.xpath("//a[@class='cta__primary' and contains(text(), 'LEARN MORE')]/self::a")).click();
		Thread.sleep(1000);

		//Scroll down to related news container
		WebElement relatedNews = driver.findElement(By.xpath("//div[@class='related-news-container']/self::div"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView({block:'start'});", relatedNews);
		Thread.sleep(2000);

		//Click on the first link of the related news
		driver.findElement(By.xpath("//div[@class='related-news-container']/self::div/descendant::a")).click();
		Thread.sleep(4000);

		//closing the browser
		driver.quit();
	}
}