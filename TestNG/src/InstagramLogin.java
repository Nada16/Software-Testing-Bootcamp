import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class InstagramLogin {
	@Test
	public void instagram() throws InterruptedException {
	//Set up testing url
			String url = "https://www.instagram.com/";

			//----Setting up Firefox Driver----
			System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();

			//open browser with desired URL and maximise window
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(1000);

			//Fill out signing credentials 
			driver.findElement(By.cssSelector("input[aria-label*='username']")).sendKeys("nada.alnoory@gmail.com");
			driver.findElement(By.cssSelector("input[name='password']")).sendKeys("CodingDojo1234");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			Thread.sleep(4000);

			//Check the text of the error message
			String error = driver.findElement(By.xpath("//p[@id='slfErrorAlert']")).getText();
			Assert.assertEquals(error,"The username you entered doesn't belong to an account. Please check your username and try again.");

			//closing the browser
			driver.quit();
	}
}
