import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicXpath {
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

		//Click on 'Our Team'
		driver.findElement(By.xpath("//a[contains(text(),'Our Team')]")).click();
		Thread.sleep(2000);

		//Declare Javascript executor from the driver
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Locate Jim and scroll down to his info
		WebElement jim = driver.findElement(By.xpath("//div[@class='team_img_container jim_dutkiewycz']"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", jim);
		Thread.sleep(3000);

		//Locate Rinu and scroll down to his info
		WebElement rinu = driver.findElement(By.xpath("//div[@class='team_img_container rinu_rajan']"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", rinu);
		Thread.sleep(3000);

		//closing the browser
		driver.quit();
	}
}