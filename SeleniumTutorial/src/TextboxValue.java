import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextboxValue {
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

		//Locate the textBox and print its value
		String txtValue = driver.findElement(By.xpath("//input[@id='txtDescription']")).getAttribute("value");;
		Thread.sleep(1000);
		System.out.println("The value attribute of the textbox is: " + txtValue);
		Thread.sleep(2000);

		//closing the browser
		driver.quit();
	}
}