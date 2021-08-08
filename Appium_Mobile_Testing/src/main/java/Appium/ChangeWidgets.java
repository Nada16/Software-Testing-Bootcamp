package Appium;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
public class ChangeWidgets {
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
		//Hold the Maps app and move it next to Chrome then release it to change its location
		new TouchAction(driver)
		.press(element((AndroidElement) driver.findElementByAccessibilityId("Maps")))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(6)))
		.moveTo(element((AndroidElement) driver.findElementByAccessibilityId("Chrome")))
		.release()
		.perform();
		
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(2000);
		driver.quit();
	}
	
}