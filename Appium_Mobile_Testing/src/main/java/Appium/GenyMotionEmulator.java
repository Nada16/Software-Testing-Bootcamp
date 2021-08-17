package Appium;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Appium.Swipe.Direction;

import io.appium.java_client.android.AndroidDriver;

public class GenyMotionEmulator {
	private AndroidDriver driver;

	@BeforeTest
	public void testCaseSetup()throws Exception {
		//Set up desired capabilities and pass the device configurations
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//Device ID
		capabilities.setCapability("udid","192.168.199.101:5555");
		//Create RemoteWebDriver instance and connect to the Appium server
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testcase1()throws Exception {
		//Swipe up to open discover applications
		new Swipe(Direction.APPS, driver);
		Thread.sleep(500);
		//Open the phone app
		driver.findElementByAccessibilityId("Phone").click();
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(2000);
		driver.quit();
	}

}