import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StartsWithXpath {
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

		//Locate and scroll down to "learning about languages" sections
		WebElement langBtn = driver.findElement(By.xpath("//div[@class='upper_container']/button[2]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", langBtn);
		Thread.sleep(2000);

		//Change the language to MERN
		langBtn.click();
		Thread.sleep(2000);

		//Locate the map and scroll down to it
		WebElement map = driver.findElement(By.xpath("//img[starts-with(@src,'https://cdn2.codingdojo.com/new_design_image/home')]"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", map);
		Thread.sleep(2000);

		//Click on the "Learn About ..." button
		driver.findElement(By.xpath("//a[starts-with(@class, 'btn form-control about_btn')]")).click();
		Thread.sleep(2000);

		//Close the newly opened tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(2000);
		
		//Navigate to "learning about languages" sections and change the language to JAVA
		langBtn = driver.findElement(By.xpath("//div[@class='upper_container']/button[3]"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", langBtn);
		langBtn.click();
		Thread.sleep(2000);
		
		//Locate the map and scroll down to it
		map = driver.findElement(By.xpath("//img[starts-with(@src,'https://cdn2.codingdojo.com/new_design_image/home')]"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", map);
		Thread.sleep(2000);

		//Click on the "Learn About ..." button
		driver.findElement(By.xpath("//a[starts-with(@class, 'btn form-control about_btn')]")).click();
		Thread.sleep(5000);

		//closing the browser
		driver.quit();
	}
}