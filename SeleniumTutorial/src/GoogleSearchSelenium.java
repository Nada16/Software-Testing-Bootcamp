import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class GoogleSearchSelenium {
	public static void main(String[] args) throws InterruptedException {
		//----Setting up Internet Explorer Driver----
		//Put the location of the ie driver
		System.setProperty("webdriver.ie.driver", "C:\\tools\\selenium\\IEDriverServer.exe");

		//Initiating your iedriver
		WebDriver iedriver=new InternetExplorerDriver();		

		//Perform test
		//maximize window
		iedriver.manage().window().maximize();
		//open browser with desried URL
		iedriver.get("https://www.google.com/");
		//Applied wait time
		Thread.sleep(1000);

		//Identify search box
		WebElement searchTxtBox = iedriver.findElement(By.name("q"));
		//Will send string character by character (Very slow)
		//searchTxtBox.sendKeys("javatpoint tutorials");
		//Will send string all at once
		((JavascriptExecutor)iedriver).executeScript("arguments[0].value = arguments[1];", searchTxtBox,"javatpoint tutorials");
		//Applied wait time
		Thread.sleep(1000);
		
		//Hit the search button
		WebElement searchBtn = iedriver.findElement(By.name("btnK"));
		searchBtn.submit();
		//Applied wait time
		Thread.sleep(2000);
		
		//Close driver
		iedriver.close();
	}
}
