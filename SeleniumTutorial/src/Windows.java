import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Windows {
	public static void main(String[] args) throws InterruptedException {
		//Perform test on IE,Firefox and Chrome
		testEdge();
		testFirefox();
		testChrome();
	}

	private static void testEdge() throws InterruptedException {
		//----Setting up Edge Driver----
		System.setProperty("webdriver.edge.driver",  "C:\\tools\\selenium\\msedgedriver.exe");
		//Change capabilities of the driver to open private mode
		EdgeOptions op=new EdgeOptions();
		op.setCapability("ms:inPrivate", true);		
		//Initiating your edgedriver
		WebDriver iedriver=new EdgeDriver(op);

		//Perform the test
		performTest(iedriver);
	}

	private static void testFirefox() throws InterruptedException {
		//----Setting up Firefox Driver to open a private window----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		//Change capabilities of the driver to open private mode
		DesiredCapabilities caps = new DesiredCapabilities();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-private");
		caps.setCapability("moz:firefoxOptions",options);
		//Initialize driver
		@SuppressWarnings("deprecation")
		WebDriver fdriver = new FirefoxDriver(caps);

		//Perform the test
		performTest(fdriver);
	}

	private static void testChrome() throws InterruptedException {
		//----Setting up Chrome Driver----
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");		
		//Change capabilities of the driver to open private mode
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("--incognito");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(ChromeOptions.CAPABILITY,options1);
		//Initiating your chromedriver
		@SuppressWarnings("deprecation")
		WebDriver chdriver=new ChromeDriver(caps);

		//Perform the test
		performTest(chdriver);
	}

	public static void performTest(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		//Open IMDB in private window
		openIMDB(driver);
		Thread.sleep(1000);

		// Open box office in a new window using a new driver 
		openWindow(driver);
		Thread.sleep(2000);

		//Open the first box office movie on a new tab
		openTab(driver);	
		Thread.sleep(5000);

		//Close driver
		driver.quit();
	}

	public static void openIMDB(WebDriver driver) {
		//Testing url
		String url = "https://www.imdb.com/";
		//Maximize window and open URL
		driver.manage().window().maximize();
		driver.get(url);
	}

	private static void openWindow(WebDriver driver) {
		//Open new window
		String openinNewWindow = Keys.chord(Keys.SHIFT,Keys.RETURN);
		driver.findElement(By.xpath("//h3[text()='Top box office (US)']/parent::a")).sendKeys(openinNewWindow);
		//Switch to newly opened window and maximize it
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		driver.manage().window().maximize();
	}

	public static void openTab(WebDriver driver) throws InterruptedException {
		// Open new tab
		String openinNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath("//tr[1]/td/a[1]")).sendKeys(openinNewTab);
		//switch to newly opened tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
	}
}