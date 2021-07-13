import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementsIterator {
	public static void main(String[] args) throws InterruptedException{
		//----Setting up Firefox Driver----
		String url = "https://www.codingdojo.com/";
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Get texts of all technologies covered by the Python course at coding dojo
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='technology_covered_content']/descendant::div/span"));
		
		//Print the technologies in console
		System.out.println("The Python course at Coding Dojo covers the following technologies:");
		int i = 1;
		for(WebElement element: elements) {
			System.out.println((i++) + ". " + element.getText());
		}
		
		Thread.sleep(2000);
		//closing the browser
		driver.quit();
	}
}