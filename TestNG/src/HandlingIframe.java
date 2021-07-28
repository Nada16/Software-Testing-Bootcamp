import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingIframe {
	private WebDriver driver;

	@BeforeTest
	public void InitialiseDriver() throws InterruptedException {
		//----Setting up Firefox Driver and open Instagram----
		String url = "https://www.imdb.com/";
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test
	public  void open() throws InterruptedException {

		driver.switchTo().frame("taboola_iframe"); //switching the frame by ID

		System.out.println("********We are switch to the iframe*******");
		Thread.sleep(2000);

		WebElement elem = driver.findElement(By.cssSelector("span.thumbBlock"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		Thread.sleep(500); 
		elem.click();
		
		//Clicks the iframe
		Thread.sleep(4000);
		System.out.println("*********We are done***************");
	}

	@AfterTest
	public void CloseDriver() {
		//closing the browser
		driver.quit();
	}


}		

