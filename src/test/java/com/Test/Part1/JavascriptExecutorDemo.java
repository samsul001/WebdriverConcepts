package com.Test.Part1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class JavascriptExecutorDemo {
	WebDriver driver;
	JavascriptExecutorUtil obj = new JavascriptExecutorUtil();
	
	@BeforeClass
	public void startBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
		//driver.quit();
	}
	
	//@Test(priority = 1)
	public void flashAnElement() {
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement ele = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		obj.flash(ele, driver);
	}
	
	//@Test(priority = 2)
	public void DrawBorderAroundElement() throws InterruptedException, IOException {
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement ele = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		obj.drawAnBorder(ele, driver);
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("D:\\Screenshots\\capture.png");
		FileUtils.copyFile(source, target);
	}
	
	//@Test(priority = 3)
	public void getTitleOfPage() {
		driver.get("http://demo.automationtesting.in/Register.html");
		String title = obj.getTitleOfJS(driver);
		System.out.println(title);
	}
	
	//@Test(priority = 4)
	public void clickOnElementbyJS() {
		driver.get("https://www.twoplugs.com/");
		WebElement ele = driver.findElement(By.xpath("//ul[@class='control-bar']/li[1]/a/span[contains(text(),'LOG in')]"));
		obj.clickOnElementbyJS(ele, driver);
	}
	
	//@Test(priority = 5)
	public void generateAlertbyJS() {
		driver.get("https://www.twoplugs.com/");
		WebElement ele = driver.findElement(By.xpath("//ul[@class='control-bar']/li[1]/a/span[contains(text(),'LOG in')]"));
		obj.clickOnElementbyJS(ele, driver);
		obj.generateAlertbyJS(driver, "login button is clicked......");
	}
	
	//@Test(priority = 6)
	public void refreshingPagebyJS() throws InterruptedException {
		driver.get("https://www.twoplugs.com/");
		WebElement ele = driver.findElement(By.xpath("//ul[@class='control-bar']/li[1]/a/span[contains(text(),'LOG in')]"));
		obj.clickOnElementbyJS(ele, driver);
		Thread.sleep(6000);
		obj.refreshPagebyJS(driver);
	}
	
	//@Test(priority = 7)
	public void scrollTillElement() {
		driver.get("https://www.twoplugs.com/");
		WebElement nextButton = driver.findElement(By.xpath("//ul[@id='slider-comment']//following::a[text()='Next']"));
		obj.scrollTillWebElement(driver, nextButton);
	}
	
	@Test(priority = 8)
	public void scrollTillLastPage() {
		driver.get("https://www.twoplugs.com/");
		obj.scrollTillEndOfPage(driver);
	}
}
