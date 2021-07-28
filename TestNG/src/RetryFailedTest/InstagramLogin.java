package RetryFailedTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InstagramLogin {
	private WebDriver driver;

	@BeforeTest
	public void InitialiseDriver() throws InterruptedException {
		//----Setting up Firefox Driver and open Instagram----
		String url = "https://www.instagram.com/";
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test (retryAnalyzer = RetryFailedTestCases.class)
	public void checkLoginFail() throws InterruptedException {
		//Login using wrong credientails
		login("nada.alnoory@gmail.com", "CodingDojo1234");
		//Check that user is logged in 
		//Testcase would fail because login wasn't really successful (it'll retry)
		Assert.assertEquals(!driver.findElements(By.cssSelector("html.logged-in")).isEmpty(), true);
	}
	
	@Test (retryAnalyzer = RetryFailedTestCases.class)
	public void checkLoginSuccessful() throws InterruptedException {
		//Login using wrong credientails
		login("sample@email.com", "CodingDojo1234");
		//Check that user is not logged in 
		//Testcase would success (it won't retry)
		Assert.assertEquals(!driver.findElements(By.cssSelector("html.not-logged-in")).isEmpty(), true);
	}

	@AfterTest
	public void CloseDriver() {
		//closing the browser
		driver.quit();
	}

	public void login(String name, String pass) throws InterruptedException {
		//Fill out signing credentials 
		WebElement username = driver.findElement(By.cssSelector("input[aria-label*='username']"));
		username.clear();
		username.sendKeys(name);
		WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
		password.clear();
		password.sendKeys(pass);
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
	}
}
