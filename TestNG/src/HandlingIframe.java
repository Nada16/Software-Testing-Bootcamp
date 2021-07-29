import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HandlingIframe {
	private WebDriver driver;
	private int count = 1;

	@BeforeSuite
	public void InitialiseDriver() throws InterruptedException {
		//----Setting up Firefox Driver and open IMDB----
		String url = "https://www.imdb.com/";
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(500);
	}

	@BeforeTest
	@BeforeMethod
	public void switchToFrame() {
		//Switch to iframe if isn't switched already 
		if (driver.findElements(By.id("taboola_iframe")).size() > 0) {
			driver.switchTo().frame("taboola_iframe"); //switching the frame by ID
			System.out.println("======Switching to the iframe======");
		}
	}

	@Test(dataProvider="elements")
	public  void openNewsIframe(WebElement element) throws InterruptedException {
		Reporter.log("======Opening news " + count + "======");
		Thread.sleep(1000); 
		//Clicks the first news on the iframe
		element.click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void closeTab() {
		//Close news tab
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.close();
		System.out.println("======2nd tab was closed======");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
	}

	@AfterSuite
	public void CloseDriver() {
		//Closing the browser
		driver.quit();
		System.out.println("======Test is done. Closing driver======");
	}

	@DataProvider(name = "elements")
	public WebElement[] dataProviderfunc(){
		//Return an array with the news elements reference of the iframe
		List<WebElement> elemLst = driver.findElements(By.cssSelector("span.thumbBlock"));
		WebElement[] elements = new WebElement[elemLst.size()]; 
		elemLst.toArray(elements); 

		//Scroll to the iframe
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elements[0]);
		
		return elements;
	}
}	
