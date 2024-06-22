package com.abby.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.abby.qa.utils.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//import com.abby.qa.utils.ExtentReporter;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;

	ExtentTest extentTest;
	String testName;

	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReporter();

	}

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
//		extentReport.createTest(testName);
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + "started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.INFO, testName + "Got Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationSSPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
		try {
			FileHandler.copy(srcScreenshot, new File(destinationSSPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extentTest.addScreenCaptureFromPath(destinationSSPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "Got Failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + "Got Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\extentReports\\extentReports.html";
		File extendReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extendReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
