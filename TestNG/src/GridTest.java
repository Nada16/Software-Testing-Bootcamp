import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GridTest {
	private WebDriver driver;

	@BeforeSuite
	public void InitialiseDriver() throws InterruptedException, MalformedURLException {
		//----Setting up Chrome Driver----
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");		
		
		//Change capabilities of the driver to open a remote web driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.setCapability(ChromeOptions.CAPABILITY,options);
		options.setCapability("browserName", "chrome");
		options.setCapability("acceptSslCerts", "true");
		options.setCapability("javascriptEnabled", "true");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		options.merge(cap);
		
		//Get node url and use it to create a remote driver
		String nodeUrl = "http://192.168.1.92:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(nodeUrl), options);
	}
	
	@Test
	public void testGoogle() {
		//Open Google and verify the title
		String testUrl = "https://www.google.com/";
		driver.get(testUrl);		
		Assert.assertEquals(driver.getTitle(), "Google");		
	}
	
	@AfterTest
	public void closeDriver() {
		//Close the driver
		driver.quit();
	}
}

