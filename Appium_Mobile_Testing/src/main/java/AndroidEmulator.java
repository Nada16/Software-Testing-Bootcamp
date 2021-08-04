import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AndroidEmulator {
	private RemoteWebDriver driver;

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
		capabilities.setCapability("appPackage", "com.google.android.deskclock");
		// This is Launcher activity of the application
		capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock"); 

		//Create RemoteWebDriver instance and connect to the Appium server
		//It will launch the Clock Application in Android Device using Desired Capabilities configurations
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testcase1()throws Exception {
		//Navigate to the 'Stop Watch' tap within the application
		driver.findElement(By.xpath("//to[@content-desc='Stopwatch']/android.widget.ImageView")).click();
		Thread.sleep(500);
		//Start the stop watch
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Start']")).click();
		//Pause the stop watch
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Pause']")).click();
	}

	@AfterTest
	public void testCaseTearDown() throws InterruptedException {
		//Stop the test
		Thread.sleep(2000);
		driver.quit();
	}


}