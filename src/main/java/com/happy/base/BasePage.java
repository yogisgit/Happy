package com.happy.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		String path = System.getProperty("user.dir")+"/src/main/java/com/happy/config/L3.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		
		System.setProperty("webDriver.ChromeDriver", System.getProperty("user.dir")+"/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		return driver;
	}
	public String takeScreenshot(String testcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/reports/"+testcaseName+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
		 
	}
}
