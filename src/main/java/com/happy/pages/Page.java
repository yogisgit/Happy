package com.happy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//https://jqueryui.com/droppable/
public class Page {
WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email = By.xpath("//input[@type='email']");
	private By password = By.xpath("//input[@type='password']");
	private By submit = By.xpath("//input[@type='submit']");
	
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement submit() {
		return driver.findElement(submit);
	}
}
