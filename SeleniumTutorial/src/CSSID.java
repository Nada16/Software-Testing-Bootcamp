import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CSSID {
	public static void main(String[] args) throws InterruptedException{
		//Set up testing url
		String url = "https://www.facebook.com/";

		//----Setting up Firefox Driver----
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		//open browser with desried URL and maximize window
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//Change language to English
		driver.findElement(By.cssSelector("a._sv4[title='English (US)']")).click();
		//Create a new account
		driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
		Thread.sleep(1000);
		//Fill information
		driver.findElement(By.cssSelector("input.inputtext._58mg._5dba._2ph-[name='firstname']")).sendKeys("Nada");
		driver.findElement(By.cssSelector("input.inputtext._58mg._5dba._2ph-[name='lastname']")).sendKeys("Alnoory");
		driver.findElement(By.cssSelector("input.inputtext._58mg._5dba._2ph-[name='reg_email__']")).sendKeys("email@hotmail.com");
		driver.findElement(By.cssSelector("input.inputtext._58mg._5dba._2ph-[name='reg_email_confirmation__']")).sendKeys("email@hotmail.com");
		driver.findElement(By.cssSelector("input.inputtext._58mg._5dba._2ph-[name='reg_passwd__']")).sendKeys("CodingDojo1234");
		new Select(driver.findElement(By.cssSelector("select._9407._5dba._9hk6._8esg[title='Month']"))).selectByVisibleText("Oct");
		new Select(driver.findElement(By.cssSelector("select._9407._5dba._9hk6._8esg[title='Day']"))).selectByVisibleText("19");
		new Select(driver.findElement(By.cssSelector("select._9407._5dba._9hk6._8esg[title='Year']"))).selectByVisibleText("1995");
		driver.findElement(By.cssSelector("input._8esa[value='1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button._6j.mvm._6wk._6wl._58mi._3ma._6o._6v[name='websubmit']")).click();
		Thread.sleep(4000);

		//closing the browser
		driver.quit();
	}
}