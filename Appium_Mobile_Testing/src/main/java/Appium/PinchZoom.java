package Appium;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class PinchZoom extends ExtentReporter{
	private AppiumDriver driver;

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
		//Package name of the application 
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.maps");
		// This is Launcher activity of the application
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.maps.MapsActivity");

		//Create RemoteWebDriver instance and connect to the Appium server
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testcase1()throws Exception {
		ExtentTest test = extent.createTest("sample test");
		//Wait for the app to load. Then, click on Library. Then, swipe down to hide explore nearby
		Thread.sleep(4000);
		new Swipe(Swipe.Direction.DOWN, driver);

		//Zoom on the map
		zoom(driver);
		test.log(Status.PASS, "Test has passed!");
		test.log(Status.FAIL, "Test has failed!");

	}
	
	public void zoom(AppiumDriver driver) {
		//find the map
		final WebElement map = driver.findElement (By.id ("com.google.android.apps.maps:id/map_frame"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//find map x and y axis on the emulator
		final int x=map.getLocation().getX()+map.getSize().getWidth()/2;
		final int y= map.getLocation().getY()+map.getSize().getHeight()/2;
		System.out.println ("Now zooming");
		
		//define the start and end positions of both fingers
		final TouchAction finger1= new TouchAction(driver);
		PointOption POSfinger1 = PointOption.point(x, y-10);
		PointOption POEfinger1 = PointOption.point(x, y-100);
		finger1.press(POSfinger1).moveTo(POEfinger1);
		final TouchAction finger2= new TouchAction(driver);
		PointOption POSfinger2 = PointOption.point(x, y+10);
		PointOption POEfinger2 = PointOption.point(x, y+10);
		finger2.press(POSfinger2).moveTo(POEfinger2);

		//perform the zooming with a multi touch action
		final MultiTouchAction action= new MultiTouchAction(driver);
		action.add(finger1).add(finger2).perform();
		System.out.println ("Zoom Done");
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(3000);
		driver.quit();
	}
	
}