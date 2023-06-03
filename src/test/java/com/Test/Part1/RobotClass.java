package com.Test.Part1;
//Why Robot class ?
//In certain Selenium Automation tests, There is a need to control mouse and keyboard to interact with OS windows like
// Download pop ups, Alert and Print PopUps
//Selenium WebDriver can not handle these OS pop-ups/applications.

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//Benifits of robot class
//Robot class can simulate keyboard and mouse events
//Robot class can help in download/upload of files in Selenium webdriver
//Robot class can easily integerate with automation framework(Keyword driven, data driven , hybrid driven)

public class RobotClass {
	WebDriver driver;
	//@Test
	public void downloadFile() throws AWTException, InterruptedException {		
		Robot robot = new Robot();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("	");
		driver.findElement(By.xpath("//h2[text()='File Download Demo for Automation']//following::a[1]")).click();
		driver.findElement(By.xpath("//button[@id='download']")).click();
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.setAutoDelay(3000);
		
		driver.quit();
	}
	
	//@Test
	public void uploadFile() throws AWTException {
		Robot robot = new Robot();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.cssSelector("input#imagesrc")).click();
		
		//Followin three lines are equals to "CTRL+C"
		robot.setAutoDelay(3000);
		StringSelection stringselection = new StringSelection("C:/Users/SaMsuL LiViC/Downloads/chrome-black-screen.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		
		//Following lines of code is for CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(3000);
		
		//following lines o code is for clicking Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(3000);
		
		
	}
	
	@Test
	public void uploadFile1() throws AWTException {
		Robot robot = new Robot();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='imagesrc']")).sendKeys("C://Users//SaMsuL LiViC//Downloads//chrome-black-screen");
		
		/*StringSelection stringselection = new StringSelection("C://Users/SaMsuL LiViC/Downloads/chrome-black-screen.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(3000);
		*/
		
		
	}

}
