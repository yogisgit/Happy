package com.happy.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
}
