package com.Test.Part1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//Hierarchy of Selenium WebDriver Exception
//java.lang.Object -> 
	//java.lang.Throwable -> 
		//java.lang.Exception -> 
			//java.lang.RuntimeException -> 
				//org.openqa.selenium.WebDriverException
//Selenium Webriver Exception

//org.openqa.selenium.WebDriverException

//org.openqa.Selenium.NotFoundException
//WebDriverException
//NoSuchElementException => InvalidSelectorException
//NoSuchFrameException
//NoSuchWindowException
//NoAlertPresentException
//NoSuchContextException

//org.openqa.selenium.InvalidElementStateException
//ElementNotVisibleException

//org.openqa.selenium.InvalidArgumentException

//org.openqa.selenium.interactions.InvalidCoordinatesException

//org.openqa.selenium.interactions.MoveTargetOutOfBoundsException

//org.openqa.selenium.NoSuchSessionException

//org.openqa.selenium.ScriptTimeoutException

//org.openqa.selenium.TimeoutException

//org.openqa.selenium.StaleElementReferenceException


public class ExceptionHandlingNotFoundException {
	WebDriver driver;
	@BeforeClass
	public void startBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterClass
	public void teardOWN() {
		driver.quit();
	}
	
	//@Test
	public void WebDriverException() {
		//This takes place when the WebDriver is performing some actions right after the browser is closed
	}
	
	@Test(priority = 1)
	public void NoSuchElementException() {
		driver.get("https://www.google.com");
		try {
		driver.findElement(By.xpath("fake")).sendKeys("sbf");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("exception handling helps to print this line ");
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	@Test(priority = 2)
	public void NoSuchAlertPresentException() {
		try {
			driver.switchTo().alert().accept();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("exception handling helps to print this line ");
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	@Test(priority = 3)
	public void NoSuchFrameException() {
		try {
			driver.switchTo().frame("sams");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("exception handling helps to print this line ");
		System.out.println("------------------------------------------------------------------------------------");
	}

	
}
