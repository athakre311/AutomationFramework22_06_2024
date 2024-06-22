package com.abby.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReporter() {
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir") +"\\test-output\\extentReports\\extentReports.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Test Automation Result");
		sparkReporter.config().setDocumentTitle("TN Automation Report"); 
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);

		Properties configProp = new Properties(); 
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\abby\\qa\\config\\config.properties");
		
		try {
		FileInputStream fisConfigProp = new FileInputStream(configPropFile);	
		configProp.load(fisConfigProp);	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReport.setSystemInfo("Valid Email", configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Valid Password", configProp.getProperty("validPassword"));
		
		extentReport.setSystemInfo("OS",System.getProperty("os.name"));
		extentReport.setSystemInfo("user name",System.getProperty("user.name"));
		extentReport.setSystemInfo("java version",System.getProperty("java.vm.version"));
		return extentReport;


		
	}

}
