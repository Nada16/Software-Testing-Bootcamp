import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class HandlingPopUp {
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

		//To open an Application (Clock application). Pass "Android" as Browser, and pass Package, Activity of the application
		//Browser name
		capabilities.setCapability("BROWSER_NAME", "Android");
		//Package name of the application 
		capabilities.setCapability("appPackage", "com.android.contacts");
		// This is Launcher activity of the application
		capabilities.setCapability("appActivity", ".activities.PeopleActivity"); 

		//Create RemoteWebDriver instance and connect to the Appium server
		//It will launch the Clock Application in Android Device using Desired Capabilities configurations
		driver = new AppiumDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void testcase1()throws Exception {
		//Click on the + button to add a contact
		driver.findElementById("com.android.contacts:id/floating_action_button_container").click();
		//Wait for do you want to create an account message
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.contacts:id/left_button"))).click();
		Thread.sleep(500);
		//Enter first name
		driver.findElementByClassName("android.widget.EditText").sendKeys("Nada");
		//Save contact
		driver.findElementById("com.android.contacts:id/editor_menu_save_button").click();
		Thread.sleep(500);
		//Delete contact
		driver.findElementByAccessibilityId("More options").click();
		Thread.sleep(1000);
		((WebElement) driver.findElementsById("android:id/content").get(1)).click();
		Thread.sleep(1000);
		//Confirm deletion
		driver.findElementById("android:id/button1").click();
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(1000);
		driver.quit();
	}
}
