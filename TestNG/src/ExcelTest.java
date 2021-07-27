import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class ExcelTest {
	private String testcaseID;
	WebDriver driver;

	@BeforeMethod
	public void InitialiseBrowser() throws Exception {
		//Initialise driver
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		//Switch Google language to English
		try { 
			driver.findElement(By.linkText("English")).click(); 
		} catch(NoSuchElementException ex) { 
			System.out.println("Language is already English"); 
		} 
		Thread.sleep(1000);
	} 

	@Test(dataProvider = "searchValues")
	//Read testcases values using Data Provider
	public void testSearch(String[] testcaseValues) throws InterruptedException {
		Reporter.log("Values to be searched for: ");
		//Use testcases values to search in google
		for(int i = 0; i < testcaseValues.length; i++) {
			//Clear search box every time so that it dose not concatenate strings
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.clear();

			searchBox.sendKeys(testcaseValues[i] + Keys.ENTER);
			Reporter.log(testcaseValues[i]);
			Thread.sleep(2000);
		}
	}

	@AfterMethod
	public void CloseDriver() {
		driver.close();
	}

	@DataProvider
	public String[][] searchValues() throws Exception{
		// Setting up the Test Data Sheet
		ImportingExcel.setExcelFile(System.getProperty("user.dir") + "\\resources\\dataprovider.xlsx","Sheet1");

		//Get number of testCases
		int testcasesNum =  ImportingExcel.getRowsNum();
		System.out.println("Number of test cases: " + testcasesNum);

		// Fetching test cases row by row and store them in the data array and return it
		String[][] data = new String[testcasesNum][];
		for(int i = 0, j = i+1; i < testcasesNum; i++, j++) {
			testcaseID = "test" + (j);
			System.out.println("Retrieving data for " + testcaseID);
			data[i] = ImportingExcel.getTestCaseValues(System.getProperty("user.dir") + "\\resources\\dataprovider.xlsx","Sheet1",j);
		}
		return (data);
	}
}
