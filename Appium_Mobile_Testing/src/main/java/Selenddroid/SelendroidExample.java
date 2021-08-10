package Selenddroid;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

public class SelendroidExample {

	@Test
	public void testcase1()throws Exception {
		SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.17.0");
		capa.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		//Operating system version (could be a letter or a number)
		capa.setCapability(AndroidMobileCapabilityType.VERSION, "11");
		//Device Name
		capa.setCapability("deviceName", "sdk_gphone_x86");
		capa.setEmulator(true);
		
		
		WebDriver driver = new SelendroidDriver(capa);
		
		Thread.sleep(5000);
//		WebElement inputField = driver.findElement(By.id("my_text_field"));
//		Assert.assertEquals("true", inputField.getAttribute("enabled"));
//		inputField.sendKeys("Selendroid");
//		Assert.assertEquals("Selendroid", inputField.getText());
		driver.quit();
	}


}