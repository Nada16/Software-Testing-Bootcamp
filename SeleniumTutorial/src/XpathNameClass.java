import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathNameClass {
	public static void main(String[] args) throws InterruptedException{
		//Set up testing url
		String netflixUrl = "https://www.netflix.com/";

		//----Setting up Chrome Driver----
		//Put the location of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
		//Initiating your chromedriver
		WebDriver chdriver=new ChromeDriver();

		//Perform test
		//open browser with desried URL
		chdriver.get(netflixUrl);
		//maximize window
		chdriver.manage().window().maximize();
		//Applied wait time
		Thread.sleep(2000);

		//Click on email text box and fill it (xpath name)
		chdriver.findElement(By.xpath("//input[@name='email']")).sendKeys("nada.alnoory@gmail.com" + Keys.ENTER);
		//Applied wait time
		Thread.sleep(5000);

		//Click on submit button (xpath class)
		//chdriver.findElement(By.xpath("//span[@class='cta-btn-txt']")).click();
		//Applied wait time
		//Thread.sleep(5000);
		
		//closing the browser
		chdriver.quit();
	}
}