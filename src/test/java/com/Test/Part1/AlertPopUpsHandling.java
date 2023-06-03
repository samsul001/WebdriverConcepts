package com.Test.Part1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Types of Alerts => 1. Alert with OK, 2. Alert with OK and cancel button, 3.Alert with Textbox and checkbox
//Command to work with Alert => driver.switchTo().alert()
//Alert boxes are window based application, So we cannot locate an element locator 
//accept() - will clicking up OK button and close the alert box
//dismiss() - will clicking up Cancel button and close the alert box
//sendKeys() - sending values to the textbox present in the alert box
public class AlertPopUpsHandling {

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
	
	@Test
	public void handlingAlertWithOKbutton() throws InterruptedException {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id='OKTab']/button")).click();
		System.out.println("Alert text => '"+driver.switchTo().alert().getText()+"'");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void handlingAlertWithOKandCancelButton() {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//div[@id='CancelTab']/button")).click();
		
		System.out.println("Alert text => '"+driver.switchTo().alert().getText()+"'");
		String expTextOK = "You pressed Ok";
		String actTextCancel = "You Pressed Cancel";
		driver.switchTo().alert().accept();
		String actText = driver.findElement(By.xpath("//p[contains(text(),'You pressed Ok')]")).getText();
		if(actText.equals(expTextOK)==true) {
			System.out.println("Alert prompt is accepted by clicking OK");
		}
		
		driver.findElement(By.xpath("//div[@id='CancelTab']/button")).click();
		
		System.out.println("Alert text => '"+driver.switchTo().alert().getText()+"'");
		driver.switchTo().alert().dismiss();
		actText = driver.findElement(By.xpath("//p[contains(text(),'You Pressed Cancel')]")).getText();
		if(actText.equals(actTextCancel)==true) {
			System.out.println("Alert prompt is cancelled by clicking cancel");
		}
		
	}
	
	@Test
	public void handlineAlertWithTextBox() {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//div[@id='Textbox']/button")).click();
		
		
		System.out.println("Alert text => '"+driver.switchTo().alert().getText()+"'");
		driver.switchTo().alert().sendKeys("test");
		driver.switchTo().alert().accept();
		String expText = "Hello test How are you today";
		String actText = driver.findElement(By.xpath("//div[@id='Textbox']/p")).getText();
		
		if(actText.equals(expText)==true) {
			System.out.println("Alert prompt text box was selected and entered value");
		}
	}
	
}
