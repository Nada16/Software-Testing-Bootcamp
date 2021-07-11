import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver.WindowType;

public class Windows {
	public static void main(String[] args) throws InterruptedException {
		//Perform test on IE,Firefox and Chrome
		testIE();
		testFirefox();
		testChrome();
	}

	private static void testIE() throws InterruptedException {
		//----Setting up Internet Explorer Driver----
		System.setProperty("webdriver.ie.driver", "C:\\tools\\selenium\\IEDriverServer.exe");
		//Change capabilities of the driver to open private mode
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
		@SuppressWarnings("deprecation")
		InternetExplorerDriver iedriver = new InternetExplorerDriver(capabilities);
		
		//Open link in private window
		openIMDB(iedriver);

		// Open box office in a new window using a new driver 
		WebDriver newWindow = new InternetExplorerDriver();
		openWindow(iedriver, newWindow);

		//Open new tab
		openTab(newWindow);	
		iedriver.quit();
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

		//Open link in private window
		openIMDB(fdriver);

		// Open box office in a new window using a new driver 
		WebDriver newWindow = new FirefoxDriver();
		openWindow(fdriver, newWindow);

		//Open new tab
		openTab(newWindow);	
		fdriver.quit();
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
		
		//Open link in private window
		openIMDB(chdriver);

		// Open box office in a new window using a new driver 
		WebDriver newWindow = new ChromeDriver();
		openWindow(chdriver, newWindow);

		//Open new tab
		openTab(newWindow);	
		chdriver.quit();
	}

	public static void openIMDB(WebDriver driver) throws InterruptedException {
		//Testing url
		String url = "https://www.imdb.com/";

		//Maximize window and open URL
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(1000);
	}
	
	private static void openWindow(WebDriver driver, WebDriver newWindow) throws InterruptedException {
		String BOLink = driver.findElement(By.xpath("//h3[text()='Top box office (US)']/parent::a")).getAttribute("href");

		//Maximize window and open URL
		driver.manage().window().maximize();
		newWindow.get(BOLink);

		Thread.sleep(1000);
	}
	
	public static void openTab(WebDriver driver) throws InterruptedException {
		// Open new tab
		String openinNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath("//tr[1]/td/a[1]")).sendKeys(openinNewTab);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));

		Thread.sleep(100000);

		driver.quit();
	}
}