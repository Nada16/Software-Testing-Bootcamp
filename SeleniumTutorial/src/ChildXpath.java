import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChildXpath {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String codingdojoUrl = "https://www.aramco.com/";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desried URL and maximize window
		driver.get(codingdojoUrl);
		driver.manage().window().maximize();
		Thread.sleep(4000);

		//Wait for the Cookies notice
		WebElement cookie = driver.findElement(By.xpath("//a[@class='cta cta__primary cookie-policy__cta']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cookie));
		//Accept cookies
		cookie.click();

		//Scroll down to "aramco at a galance" card 
		WebElement card = driver.findElement(By.xpath("//div[@class='key-facts-icons']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", card);
		Thread.sleep(2000);
		
		//Navigate to each child button of the card (3 buttons)
		driver.findElement(By.xpath("//div[@class='key-facts-icons__cta-wrapper']/child::a[contains(text(),'OVERVIEW')]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='key-facts-icons__cta-wrapper']/child::a[contains(text(),'OUR PRODUCTS')]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='key-facts-icons__cta-wrapper']/child::a[contains(text(),'CAREERS AT ARAMCO')]")).click();
		Thread.sleep(5000);

		//closing the browser
		driver.quit();
	}
}