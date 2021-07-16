import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		//----Setting up Firefox Driver----
		//Testing url
		String codingdojoUrl = "https://the-internet.herokuapp.com/javascript_alerts";
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//open browser with desried URL
		driver.get(codingdojoUrl);
		//maximize window
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Click on button to show alert
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		//Switch to Alert
		Alert a = driver.switchTo().alert();

		//Get alert text
		String s = a.getText();
		System.out.println("Alert text is: " + s);
		Thread.sleep(1000);

		//Enter text
		a.sendKeys("Nice to meet u! I'm Nada");
		Thread.sleep(3000);

		//Accept alert
		a.accept();
		Thread.sleep(3000);
		driver.quit();

	}
}