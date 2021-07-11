import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String url = "https://www.google.com/";
		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//Open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//Change google language to English
		try
		{ driver.findElement(By.linkText("English")).click(); }
		catch(NoSuchElementException ex)
		{ System.out.println("Language is already English"); } 

		//Identify search box and search for "Nada" using "RETURN"
		WebElement searchTxtBox = driver.findElement(By.name("q"));
		searchTxtBox.sendKeys("Nada");
		searchTxtBox.sendKeys(Keys.RETURN);
		//Applied wait time
		Thread.sleep(3000);

		searchTxtBox = driver.findElement(By.name("q"));
		//Search for "Nada Alnoory" using "ENTER"
		searchTxtBox.clear();
		searchTxtBox.sendKeys("Nada Alnoory");
		searchTxtBox.sendKeys(Keys.ENTER);
		//Applied wait time
		Thread.sleep(3000);

		//Close driver
		driver.close();
	}
}
