package Appium;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class Noon {
	private WebDriver driver;

	@BeforeTest
	public void testCaseSetup()throws Exception {
		//Set up desired capabilities and pass the device configurations
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//Device operating system
		capabilities.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		//Operating system version (could be a letter or a number)
		capabilities.setCapability(AndroidMobileCapabilityType.VERSION, "11");
		//Device Name
		capabilities.setCapability("deviceName", "sdk_gphone_x86");
		//To open the browser
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

		//Create RemoteWebDriver instance and connect to the Appium server
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testcase1()throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.get("https://www.noon.com/saudi-en/");
		Thread.sleep(500);

		//Electronics category
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='Categories']/parent::div")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[text()='Electronics']")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[text()='Gaming']")))).click();
		addFirstItemToCart(wait);

		//Beauty category
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='Categories']/parent::div")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[text()='Beauty & Personal Care']")))).click();
		addFirstItemToCart(wait);


		//Groceries category
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='Categories']/parent::div")))).click();
		WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[text()='Grocery']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		addFirstItemToCart(wait);


		//Home category
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='Categories']/parent::div")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[text()='Home & Kitchen']")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[text()='Home Decor']")))).click();
		addFirstItemToCart(wait);


		//School category
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='Back to School']/parent::div")))).click();
		element =  wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='sc-1xjgu8-2 lgLLLe']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='hp0ehb-1 KWRMQ']/div[@class='cart-button']")))).click();

		//Go to cart and Checkout 
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//button[@class='sc-1g6zspo-8 bswpPM']")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='sc-1mdgs01-2 bydguV']/button")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@name='email']")))).sendKeys("doyana3341@5ubo.com"+Keys.TAB+"Tt123456"+Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@id='searchBox']")))).sendKeys("Riyadh"+Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//button[@aria-label='Confirm location']")))).click();
		

		
	}

	public void addFirstItemToCart(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='sc-1x4gzd-1 laCZzz']")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='sc-14wnt1u-0 hxqhii grid']")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='hp0ehb-1 KWRMQ']/div[@class='cart-button']")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//button[@class='sc-1g6zspo-9 fUWDSU']")))).click();
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		//		Thread.sleep(2000);
		//		driver.quit();
	}
}