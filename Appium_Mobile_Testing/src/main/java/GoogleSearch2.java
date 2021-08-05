import java.net.URL;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class GoogleSearch2 {
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;

	@SuppressWarnings("rawtypes")
	@BeforeTest
	public void testCaseSetup()throws Exception {
		//Set up desired capabilities and pass the device configurations
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//Device operating system
		capabilities.setCapability("platformName", "Android");
		//Operating system version (could be a letter or a number)
		capabilities.setCapability("VERSION", "Q");
		//Device Name
		capabilities.setCapability("deviceName", "Nexus S API Q");

		//Browser name
		//capabilities.setCapability("BROWSER_NAME", "Android");

		//Create RemoteWebDriver instance and connect to the Appium server
		//It will launch the Clock Application in Android Device using Desired Capabilities configurations
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testcase1()throws Exception {
		//Open Chrome by clicking on the logo
		driver.findElementByAccessibilityId("Chrome").click();
		//Check what context we're using
		System.out.println("Current context: " + driver.getContext());
		
		//Print contexts that we can change to
		@SuppressWarnings("unchecked")
		Set<String> contexts = driver.getContextHandles();
		System.out.println("List of possible contexs: ");
		for(String con: contexts) {
			System.out.println("- " + con);
		}
		//Change context to WebView
		driver.context( (String) contexts.toArray()[1]);
		//Check what context we're using
		System.out.println("Current context: " + driver.getContext());
		Thread.sleep(1000);

		//Navigate to Google and search for "Coding Dojo"
		driver.get("https://www.google.com/");
		Thread.sleep(500);
		driver.findElementByName("q").sendKeys("Coding Dojo" + Keys.ENTER);

		//Change context to NativeApp
		driver.context("NATIVE_APP");
		//Check what context we're using
		System.out.println("Current context: " + driver.getContext());
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(2000);
		driver.quit();
	}
}