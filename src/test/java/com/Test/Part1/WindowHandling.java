package com.Test.Part1;
//Window handling can be achieved by using commands driver.getWindowHandles , driver.switchTo().window("").getTitle();
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class WindowHandling {
	
	WebDriver driver;
	
	//@Test
	public void newTabbedWindows() {
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//button[contains(text(),'    click   ')]")).click();
		
		Set <String> windows= driver.getWindowHandles();
		//System.out.println(windows);
		
		for(String i:windows) {
			String t = driver.switchTo().window(i).getTitle();
			
			if(t.equals("Frames & windows")) {
				driver.close();
			}			
		}
		
	}
	
	@Test
	public void newSeparateWindow() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
		driver.findElement(By.xpath("//div[@id='Seperate']/button")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String i:windowHandles) {
			String t = driver.switchTo().window(i).getTitle();
			System.out.println(t);
			
			if(t.equals("Selenium")) {
				driver.close();
			}
		}
		
	}
	
	//@Test
	public void separateMultipleWindow() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//a[text()='Open Seperate Multiple Windows']")).click();
		driver.findElement(By.xpath("//div[@id='Multiple']/button")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String i:windowHandles) {
			String t = driver.switchTo().window(i).getTitle();
			System.out.println(t);
			
			/*if(t.equals("SeleniumHQ Browser Automation")) {
				driver.close();
			}*/
		}
	}

}
