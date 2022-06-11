package com.happy.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.happy.base.BasePage;
import com.happy.pages.Page;
import com.happy.util.ExcelUtility;

public class HomePageTest extends BasePage{
	WebDriver driver;
	@BeforeTest()
	public void setUp() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void login(String email, int pass) {
		String pwd = String.valueOf(pass);
		Page p = new Page(driver);
		p.email().sendKeys(email);
		p.password().sendKeys(pwd);
		p.submit().click();
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
