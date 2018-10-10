package com.wd.tng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.wd.util.DriverFactory;
import com.wd.util.WebUtil;

public class OhrmTests extends BaseTest {

	@Test
	public void login() {
		try {
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
			test.log(LogStatus.PASS, "EnterTextOnUserName", "Text entered on user name");
			driver.findElement(By.name("txtPassword")).sendKeys("qtpsudhakar");
			test.log(LogStatus.PASS, "EnterTextOnPassword", "Text entered on password");
			driver.findElement(By.id("btnLogin")).click();
			test.log(LogStatus.PASS, "ClickOnLoginButton", "clicked on login button");
		} catch (Exception e) {
			String errImgPath = WebUtil.captureScreen(driver);
			test.log(LogStatus.FAIL, "Login", "Failed To Login"+test.addScreenCapture(errImgPath));
			throw e;
		}
	}

	@Test(dependsOnMethods = "login")
	public void addEmployee() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("PIM"))).click();
			// driver.findElement(By.linkText("PIM")).click();

			driver.findElement(By.linkText("Add Employee")).click();

			driver.findElement(By.id("firstName")).sendKeys("selenium");

			//enterText(By.id("firstName"), "Selenium");
			
			driver.findElement(By.id("lastName")).sendKeys("hq");

			driver.findElement(By.xpath("//input[@class='select-dropdown' and  @value='-- Select --']")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[contains(normalize-space(),'Australian Regional HQ')]"))).click();
			// driver.findElement(By.xpath("//span[contains(normalize-space(),'Australian
			// Regional HQ')]")).click();

			driver.findElement(By.linkText("SAVE")).click();
		} catch (Exception e) {
			String errImgPath = WebUtil.captureScreen(driver);
			test.log(LogStatus.FAIL, "AddEmp", "Failed To Add Employee"+test.addScreenCapture(errImgPath));
			throw e;
		}
	}
	
	public void enterText(By locator,String txtToEnter) {
		try {
			String elmName = driver.findElement(locator).getAttribute("name");
			driver.findElement(locator).sendKeys(txtToEnter);
			String errImgPath = WebUtil.captureScreen(driver);
			test.log(LogStatus.PASS, "Enter "+txtToEnter+" on "+elmName+test.addScreenCapture(errImgPath));
		}catch(Exception e){
			String errImgPath = WebUtil.captureScreen(driver);
			test.log(LogStatus.FAIL, "Failed to Enter "+txtToEnter+" on "+locator.toString());

			throw e;
		}
	}
}
