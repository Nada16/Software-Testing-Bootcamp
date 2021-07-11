import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BtnStatus {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String url = "https://stickynotesn.000webhostapp.com/";
		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//Open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Locate the button and print its status
		WebElement btn1 = driver.findElement(By.xpath("//button[@id='btnAddNote']"));
		if(btn1.isEnabled()) {
			System.out.println("The status of the first button is Enabled");
		}else {
			System.out.println("The status of the first button is disabled");
		}
		
		//Locate the button and print its status
		WebElement btn2 = driver.findElement(By.xpath("//button[@id='searchbtn']"));
		if(btn2.isEnabled()) {
			System.out.println("The status of the second button is Enabled");
		}else {
			System.out.println("The status of the second button is disabled");
		}

		//closing the browser
		driver.quit();
	}
}