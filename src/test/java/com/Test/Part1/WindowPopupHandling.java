package com.Test.Part1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
//Four types of popups we generally receiving
//1.Alerts -- Javascript popup -- Alert API (accept, dismiss)
//2.File upload popup -- Browser button (type = file, sendkeys(path))
//3.Browser window popups -- Advertisement popups (Windowhandler API, getWindowHandles)
//  Browser windows can be handled with help of commands driver.getWindowHandles(), driver.switchTo().window(i).getTitle()

public class WindowPopupHandling {
	
	WebDriver driver;
	@Test
	public void handleWindowPopUp() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.findElement(By.xpath("//a[text()='  Follow On Twitter ']")).click();
		
		Set<String> windowHandler = driver.getWindowHandles();
		
		//System.out.println(windowHandler.size()); - 2
		//System.out.println(windowHandler);
		
		//Browser window popup can not be handled with for loop, So Iterator class is implemented
	
		Iterator<String> it = windowHandler.iterator();
		
		String parentWindowID = it.next();
		System.out.println("parent window id is: "+parentWindowID);
		
		String childWindowID = it.next();
		System.out.println("child window id is: "+childWindowID);
		
		driver.switchTo().window(childWindowID);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("child window title is: "+driver.getCurrentUrl());
		
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println("parent winow title is: "+driver.getTitle());
		
	}

}
