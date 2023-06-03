package com.Test.Part1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalanderPicker {
	WebDriver driver;
	@BeforeMethod
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.timeanddate.com/date/duration.html");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
	}
	@Test
	public void calanderCountDays() {		
		
		driver.findElement(By.xpath("//h2[contains(text(),'Start Date')]//following::div[1]/div[4]/button")).click();
				
		for(int i=1;i<6;i++) {
			driver.findElement(By.xpath("//a[@onclick='Picker.stepMonth(1);']")).click();			
			String monthText = driver.findElement(By.xpath("//a[@class='picked-month']")).getText();
			
			if(monthText.equals("December")) {
				driver.findElement(By.xpath("//a[text()='19']")).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//h2[text()='End Date']//following::div[1]/div[4]/button")).click();
		
		for(int i=1;i<=9;i++) {
			driver.findElement(By.xpath("//a[@onclick='Picker.stepMonth(1);']")).click();
			
			String monthText1 = driver.findElement(By.xpath("//a[@class='picked-month']")).getText();
			
			if(monthText1.equals("September")) {
				driver.findElement(By.xpath("//a[text()='19']")).click();
			}
			
		}
		driver.findElement(By.xpath("//input[@id='subbut2']")).click();
		
		String resultText = driver.findElement(By.xpath("//h2[contains(text(),'Result:')]")).getText();
		System.out.println("Total number of days between selected dates{ "+resultText+" }");
		driver.quit();
	}

}
