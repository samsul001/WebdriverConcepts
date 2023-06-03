package com.Test.Part1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//JavaScriptExecutor is an interface that provides mechanisms to execute javascript through selenium webdriver

//Actions we can perform using JavaScript Executor:
//1. Flashing an element => "arguments[0].style.backgroundColor = 'color'"
//2. Drawing a border around the element =>  "arguments[0].style.border='3px solid red'"
//3. Capture title of the page => "return document.title;"
//4. Click on some element => "arguments[0].click();"
//5. Generate alert info => "alert('messgae')"
//6. Refereshing page => "history.go(0)"
//7. Scrolling page => 
//		1. Scrolling till in an element => "arguments[0].scrollIntoView(true);"
//		2. Scroll till last page => "window.scrollTo(0,document.body.scrollHeight)"

public class JavascriptExecutorUtil {

	//Flash an Element
	public void flash(WebElement element, WebDriver driver) {		
		String bgColor = element.getCssValue("backgroundColor");
		for(int i=0;i<50;i++) {
			changeColor("#000000", element, driver);
			changeColor(bgColor, element, driver);
		}
	}
	
	public void changeColor(String color,WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver); 
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			
		}
	}
	
	//Draw a border around element
	public void drawAnBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}
	
	//Capture title of a page
	public String getTitleOfJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title").toString();
		return title;
	}
	
	//Click on some eelement
	public void clickOnElementbyJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	//generate Alert for element
	public void generateAlertbyJS(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+ message + "')" );
	}
	
	//refreshing webpage
	public void refreshPagebyJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	
	//Scrolling till webelement
	public void scrollTillWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//Scrilling till last page
	public void scrollTillEndOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
}
