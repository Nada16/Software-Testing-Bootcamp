package Appium;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Appium.Swipe.Direction;
import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;

public class ScrollSwipe {
	private AndroidDriver driver;
	String contactName = "Nada";

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

		//Create RemoteWebDriver instance and connect to the Appium server
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testcase1()throws Exception {
		new Swipe(Direction.APPS, driver);
		Thread.sleep(500);
		driver.findElementByAccessibilityId("Phone").click();

		Thread.sleep(500);
		//Open the contacs tab
		driver.findElementById("com.google.android.dialer:id/contacts_tab").click();
		
		//Scroll to Nada
		System.out.println("Scrolling to text '" + contactName + "'");
		driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"Nada\"))"));
		driver.findElementByAccessibilityId("Quick contact for Nada").click();
		driver.findElementById("com.android.contacts:id/icon").click();
		Thread.sleep(5000);
		driver.findElementById("com.google.android.dialer:id/incall_end_call").click();
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(2000);
		driver.quit();
	}
	
}