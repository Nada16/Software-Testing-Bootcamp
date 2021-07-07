import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumTutorial {
	public static void main(String[] args) throws InterruptedException{
		//Set up testing url
		String googleUrl = "https://www.google.com";
		String appleUrl = "https://www.apple.com";

		//----Setting up Chrome Driver----
		//Put the location of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
		//Initiating your chromedriver
		WebDriver chdriver=new ChromeDriver();
		//Perform test
		openUrl(chdriver, googleUrl);

		//----Setting up Internet Explorer Driver----
		//Put the location of the ie driver
		System.setProperty("webdriver.ie.driver", "C:\\tools\\selenium\\IEDriverServer.exe");
		//Initiating your iedriver
		WebDriver iedriver=new InternetExplorerDriver();		
		//Perform test
		openUrl(iedriver, appleUrl);

		//----Setting up Edge Driver----
		//Put the location of the edge driver
		System.setProperty("webdriver.edge.driver",  "C:\\tools\\selenium\\msedgedriver.exe");
		//Initiating your edgedriver
		WebDriver edriver=new EdgeDriver();
		//Perform test
		openUrl(edriver, googleUrl);

		//----Setting up Firefox Driver----
		//Put the location of the firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		//Initiating your firefoxdriver
		WebDriver fdriver=new FirefoxDriver();
		//Perform test
		openUrl(fdriver, googleUrl);
	}

	public static void openUrl(WebDriver driver, String url) throws InterruptedException {
		//maximize window
		driver.manage().window().maximize();

		//open browser with desried URL
		driver.get(url);

		//Applied wait time
		Thread.sleep(2000);

		//closing the browser
		driver.quit();
		//driver.closePopup(url);
	}
}