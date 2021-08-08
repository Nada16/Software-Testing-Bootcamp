import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;

public class AppiumServer {
	//private String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.app.zip";

	private AppiumDriver driver;
	private static AppiumDriverLocalService server;

	@BeforeSuite
	public static void startAppiumServer() {
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		// Use any port, in case the default 4723 is already taken (maybe by another Appium server)
		serviceBuilder.usingAnyFreePort();
		// Tell serviceBuilder where node is installed. Or set this path in an environment variable named NODE_PATH
		serviceBuilder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
		// Tell serviceBuilder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
		serviceBuilder.withAppiumJS(new File("C:\\Users\\nal-n\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));

		server = AppiumDriverLocalService.buildService(serviceBuilder);
		server.start();
	}

	@BeforeTest
	public void startSession() throws MalformedURLException {
		//Set up desired capabilities and pass the device configurations
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//Device operating system
		capabilities.setCapability("platformName", "Android");
		//Operating system version (could be a letter or a number)
		capabilities.setCapability("VERSION", "Q");
		//Device Name
		capabilities.setCapability("deviceName", "Nexus S API Q");
		
		//To open the browser
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

		//Create RemoteWebDriver instance and connect to the Appium server
		System.out.println("===================" + server.getUrl());
		driver = new AppiumDriver(server.getUrl(), capabilities);
	}

	@AfterTest
	public void endSession() {
		try {
			driver.quit();
		} catch (Exception ign) {}
	}

	@AfterSuite
	public static void stopAppiumServer() {
		server.stop();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(500);
		driver.findElementByName("q").sendKeys("Coding Dojo" + Keys.ENTER);
	}
}