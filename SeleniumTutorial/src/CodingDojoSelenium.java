import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodingDojoSelenium {
	public static void main(String[] args) throws InterruptedException{
		//Set up testing url
		String codingdojoUrl = "https://www.codingdojo.com/";

		//----Setting up Chrome Driver----
		//Put the location of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
		//Initiating your chromedriver
		WebDriver chdriver=new ChromeDriver();

		//Perform test
		//open browser with desried URL
		chdriver.get(codingdojoUrl);
		//maximize window
		chdriver.manage().window().maximize();
		//Applied wait time
		Thread.sleep(2000);

		//closing the browser
		chdriver.quit();
	}
}