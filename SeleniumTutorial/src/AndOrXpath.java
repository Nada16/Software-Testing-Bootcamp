import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AndOrXpath {
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

		//Click on "Apply" bottun
		driver.findElements(By.xpath("//a[@class='cta_blue_btn apply_btn_nav' and contains(text(),'Apply')]")).get(1).click();
		Thread.sleep(7000);
		
		//Close the new opened tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(2000);
		
		//Locate email txt box and scroll down to it an fill it
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement email = driver.findElement(By.xpath("//input[@type='email' and @name='email_address']"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", email);
		email.sendKeys("n.al-noory@hotmail.com");
		Thread.sleep(2000);

		//Click on the "English" button but after that do nothing
		driver.findElement(By.xpath("//a[@id='localize-active-lang' or contains(text(),'English')]")).click();
		Thread.sleep(3000);
		
		//closing the browser
		driver.quit();
	}
}