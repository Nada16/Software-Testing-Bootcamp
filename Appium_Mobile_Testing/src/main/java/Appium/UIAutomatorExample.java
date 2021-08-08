package Appium;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Appium.Swipe.Direction;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UIAutomatorExample {
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
		//Swipe up to open apps then Search by text for Phone app and open it
		new Swipe(Direction.APPS, driver);
		Thread.sleep(500);	
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Phone\")").click();
		//Search by text for Nada and scrol into view and click on it
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"Nada\"))").click();
		Thread.sleep(1000);
		//Navigate back using the navigation buttons
		driver.navigate().back();	
		Thread.sleep(1000);
		//Search by id and text for Leena and scrol into view and click on it
		driver.findElement(MobileBy.AndroidUIAutomator(
		 		        "new UiScrollable(new UiSelector().scrollable(true))" +
				         ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.google.android.dialer:id/contact_name\").text(\"Leena\"))")).click();
		Thread.sleep(500);
		//Give Leena a call and wait for a few seconds then hang up
		//Search by id for the buttons
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceIdMatches(\"com.android.contacts:id/header\")").click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceIdMatches(\"com.google.android.dialer:id/incall_end_call\")").click();

	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(2000);
		driver.quit();
	}
	
}