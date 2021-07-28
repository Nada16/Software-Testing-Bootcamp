package TestNGListenerDemo;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// When Test case get Started, this method is called.
		System.out.println(result.getName() + " test case started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// When Test case get passed, this method is called.
		System.out.println("The name of the testcase passed is :" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// When Test case get failed, this method is called. 
		System.out.println("The name of the testcase failed is :" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// When Test case get Skipped, this method is called.
		System.out.println("The name of the testcase Skipped is :" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}
	
}
