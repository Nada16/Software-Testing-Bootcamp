import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrossBrowser {
	WebDriver driver;
	@Test(dataProvider="browser")  
	public void initializingBrowser( String browser) throws InterruptedException {        
		if(browser.equalsIgnoreCase("chrome")) {
			//Initialise Chrome
			System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");		
			driver=new ChromeDriver();
			Reporter.log("Chrome driver was initialised");
		}
		else if(browser.equalsIgnoreCase("edge")) {
			//Initialise Edge
			System.setProperty("webdriver.edge.driver", "C:\\\\tools\\\\selenium\\\\msedgedriver.exe");      
			driver = new EdgeDriver();
			Reporter.log("Chrome driver was initialised");
		}
		else {
			//Check if browser is other than firefox
			if(!browser.equalsIgnoreCase("firefox")) {
				Reporter.log(browser + " is not a supported browser. Firefox will be used instead");
			}
			//Initialise Firefox
			System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
			Reporter.log("Firefox driver was initialised");
		}

		//Set up testing url
		String url = "https://www.facebook.com/";
		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Change language to English
		List<WebElement> en = driver.findElements(By.cssSelector("a._sv4[title='English (US)']"));
		if(en.size() > 0) {
			en.get(0).click();
		} else {
			Reporter.log("Language is already English");
		}
		
		//Check that language is changed
		String connectMsg = driver.findElement(By.cssSelector("h2._8eso")).getText();
		Assert.assertEquals(connectMsg, "Connect with friends and the world around you on Facebook.");
		Reporter.log("Language of Facebook was changed to 'English (US)'");

		//Close driver
		Thread.sleep(1000);
		driver.close();
	}
	
	@DataProvider(name = "browser")public Object[] dataProviderfunc(){
		return new Object[]{"chrome", "edge", "Safari"};
	}
}
