import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CSSDynamicValues {
	public static void main(String[] args) throws InterruptedException{
		//Set up testing url
		String url = "https://www.codingdojo.com/";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Scroll to Master Course Packet section
		WebElement container = driver.findElement(By.cssSelector("div[id='course_packet_section']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", container);
		//Fill out required information
		driver.findElement(By.cssSelector("div.right_section form input[name^='full']:not([type='hidden'])")).sendKeys("Nada Alnoory");
		driver.findElement(By.cssSelector("div.right_section input[placeholder^='Email']")).sendKeys("email@gmail.com");
		driver.findElement(By.cssSelector("div.right_section div.iti__flag-container")).click();
		driver.findElement(By.cssSelector("div.right_section li[data-country-code='sa']")).click();
		driver.findElement(By.cssSelector("div.right_section input.packet_phone")).sendKeys("123456789");
		Thread.sleep(1000);
		new Select(driver.findElement(By.cssSelector("div.right_section select[title='Choose Location']"))).selectByVisibleText("Online");
		
		//Press submit button
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.right_section input#course_packet_btn")).click();
		Thread.sleep(5000);

		//closing the browser
		driver.quit();
	}
}