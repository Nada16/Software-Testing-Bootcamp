import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {
	public static void main(String[] args) throws InterruptedException {
		//----Setting up Firefox Driver----
		//Set up testing url
		String url = "https://www.saudia.com/";
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Wait for the Cookies notice
		WebElement cookie = driver.findElement(By.xpath("//form[@method='post']/descendant::button[@id='travelContinue']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cookie));
		//Accept cookies
		cookie.click();
		Thread.sleep(1000);

		//Click on Departure
		driver.findElement(By.xpath("//div[@id='ui-date-outbound--button']")).click();
		Thread.sleep(2000);
		
		//Get date elements
		List<WebElement> dates = driver.findElements(By.cssSelector("div.fg-5 td:not([class*='disabled']) a"));
		
		//Get today's date
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);

		//Get element with same date as today
		for(WebElement date: dates) {
			if(date.getText().equals(String.valueOf(day))) {
				date.click();
				break;
			}
		}
		Thread.sleep(2000);

		//Click on return
		driver.findElement(By.xpath("//div[@id='ui-date-inbound--button']")).click();
		Thread.sleep(2000);
		
		//Get date elements
		dates = driver.findElements(By.cssSelector("div.fg-5 td:not([class*='disabled']) a"));
		
		//Get element with same date as return date (today + 5days)
		for(WebElement date: dates) {
			if(date.getText().equals(String.valueOf(day+5))) {
				date.click();
				break;
			}
		}
		Thread.sleep(2000);

		driver.close();

	}
}