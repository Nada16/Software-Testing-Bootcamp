import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HoldingKeys {
	public static void main(String[] args) throws InterruptedException{
		//----Setting up Firefox Driver----
		String url = "https://www.codingdojo.com/";
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Initialise important variables
		Actions act = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//Locate alumni button and click on it
		WebElement btn = driver.findElement(By.xpath("//div[@class='nav_container']/button[1]"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'})", btn);
		Thread.sleep(2000);
		btn.click();
		Thread.sleep(1000);
		
		//Locate name of alumni and copy it
		WebElement name = driver.findElement(By.cssSelector("div.alumni_info h6:first-child"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'})", name);
		act.moveToElement(name).doubleClick()
		//Highlight first name
		.keyDown(Keys.SHIFT).sendKeys(Keys.UP).keyUp(Keys.SHIFT)
		//Copy highlighted text
		.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)
		.build().perform();
		Thread.sleep(1000);
		
		//Locate name text box and paste alumni's name
		WebElement nameBox = driver.findElement(By.cssSelector("div.right_section input.packet_name"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'})", nameBox);
		Thread.sleep(1000);
		act.moveToElement(nameBox).click().keyDown(nameBox, Keys.CONTROL).sendKeys("v").keyUp(nameBox, Keys.CONTROL).build().perform();
		Thread.sleep(5000);

		//closing the browser
		driver.quit();
	}
}