import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContainXpath {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String codingdojoUrl = "https://www.codingdojo.com/";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desried URL
		driver.get(codingdojoUrl);
		//maximize window
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Click on 'FAQ'
		driver.findElement(By.xpath("//a[contains(text(),'FAQ')]")).click();
		Thread.sleep(2000);

		driver.navigate().back();
		//Click on 'Our Team'
		driver.findElement(By.xpath("//a[contains(text(),'Our Team')]")).click();
		Thread.sleep(2000);
		
		driver.navigate().back();
		//Click on 'Careers'
		driver.findElement(By.xpath("//a[contains(text(),'Careers')]")).click();
		Thread.sleep(2000);

		//closing the browser
		driver.quit();
	}
}