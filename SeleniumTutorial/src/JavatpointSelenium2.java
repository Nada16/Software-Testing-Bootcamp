import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavatpointSelenium2 {
	public static void main(String[] args) throws InterruptedException {
		//----Setting up Chrome Driver----
		//Put the location of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
		//Initiating your chromedriver
		WebDriver chdriver=new ChromeDriver();

		//Perform test
		//maximize window
		chdriver.manage().window().maximize();
		//open browser with desried URL
		chdriver.get("https://www.javatpoint.com/");
		//Applied wait time
		Thread.sleep(1000);

		//Scroll down through the web page.
		//Declare Javascript executor from the driver
		JavascriptExecutor jse = (JavascriptExecutor) chdriver;
		//Scroll all the way down (scroll as much as the height of the page)
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//Apply wait time
		Thread.sleep(2000);
		
		//Click on "Core Java" link from the Java Technology section.
		WebElement coreJava = chdriver.findElement(By.xpath("/html/body/div/div/div[4]/div/table/tbody/tr/td/fieldset[11]/div[1]/a[1]"));
		coreJava.click();
		//Applied wait time
		Thread.sleep(2000);

		//Close driver
		chdriver.close();
	}
}
