import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathID {
	public static void main(String[] args) throws InterruptedException{
		//Set up testing url
		String imdbUrl = "https://www.imdb.com/";

		//----Setting up Chrome Driver----
		//Put the location of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
		//Initiating your chromedriver
		WebDriver chdriver=new ChromeDriver();

		//Perform test
		//open browser with desried URL
		chdriver.get(imdbUrl);
		//maximize window
		chdriver.manage().window().maximize();
		//Applied wait time
		Thread.sleep(2000);

		//Click on box office using xpath linktext
		chdriver.findElement(By.xpath("//h3[contains(text(),'Top box office')]")).click();
		//Applied wait time
		Thread.sleep(2000);

		//Click on home page to get back using xpath id
		chdriver.findElement(By.xpath("//a[@id='home_img_holder']")).click();
		//Applied wait time
		Thread.sleep(2000);
		
		//closing the browser
		chdriver.quit();
	}
}