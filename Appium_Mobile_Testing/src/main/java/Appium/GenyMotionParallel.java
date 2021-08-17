package Appium;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Appium.Swipe.Direction;

import io.appium.java_client.android.AndroidDriver;

public class GenyMotionParallel {

	@Test(dataProvider = "data-provider")
	public void initializeDriver(String udid) throws Exception {
		//Initialise driver with udid and connect it to Appium server
		AndroidDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//Device ID
		capabilities.setCapability("udid",udid);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//Test process:
		//Swipe up to open discover applications
		new Swipe(Direction.APPS, driver);
		Thread.sleep(500);
		//Open the phone app
		driver.findElementByAccessibilityId("Phone").click();
		Thread.sleep(2000);
		//Close the driver
		driver.quit();
	}

	//parallel = true will make sure that the tests are run in parallel not one after another
	@DataProvider(name = "data-provider", parallel=true)
	public Object[][] dataProviderMethod() {
		//pass the udid of the two devices
		return new Object[][] { {"192.168.199.101:5555"}, {"192.168.199.103:5555"} };
	}
}