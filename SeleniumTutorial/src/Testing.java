import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
	public static void main(String[] args) throws InterruptedException {
		//Set up testing url
		//String googleUrl = "https://www.google.com/preferences?hl=en&prev=https://www.google.com/search?q%3Dcoding%2Bdojo%26safe%3Dstrict%26authuser%3D0%26sxsrf%3DALeKk03WGWOqVDoSm37b_ZDvdEqezYkXrw:1625124409330%26source%3Dhp%26ei%3DOW7dYLbiEYmua9nMuvAI%26iflsig%3DAINFCbYAAAAAYN18ST_Y3fJlEG-IK2CiOP1ZQ0wf0E9k%26oq%3D%26gs_lcp%3DCgdnd3Mtd2l6EAEYADIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJ1AAWABgjjhoAXAAeACAAQCIAQCSAQCYAQCqAQdnd3Mtd2l6sAEK%26sclient%3Dgws-wiz&sa=X&ved=2ahUKEwj_kdWcrMHxAhUrBGMBHUxWCeIQo_oBKAF6BAgBEBI";
		String codingdojoUrl = "https://www.codingdojo.com/";

		//----Setting up Chrome Driver----
		//Put the location of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");
		//Initiating your chromedriver
		WebDriver chdriver=new ChromeDriver();

		//Perform test
		//open browser with desried URL
		chdriver.get(codingdojoUrl);
		//maximize window
		chdriver.manage().window().maximize();
		//Applied wait time
		Thread.sleep(2000);

		chdriver.findElement(By.xpath("//a[@class='side_details left']")).click();

		//chdriver.findElements(By.xpath("//a[contains(text(),'Learning Science')]")).get(1).click();
		ArrayList<String> tabs2 = new ArrayList<String> (chdriver.getWindowHandles());
		chdriver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);

		chdriver.findElement(By.xpath("//a[@id='splash_cta']")).click();


		//		WebElement element = chdriver.findElement(By.className("jfk-checkbox-checkmark"));
		//
		//		WebDriverWait wait = new WebDriverWait(chdriver, 10);
		//		wait.until(ExpectedConditions.visibilityOf(element));
		//		element.click();

		//Applied wait time
		Thread.sleep(5000);

		//closing the browser
		chdriver.quit();
	}
}
