import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavatpointSelenium {
	public static void main(String[] args) throws InterruptedException {
		//----Setting up Firefox Driver----
		//Put the location of the firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		//Initiating your firefoxdriver
		WebDriver fdriver=new FirefoxDriver();

		//Perform test
		//maximize window
		fdriver.manage().window().maximize();
		//open browser with desried URL
		fdriver.get("https://www.javatpoint.com/");
		//Applied wait time
		Thread.sleep(1000);
		
		//Identify search box
		WebElement searchTxtBox = fdriver.findElement(By.name("search"));
		//Send "Java"
		searchTxtBox.sendKeys("Java");
		//Applied wait time
		Thread.sleep(1000);
		
		//Hit the search button
		WebElement searchBtn = fdriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/table/tbody/tr/td/div[2]"
		+"/div/div/div/form/table/tbody/tr/td[2]/button"));
		searchBtn.click();
		//Applied wait time
		Thread.sleep(2000);
		
		//Close driver
		fdriver.close();
	}
}