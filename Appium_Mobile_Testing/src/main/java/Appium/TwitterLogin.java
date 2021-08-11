package Appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class TwitterLogin {
	private RemoteWebDriver driver;

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
	public void testcase1(){
		//Navigate to Twitter
		driver.get("https://www.twitter.com/");
		
		//click on Not now when it asks to download twitter app
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Not now']"))).click();
		//click on log in and choose "use phone, email or username"
		driver.findElementByXPath("//span[text()='Log in']").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Use phone, email or username']"))).click();
		//fill email, and password and click log in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='session[username_or_email]']"))).sendKeys("email@email.com");
		driver.findElementByXPath("//input[@name='session[password]']").sendKeys("123456");
		driver.findElementByXPath("//span[text()='Log in']").click();
		//fill phone number, and password and click log in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='session[username_or_email]']"))).sendKeys("0555555555");
		driver.findElementByXPath("//input[@name='session[password]']").sendKeys("123456");
		driver.findElementByXPath("//span[text()='Log in']").click();
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(6000);
		driver.quit();
	}
}