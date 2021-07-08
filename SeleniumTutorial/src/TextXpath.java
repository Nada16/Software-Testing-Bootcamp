import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextXpath {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String codingdojoUrl = "https://www.codingdojo.com/";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desried URL and maximize window
		driver.get(codingdojoUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Click on Online from the campuses menu
		driver.findElement(By.xpath("//a[text()='Campuses']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Online']")).click();
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		//Click on Dojo Difference from the Dojo Difference menu
		driver.findElements(By.xpath("//a[text()='Dojo Difference']")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//a[text()='Dojo Difference']")).get(1).click();
		Thread.sleep(2000);	

		//closing the browser
		driver.quit();
	}
}