package RetryFailedTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer{
	private int retryCnt = 1;
	private int maxRetryCnt = 2; //if any failed testcases, it'll be rerun once

	@Override
	public boolean retry(ITestResult result) {
		if(retryCnt <= maxRetryCnt) {
			//Rerun, and print the count number
			System.out.println("Retrying " + result.getName() + " again and the count is " + retryCnt);
			retryCnt++;
			return true;
		}
		//Don't rerun
		return false;
	}
	
}
