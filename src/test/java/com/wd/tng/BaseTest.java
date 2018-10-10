package com.wd.tng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wd.util.DriverFactory;
import com.wd.util.WebUtil;

public class BaseTest {
	WebDriver driver;
	WebDriverWait wait;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeSuite
	public void initReport() {
		report = new ExtentReports("src\\..\\Reports\\OhrmReport"+WebUtil.getUniqID()+".html");
	}
	@BeforeClass
	@Parameters({"browser","aUrl"})
	public void openApplication(String brName,String appUrl) {
		
		test = report.startTest(this.getClass().getSimpleName());
		// open browser
		driver = DriverFactory.getDriverFor(brName);

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// navigate to url
		driver.get(appUrl);

		wait = new WebDriverWait(driver, 20);
		test.log(LogStatus.PASS, "OpenApplication", "Application Opened");
	}
	@AfterClass

	public void closeApplication() {
		driver.quit();
		test.log(LogStatus.PASS,"CloseApplication","Application Closed");
		report.endTest(test);

	}
	
	@AfterSuite
	public void closeReport() {
		report.close();		
	}
}
