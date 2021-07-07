import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//A test performed using Selenium to scroll down the webpage visitsaudi
public class VisitSaudiSelenium {
	public static void main(String[] args) throws InterruptedException {
		//Set up testing url
		String visitSaudiUrl = "https://www.visitsaudi.com/en";

		//----Setting up Internet Explorer Driver----
		//Put the location of the ie driver
		System.setProperty("webdriver.ie.driver", "C:\\tools\\selenium\\IEDriverServer.exe");
		//Initiating your iedriver
		WebDriver iedriver=new InternetExplorerDriver();		
		//Perform test
		//Open url
		openUrl(iedriver, visitSaudiUrl);
		//Scroll all the way down
		scrollDown(iedriver);


		//----Setting up Chrome Driver----
		//Put the location of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
		//Initiating your chromedriver
		WebDriver chdriver=new ChromeDriver();
		//Perform test
		//Open url
		openUrl(chdriver, visitSaudiUrl);
		//Scroll all the way down
		scrollDown(chdriver);

		//----Setting up Firefox Driver----
		//Put the location of the firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		//Initiating your firefoxdriver
		WebDriver fdriver=new FirefoxDriver();
		//Perform test
		//Open url
		openUrl(fdriver, visitSaudiUrl);
		//Scroll all the way down
		scrollDown(fdriver);
	}

	public static void openUrl(WebDriver driver, String url) throws InterruptedException {
		//maximize window
		driver.manage().window().maximize();

		//open browser with desried URL
		driver.get(url);

		//Applied wait time
		Thread.sleep(2000);
	}

	public static void scrollDown(WebDriver driver) throws InterruptedException {
		//Declare Javascript executor from the driver
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		//Scroll all the way down (scroll as much as the height of the page)
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		//Apply wait time
		Thread.sleep(2000);

		//Close Driver
		driver.close();
	}
}
