package Selenddroid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

public class SelendroidExample {

	@Test
	public void testcase1()throws Exception {
		SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.17.0");
		
		capa.setCapability("udid", "192.168.199.103:5555");
		capa.setEmulator(true);
		
		WebDriver driver = new SelendroidDriver(capa);
		
		Thread.sleep(5000);

		driver.quit();
	}


}