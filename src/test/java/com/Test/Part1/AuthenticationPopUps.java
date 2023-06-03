package com.Test.Part1;

//Authentication popup are showing up, As proxy settings are established to the web application
//Authentication popup will ask username and password, that can be given using AutoIT and Sikuli but will accomplish using selenium webdriver very simply

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AuthenticationPopUps{
	WebDriver driver;
	@BeforeClass
	public void startBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void handleAuthenticationPopUp() {
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String expSuccessText = "Congratulations! You must have the proper credentials.";
		String successTextBasicAuth = driver.findElement(By.cssSelector("p")).getText();
		
		if(successTextBasicAuth.equals(expSuccessText)==true) {
			System.out.println("authetication is successful");
		}
		
	}

}
