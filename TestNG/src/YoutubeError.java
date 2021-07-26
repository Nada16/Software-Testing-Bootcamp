import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YoutubeError {
	WebDriver driver;
	@BeforeSuite
	public void createDriver() throws InterruptedException {
		//Set up testing url
		String url = "https://www.youtube.com/";
		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@BeforeTest
	public void checkTitle() {
		//Check if the title is equal to "YouTube"
		String title=driver.getTitle();    
		Assert.assertEquals(title,"YouTube");
	}
	
	@Test
	public void checkLibrary() throws InterruptedException {
		//Click on Library
		driver.findElement(By.cssSelector("a.ytd-mini-guide-entry-renderer[title='Library']")).click();
		Thread.sleep(2000);
		//Check the text of the error message
		String error = driver.findElement(By.cssSelector("yt-formatted-string.promo-body-text.style-scope.ytd-background-promo-renderer")).getText();
		Assert.assertEquals(error,"Sign in to access videos that you’ve liked or saved");
		Reporter.log("- Library tab is opened and message is checked");
	}
	
	@Test
	public void checkSubscription() throws InterruptedException {
		//Click on Subscriptions
		driver.findElement(By.cssSelector("a.ytd-mini-guide-entry-renderer[title='Subscriptions']")).click();
		Thread.sleep(2000);
		//Check the text of the error message
		String error = driver.findElements(By.cssSelector("yt-formatted-string.promo-body-text.style-scope.ytd-background-promo-renderer")).get(1).getText();
		Assert.assertEquals(error,"Sign in to see updates from your favorite YouTube channels");
		Reporter.log("- Subscriptions tab is opened and message is checked");
	}
	
	@AfterMethod 
	public void homepage() throws InterruptedException {
		//After every test return to YouTube home page
		driver.findElement(By.xpath("//a[@id='logo' and @title='YouTube Home']")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void closeDriver() {
		//Close the driver
		driver.close();
	}
}
