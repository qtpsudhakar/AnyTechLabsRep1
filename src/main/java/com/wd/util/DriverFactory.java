package com.wd.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver getDriverFor(String brName) {
		
		switch (brName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--disable-notifications");
			return new ChromeDriver(co);
		case "ff":
			System.setProperty("webdriver.gecko.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\geckodriver.exe");
			
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions fo = new FirefoxOptions();
			fo.setProfile(fp);
			
			//open ff window
			return new FirefoxDriver(fo);
		case "ie":
			System.setProperty("webdriver.ie.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\IEDriverServer.exe");
			
			//open ie window
			return new InternetExplorerDriver();
		case "edge":
			System.setProperty("webdriver.edge.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\MicrosoftWebDriver.exe");
			
			//open edge window
			return new EdgeDriver();			

		default:
			System.out.println("Not a valid browser name");
			return null;
		}
		
	}
}
