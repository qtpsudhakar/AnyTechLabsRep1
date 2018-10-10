package com.wd.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebUtil {

	public static boolean isElementExist(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException n) {
			return false;
		}
	}
	
	public static String captureScreen(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File fl = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("C:\\Users\\envy\\Desktop\\Aug22Space\\Project1\\Reports\\ErrImg\\Demo"+getUniqID()+".png");
		
		try {
			FileUtils.copyFile(fl, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dst.getAbsolutePath();
	}
	public static String getUniqID() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		return sd.format(new Date());
	}
}
