import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HandlingIframe {
	private WebDriver driver;

	@BeforeSuite
	public void InitialiseDriver() throws InterruptedException {
		//----Setting up Firefox Driver and open Instagram----
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
		if (driver.findElements(By.id("taboola_iframe")).size() > 0) {
			driver.switchTo().frame("taboola_iframe"); //switching the frame by ID
			System.out.println("******We are switch to the iframe*******");
		}
	}

	@Test(dataProvider="elements")
	public  void openNewsIframe(WebElement element) throws InterruptedException {
		Thread.sleep(1000); 
		//Clicks the iframe

		element.click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void closeTab() {
		//Close new tab
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.close();
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
	}

	@AfterSuite
	public void CloseDriver() {
		//closing the browser
		driver.quit();
		System.out.println("*********We are done***************");
	}

	@DataProvider(name = "elements")
	public WebElement[] dataProviderfunc(){
		List<WebElement> elemLst = driver.findElements(By.cssSelector("span.thumbBlock"));
		WebElement[] elements = new WebElement[elemLst.size()]; 
		elemLst.toArray(elements); 
		System.out.println(elements.length + ": " + elements.toString());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elements[0]);

		return elements;
	}
}		

