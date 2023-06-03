package com.Test.Part1;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EncodingPasswordsInSelenium {
	WebDriver driver;
	@Test
	public void encodeDecodeValues() {
		String str = "admin123";
		
		//encoding using Base64.encodeBase64() command
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		System.out.println("encoded String: "+new String(encodedString));
		
		//decoding using Base64.decodeBase64() command
		byte[] decodedString = Base64.decodeBase64(encodedString);
		System.out.println("decoded String: "+new String(decodedString));
	}
	
	//@Test
	public void passwordEncoding() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(decodingPassword("YWRtaW4xMjM"));
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		WebElement actEle = driver.findElement(By.xpath("//div[@id='branding']//child::img[@alt='OrangeHRM']"));
		if(actEle.isDisplayed()==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		driver.close();
		driver.quit();
	}
	
	public String decodingPassword(String password) {
		byte[] decodedString = Base64.decodeBase64(password);
		return(new String(decodedString));
	}
}
