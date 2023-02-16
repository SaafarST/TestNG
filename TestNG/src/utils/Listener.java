package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed " + result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed " + result.getTestName());
    }
}
