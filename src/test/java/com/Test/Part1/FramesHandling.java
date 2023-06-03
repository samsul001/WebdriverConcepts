package com.Test.Part1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//IFrame-Inline frame, Iframe is a HTML Document embedded inside another HTML document on a websites
//IFrame HTML element is often used to insert content from another source, such as an advertisements into a webpage
//3 different ways to switch to a Frame => 1.Using name or id, 2.using index, 3.using webelement
//If user isnt switching to frames, they can access only parent window

//A frame is used to divide a page into multiple sections, with new content on each section.
//Frame is a HTML tag that is used to divide the web page into various frames/windows
//An iFrame is used to embedd the content of the external websites into the web page, in order to avoid cross-site scripting issues
//<iframe> is also a tag used in HTML but it specifies an inline frame which means 
//  it is used to embedd some other HTML document within the current HTML document.

//Commands to achive frame handling => driver.switchTo().frame() , driver,switchTo().defaultContent()

public class FramesHandling {
	WebDriver driver;
	@BeforeClass
	public void startBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

	//@Test
	public void framesHandlingWithIndex() throws InterruptedException {
		driver.get("file:///D:/workspace_selenium/frames.html");
		driver.manage().window().maximize();
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//input[contains(@id, 'Wikipedia1_wikipedia')]")).sendKeys("samsul");
		Thread.sleep(3000);
		//driver.switchTo().defaultContent();
		//driver.findElement(By.xpath("//a[text()='Click here for Selenium tutorial')]")).click();
	}
	
	//@Test
	public void framesWithinFrames() {
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
				
		Actions act = new Actions(driver);
		
		//WebElement framesOption = driver.findElement(By.xpath("//a[text()='Frames']"));
		//act.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).click().build().perform();
		//framesOption.click();*/
				
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Testing with FRAME1");
		
		driver.switchTo().defaultContent();		
		driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
		
		WebElement OuterFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(OuterFrame);
		
		int iframeCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total iframe count: "+iframeCount);
		
		
	}
	
	@Test
	public void framesHandlingWithIndex1() {
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		WebElement ele = driver.findElement(By.xpath("//span[contains(@tabindex,'0')]"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).clickAndHold(ele).moveByOffset(150, 0).build().perform();
		
	}

}
