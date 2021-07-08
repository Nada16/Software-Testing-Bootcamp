import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrecedingXpath {
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
		
		//Click on the search symbol and search for "Aramco"
		driver.findElement(By.xpath("//div[@class='main-nav__main-primary-nav']/preceding::button[@class='main-nav__main-search-open']")).click();
		Thread.sleep(2000);
		String sxpath = "//span[contains(text(),'SEARCH')]/parent::button";
		driver.findElement(By.xpath(sxpath + "/preceding::input")).sendKeys("Aramco");
		driver.findElement(By.xpath(sxpath)).click();
		Thread.sleep(4000);

		//Scroll down to first search result an click on it 
		WebElement search1 = driver.findElement(By.xpath("//div[@class='search-results__pagination']/preceding::h3[@class='search-results__result-title']/a[1]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", search1);
		Thread.sleep(2000);
		search1.click();
		Thread.sleep(4000);

		//Go back to search results 
		driver.navigate().back();
		Thread.sleep(1000);
		//Scroll down to first search result an click on it 
		WebElement search2 = driver.findElements(By.xpath("//div[@class='search-results__pagination']/preceding::h3[@class='search-results__result-title']/a[1]")).get(1);
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", search2);
		Thread.sleep(2000);
		search2.click();
		Thread.sleep(4000);

		//closing the browser
		driver.quit();
	}
}