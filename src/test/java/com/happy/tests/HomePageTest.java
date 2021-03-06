package com.happy.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.happy.base.BasePage;
import com.happy.pages.Page;
import com.happy.util.ExcelUtility;

public class HomePageTest extends BasePage{
	WebDriver driver;
	Logger log = Logger.getLogger(HomePageTest.class);
	@BeforeTest()
	public void setUp() throws IOException {
		driver = initializeDriver();
		log.info("Open browserstack");
	}
	
	@Test(dataProvider="getData")
	public void login(String email, int pass) throws IOException {
		String pwd = String.valueOf(pass);
		Page p = new Page(driver);
		p.email().sendKeys(email);
		log.info("enter username");
		p.password().sendKeys(pwd);
		log.info("enter username");
		p.submit().click();
		log.info("click on login");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		ExcelUtility eu = new ExcelUtility();
		Object[][] obj = eu.getData();
		return obj;
	}
	
	@AfterTest()
	public void teardown() {
		driver.quit();
	}
}
