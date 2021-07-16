import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop2 {
	public static void main(String[] args) throws InterruptedException {
		//Testing url
		String url = "https://demos.telerik.com/kendo-ui/dragdrop/index";
		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//Open browser with desired URL and maximise window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);

		//Element to be dragged
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		//Element to be dropped on
		WebElement drop = driver.findElement(By.xpath("//div[@id='droptarget']"));

		//Scroll down to the bottom of the page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView({block:'center'})", drop);

		//Create action object
		Actions action = new Actions(driver);
		//Perform the drag and drop
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);

		//Close driver
		driver.close();
	}
}
