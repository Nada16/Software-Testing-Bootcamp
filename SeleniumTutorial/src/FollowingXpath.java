import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FollowingXpath {
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

		//Accept cookies
		driver.findElement(By.xpath("//a[@class='cta cta__primary cookie-policy__cta']")).click();

		//Click on the search symbol and search for "Aramco"
		String sxpath = "//button[@class='main-nav__main-search-open']";
		driver.findElement(By.xpath(sxpath)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sxpath + "/following::input")).sendKeys("Aramco" + Keys.ENTER);
		Thread.sleep(4000);

		//Scroll down to first search result an click on it 
		WebElement search1 = driver.findElement(By.xpath("//div[@class='search-results__results']//following::h3/a[1]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", search1);
		Thread.sleep(2000);
		search1.click();
		Thread.sleep(4000);

		//Go back to search results 
		driver.navigate().back();
		Thread.sleep(1000);
		//Scroll down to first search result an click on it 
		WebElement search2 = driver.findElements(By.xpath("//div[@class='search-results__results']//following::h3/a[1]")).get(1);
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", search2);
		Thread.sleep(2000);
		search2.click();
		Thread.sleep(4000);

		//Go back to Aramco home page (two pages back)
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(2000);

		//Click on "find out more" about the response of covid-19
		driver.findElement(By.xpath("//div[@class='promotional-page-link__cta-wrapper']/following::a[2]")).click();
		Thread.sleep(2000);

		//closing the browser
		driver.quit();
	}
}