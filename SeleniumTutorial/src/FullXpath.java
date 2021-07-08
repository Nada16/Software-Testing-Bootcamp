import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FullXpath {
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
		
		//Click on the first video and let it run for 10 sec then close it
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/header/div[1]/div[7]/a")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/a")).click();
		Thread.sleep(2000);
		
		//Scroll down to Alumni section 
		WebElement vid = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[2]/div[2]/div/div[1]/div[3]/a"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", vid);
		Thread.sleep(2000);
		
		//Open the third video and let it finish then close it
		vid.click();
		Thread.sleep(40000);
		driver.findElement(By.xpath("/html/body/div[24]/div/div/a")).click();
		Thread.sleep(2000);

		//closing the browser
		driver.quit();
	}
}