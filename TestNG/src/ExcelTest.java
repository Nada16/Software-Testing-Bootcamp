import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class ExcelTest {
	private String sTestCaseName;
	private int iTestCaseRow;
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\selenium\\chromedriver.exe");		
		driver=new ChromeDriver();
		driver.get("http://www.qaautomated.com");
		Thread.sleep(5000);
	} 

	@Test(dataProvider = "search")
	public void test(String searchtext) throws Exception {
		driver.findElement(By.xpath("*//input[@class='search-field']")).sendKeys(searchtext);
		driver.findElement(By.xpath("*//input[@class='search-submit']")).click();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@DataProvider
	public Object[][] search() throws Exception{
		// Setting up the Test Data Excel file
		ImportingExcel.setExcelFile("C:\\Users\\nal-n\\Desktop\\Projects\\Applications and Websites\\Software-Testing-Bootcamp\\TestNG\\resources\\dataprovider.xlsx","Sheet1");
		sTestCaseName = this.toString();

		// From above method we get long test case name including package and class name etc.
		// The below method will refine your test case name, exactly the name use have used
		sTestCaseName = ImportingExcel.getTestCaseName(this.toString());

		// Fetching the Test Case row number from the Test Data Sheet
		// Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
		iTestCaseRow = ImportingExcel.getRowContains(sTestCaseName,0);

		Object[][] testObjArray = ImportingExcel.getTableArray("C:\\Users\\nal-n\\Desktop\\Projects\\Applications and Websites\\Software-Testing-Bootcamp\\TestNG\\resources\\dataprovider.xlsx","Sheet1",iTestCaseRow);

		return (testObjArray);
	}
}
