import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This Selenium test will search for a timer in google and starts it. 
 * After the time has passed it will click the ok button to stop the ringing sound and the browser will be closed
*/
public class SettingTimerSelenium {
	public static void main(String[] args) throws InterruptedException {
		//Put the location of the firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		//Initiating your firefoxdriver
		WebDriver driver=new FirefoxDriver();

		//Perform test
		//maximize window
		driver.manage().window().maximize();
		//open browser with desried URL
		driver.get("https://www.google.com/");
		//Applied wait time
		Thread.sleep(1000);
		//Change google language to English
		try
		{ driver.findElement(By.linkText("English")).click(); }
		catch(NoSuchElementException ex)
		{ System.out.println("Language is already English"); }  


		//Identify search box
		WebElement searchTxtBox = driver.findElement(By.name("q"));
		//Will search for "5 seconds timer" and starts it
		searchTxtBox.sendKeys("5 sec timer" + Keys.RETURN);
		//((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1];", searchTxtBox,"5 sec timer");
		//Applied wait time
		Thread.sleep(1000);

		//Hit the search button
		//WebElement searchBtn = driver.findElement(By.name("btnK"));
		//searchBtn.submit();
		//Applied wait time
		Thread.sleep(1000);
		
		//RESET and START the timer
		driver.findElement(By.cssSelector("span.act-tim-btn-left:nth-child(2) > g-button:nth-child(2)")).click();
		driver.findElement(By.cssSelector("span.act-tim-btn-left:nth-child(2) > g-button:nth-child(1) > span:nth-child(2)")).click();
		
		//Wait for the timer to ring
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ok = driver.findElement(By.cssSelector("span.act-tim-btn-left:nth-child(2) > g-button:nth-child(1) > span:nth-child(3)"));
		wait.until(ExpectedConditions.visibilityOf(ok));
		//Wait for 1 sec to hear it ringing
		Thread.sleep(1000);
		
		//Click on OK to stop the ringing sound
		ok.click();
		//Applied wait time
		Thread.sleep(3000);

		//Close driver
		driver.close();
	}
}