package Appium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporter {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeSuite
	public void reportSetup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");

		//Create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);		
	}

	@AfterSuite
	public void reportTeardown() {
		//Calling flush writes everything to the log file
		extent.flush();
	}
}
