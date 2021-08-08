package Appium;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.offset.ElementOption.element;
import Appium.Swipe.Direction;

public class PhoneTap {
	private AppiumDriver  driver;

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
		driver = new AppiumDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testcase1()throws Exception {
		//Swipe up and open contacts app
		new Swipe(Direction.APPS, driver);
		TouchAction action = new TouchAction(driver);
		action.tap(element(driver.findElementByAccessibilityId("Contacts"))).perform();
		Thread.sleep(500);

		//Add a contact
		action.tap(element(driver.findElementById("com.android.contacts:id/floating_action_button_container"))).perform();
		Thread.sleep(500);
		//Enter first name
		driver.findElementByClassName("android.widget.EditText").sendKeys("Nada");
		
		//Save then delete contact
		action.tap(element(driver.findElementById("com.android.contacts:id/editor_menu_save_button"))).perform();
		Thread.sleep(500);
		action.tap(element(driver.findElementByAccessibilityId("More options"))).perform();
		Thread.sleep(500);
		action.tap(element((WebElement) driver.findElementsById("android:id/content").get(1))).perform();
		Thread.sleep(500);
		action.tap(element(driver.findElementById("android:id/button1"))).perform();
		
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(1000);
		driver.quit();
	}
}
