package TestNGListenerDemo;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.testng.Assert; 
import org.testng.annotations.Listeners; 
import org.testng.annotations.Test;

@Listeners(TestNGListenerDemo.TestNGListener.class)
public class TestCases {
	WebDriver driver= new FirefoxDriver();  	
	// Test to pass as to verify listeners . 
	@Test 
	public void Login() {     
		driver.get("http://demo.guru99.com/V4/");     
		driver.findElement(By.name("uid")).sendKeys("mngr34926");     
		driver.findElement(By.name("password")).sendKeys("amUpenu");     
		driver.findElement(By.name("btnLogin")).click(); 
	}  
	// Forcefully failed this test as to verify listener. 
	@Test 
	public void TestToFail() {     
		System.out.println("This method to test fail");     
		Assert.assertTrue(false); 
	} 
}
