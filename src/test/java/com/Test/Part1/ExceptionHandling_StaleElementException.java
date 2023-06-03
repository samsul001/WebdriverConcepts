package com.Test.Part1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Stale means old, decayed or no longer available
//StaleElement means old element/no longer available element
//If an element is referenced as webelement in webdriver from a webpage which dom is changed for some reasons.
// Now webdriver cannot locate the element again as it becomes stale, So StaleElementRefrece exception is thrown.
//So the element reference should be refreshed or the element should be reidentified again.
//Reason for element become stale:- New Ajax calls refresh the DOM, So existing elements become stale.


public class ExceptionHandling_StaleElementException {
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
	
	@Test
	public void staleElement1() throws InterruptedException {
		driver.get("http://www.pavantestingtools.com/");
		WebElement downloadLink = driver.findElement(By.xpath("//a[text()='Downloads']"));
		WebElement resumeLink = driver.findElement(By.xpath("//a[text()='Downloads']//following::ul[1]/li[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(downloadLink).moveToElement(resumeLink).click().build().perform();
		
		driver.navigate().back();
		Thread.sleep(3000);
		try {
		act.moveToElement(downloadLink).moveToElement(resumeLink).click().build().perform();
		}catch(StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}
	}

}
