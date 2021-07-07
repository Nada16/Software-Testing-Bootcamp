import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicXpath {
	public static void main(String[] args) throws InterruptedException {
		//Set up testing url
		//String googleUrl = "https://www.google.com/preferences?hl=en&prev=https://www.google.com/search?q%3Dcoding%2Bdojo%26safe%3Dstrict%26authuser%3D0%26sxsrf%3DALeKk03WGWOqVDoSm37b_ZDvdEqezYkXrw:1625124409330%26source%3Dhp%26ei%3DOW7dYLbiEYmua9nMuvAI%26iflsig%3DAINFCbYAAAAAYN18ST_Y3fJlEG-IK2CiOP1ZQ0wf0E9k%26oq%3D%26gs_lcp%3DCgdnd3Mtd2l6EAEYADIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJ1AAWABgjjhoAXAAeACAAQCIAQCSAQCYAQCqAQdnd3Mtd2l6sAEK%26sclient%3Dgws-wiz&sa=X&ved=2ahUKEwj_kdWcrMHxAhUrBGMBHUxWCeIQo_oBKAF6BAgBEBI";
		String codingdojoUrl = "https://www.codingdojo.com/";

		//----Setting up Firefox Driver----
		//Put the location of the firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		//Initiating your firefoxdriver
		WebDriver driver=new FirefoxDriver();

		//Perform test
		//open browser with desried URL
		driver.get(codingdojoUrl);
		//maximize window
		driver.manage().window().maximize();
		//Applied wait time
		Thread.sleep(2000);

		//Click on 'Our Team'
		driver.findElement(By.xpath("//a[contains(text(),'Our Team')]")).click();
		//Applied wait time
		Thread.sleep(2000);

		//Declare Javascript executor from the driver
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Locate Jim and scroll down to his info
		WebElement jim = driver.findElement(By.xpath("//div[@class='team_img_container jim_dutkiewycz']"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", jim);
		//Apply wait time
		Thread.sleep(3000);

		//Locate Rinu and scroll down to his info
		WebElement rinu = driver.findElement(By.xpath("//div[@class='team_img_container rinu_rajan']"));
		jse.executeScript("arguments[0].scrollIntoView({block:'center'});", rinu);
		//Apply wait time
		Thread.sleep(3000);

		//closing the browser
		driver.quit();
	}
}