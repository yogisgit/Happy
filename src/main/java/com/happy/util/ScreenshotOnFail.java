package com.happy.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotOnFail {
	WebDriver driver;
	
	public ScreenshotOnFail(WebDriver driver) {
		this.driver = driver;
	}
	
	public void takeScreenShot(String methodName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/reports/"+ methodName +".png";
		FileUtils.copyFile(src, new File(path));
	}
}
