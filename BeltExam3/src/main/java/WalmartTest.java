import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WalmartTest {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeSuite
	public void InitialiseDriver() throws InterruptedException {
		//----Setting up Firefox Driver and open Walmart----
		System.out.println("======Test has started. Opening driver======");
		String url = "https://walmart.com/";
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(500);
		wait = new WebDriverWait(driver, 10);
	}

	@Test (priority = 0)
	public  void addItemToCart() throws InterruptedException {
		//Search for ps5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-search-input"))).sendKeys("PlayStation5" + Keys.ENTER);
		checkSecurity();

		//Choose the first item and add it to cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='product-title-link line-clamp line-clamp-2 truncate-title']"))).click();
		checkSecurity();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add to cart']"))).click();
		checkSecurity();
		System.out.println("======Added an item to cart======");

		//Click on check out button and continue as a guest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Check out')]"))).click();
		checkSecurity();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='new-guest-continue-button']"))).click();
		checkSecurity();
		
		//Click on “Continue” to confirm arrival date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Continue to Delivery Address']"))).click();
		checkSecurity();

		/* Filling: "Delivery Information"
		 * Firstname: "Howard"
		 * Lastname: "Carrier"
 		 * Phone: 607-545-4214
		 * Email: "HowardSCarrier@jourrapide.com"
		 * Street Address: "1639 Frosty Lane"
		 * City: "Canaseraga"
		 * State: "NY"
		 * ZIP Code: 14822
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")))
		.sendKeys("Howard" 
				+ Keys.TAB + "Carrier" 
				+ Keys.TAB + "607-545-4214"
				+ Keys.TAB + "HowardSCarrier@jourrapide.com"
				+ Keys.TAB + "1639 Frosty Lane"
				+ Keys.TAB + Keys.TAB + "Canaseraga");
		new Select(driver.findElement(By.xpath("//select[@id='state']"))).selectByValue("NY");
		WebElement zipcode = driver.findElement(By.xpath("//input[@id='postalCode']"));
		zipcode.clear();
		zipcode.sendKeys("14822");
		driver.findElement(By.xpath("//input[@name='marketingEmailPref']")).click();
		//Click on "Continue" to proceed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Continue to Payment Options']"))).click();
		checkSecurity();

		//You may get asked to Confirm arrival date after address is entered. Click on "Continue"
		if (driver.findElements(By.xpath("//button[@aria-label='Continue to Delivery Address']")).size() > 0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Continue to Delivery Address']"))).click();
			checkSecurity();
		}

		//Click on "Continue with this address" to confirm delivery address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='address-validation-message-close-button']"))).click();
		checkSecurity();
	}

	@Test (priority = 1)
	public  void invalidCreditCard() throws InterruptedException {
		Reporter.log("======Trying Invalid Card Number======");
		//Enter Card number: 5286 3401 9865 785 (missing a number)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='creditCard']"))).sendKeys("528634019865785" + Keys.TAB);

		//Confirming the error message
		String expected = "Please enter a valid credit card number.";
		String actual = driver.findElement(By.xpath("//span[@data-automation-id='cardNumber-cc-error']")).getText();
		Assert.assertEquals(actual, expected);
	}

	@Test (priority = 2)
	public  void validCreditCard() throws InterruptedException {
		Reporter.log("======Trying Valid Card Number======");
		//Enter Card number:5286 3401 9865 7854 
		WebElement card = driver.findElement(By.xpath("//input[@id='creditCard']"));
		card.clear();
		card.sendKeys("5286340198657854");

		//Confirming that there's no error message
		String expected = "";
		String actual = driver.findElement(By.xpath("//span[@data-automation-id='cardNumber-cc-error']")).getText();
		Assert.assertEquals(actual, expected);

		//Add expiration date of credit card and cvv
		new Select(driver.findElement(By.xpath("//select[@id='month-chooser']"))).selectByValue("12");
		new Select(driver.findElement(By.xpath("//select[@id='year-chooser']"))).selectByValue("2025");
		driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("614");

		//Submit form
		driver.findElement(By.xpath("//button[@data-automation-id='save-cc']")).click();

		//Confirm place order button is visible
		expected = "Place order";
		actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='summary-place-holder']/span"))).getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void checkSecurity() throws InterruptedException {
		//Verification handler
		Thread.sleep(3000);
		//If asked for verification:
		if (driver.findElements(By.xpath("//div[@id='px-captcha']")).size() > 0) {
			//Switch to verification iframe by element
			driver.switchTo().frame(driver.findElement(By.cssSelector("div#px-captcha iframe:not([style*='display: none'])"))); 
			System.out.println("******We switch to verification iframe*******");
			//Locate button and press and hold for 10 seconds
			WebElement webelement = driver.findElement(By.xpath("//p"));
			System.out.println("Element text: " + webelement.getText());
			Actions action = new Actions(driver);
			action
			.clickAndHold(webelement)
			.pause(java.time.Duration.ofSeconds(10))
			.release()
			.build().perform();
			System.out.println("Released verification button");
			//Switch back to main website iframe and return to test
			driver.switchTo().defaultContent();
			System.out.println("******We switch back to main iframe*******");
			Thread.sleep(5000);
		}
	}

	@AfterSuite
	public void CloseDriver() throws InterruptedException {
		//Sleep for a while before closing the driver
		Thread.sleep(1000);
		//Closing the browser
		driver.quit();
		System.out.println("======Test is done. Closing driver======");
	}
}