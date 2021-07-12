import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String url = " https://www.deal4loans.com/apply-home-loans.php";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Locate check box and click on it to (check/uncheck) it
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(4000);
		
		//closing the browser
		driver.quit();
	}
}