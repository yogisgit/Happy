package com.happy.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.happy.reports.ReportClass;

public class ListenerClass implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		System.out.println("Listener");
		ReportClass rc = new ReportClass();
		extent = rc.generateReport();
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "passed");
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		String methodName = result.getMethod().getMethodName();
		System.out.println("executing on test failure");
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		ScreenshotOnFail sof = new ScreenshotOnFail(driver);
		try {
			sof.takeScreenShot(methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
