package com.Test.Part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownSelect {
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	//@Test
	public void dropDownSelectEbay() {
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		Select dd = new Select(driver.findElement(By.xpath("//select[@id='gh-cat']")));
		dd.selectByVisibleText("Cameras & Photo");
		
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		
		String text =driver.findElement(By.xpath("//div[@id='s0-15-6-0-1[0]-0-12']//following::span[contains(text(),'Cameras & Photo')]")).getText();
		Assert.assertEquals(text, "Cameras & Photo");
	}
	
	//@Test
	public void dropDownSelectAmazon() {
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Select ddAmazon = new Select(driver.findElement(By.xpath("//select[contains(@name,'url')]")));
		ddAmazon.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		String actualTextOfDealss = driver.findElement(By.xpath("//div[@class='a-box-inner']//child::span[contains(text(),'Deals')]")).getText();
		Assert.assertEquals(actualTextOfDealss, "Deals");
				
	}
	
	@Test
	public void sortedOrderInDropdown() {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Select dropDownValues = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		
		List<WebElement> dropDownOptions = dropDownValues.getOptions();
		List originalList = new ArrayList();
		List tempList = new ArrayList();
		
		for(WebElement e:dropDownOptions) {
			
			originalList.add(e.getText());
			tempList.add(e.getText());
			
		}
		
		System.out.println("before sorting originalList: "+originalList);
		System.out.println("before sorting TempList: "+tempList);
		
		Collections.sort(tempList);
		
		System.out.println("after sorting originalList: "+originalList);
		System.out.println("after sorting TempList: "+tempList);
		
		if(originalList==tempList) {
			System.out.println("Drop down sorted");
		}
		else {
			System.out.println("Drop own not sorted");
		}
		
		
	}

}
