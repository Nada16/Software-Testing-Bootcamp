import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert; 
public class TestNG1 {
	
	@Test
	public void testGoogle() throws InterruptedException {
		//----Setting up Edge Driver----
		System.setProperty("webdriver.edge.driver", "C:\\\\tools\\\\selenium\\\\msedgedriver.exe");      
		WebDriver driver = new EdgeDriver();      
		
		//Maximize the window and open testing url
		driver.manage().window().maximize();
		driver.get("http://google.com"); 
		
		//Check if the title is equal to "Google"
		String title=driver.getTitle();    
		Assert.assertEquals(title,"Google");
		
		//Close browser
		Thread.sleep(3000);
		driver.close();
	} 
	
}