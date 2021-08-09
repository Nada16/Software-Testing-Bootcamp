package Appium;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class AmazonSignIn {
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
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amazon.mShop.android.shopping");
		// This is Launcher activity of the application
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.android.home.HomeActivity");

		//Create RemoteWebDriver instance and connect to the Appium server
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testcase1()throws Exception {
		//Wait for the app to load. Then, click on the skip signin button
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button"))).click();
		Thread.sleep(3000);
		//Choose the Saudi market
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.amazon.mShop.android.shopping:id/btn_redirect_marketplace"))).click();
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(6000);
		driver.quit();
	}
	
}