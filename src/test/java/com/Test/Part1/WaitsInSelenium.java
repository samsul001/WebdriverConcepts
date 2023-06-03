package com.Test.Part1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

//The elements load time on web page may vary
//Not all the elements are loaded at the same time
//In applications developed by ajax, javascript etc., objects on webpage may load at different time
//To handle this, we can use waits in Selenium
//With help of Selenium waits, we can enable script to wait for some more time before throwing no such element exception

//Implicit wait is used to define a time period until when webdriver should wait before throwing no such element exception
//syntax => driver.manage().timeouts().implicitlyWait(TimeOut,TimeUnit.SECONDS);
//default frequency of polling for implicitit wait is 250 milli seconds	
//implicit wait is applicable for the entire session of browser

//Explicit wait is used to set for specific elements and specific condition should be defined
//Technically WebDriverWait is a class in Selenium API
// eg. wait until element is clickable
//Syntax: WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("abcd")));
//In order to declare explicit wait, one has to use “ExpectedConditions”. The following Expected Conditions can be used in Explicit Wait.
		/*
		alertIsPresent()
		elementSelectionStateToBe()
		elementToBeClickable()
		elementToBeSelected()
		frameToBeAvaliableAndSwitchToIt()
		invisibilityOfTheElementLocated()
		invisibilityOfElementWithText()
		presenceOfAllElementsLocatedBy()
		presenceOfElementLocated()
		textToBePresentInElement()
		textToBePresentInElementLocated()
		textToBePresentInElementValue()
		titleIs()
		titleContains()
		visibilityOf()
		visibilityOfAllElements()
		visibilityOfAllElementsLocatedBy()
		visibilityOfElementLocated()
		*/

//Fulent wait is a class in Selenium API, it implements methods from Wait interface
//Fluent wait is used to set For specific element.
//It can also used to set maximum wait time period, polling frequency, to ingnore specific exceptions
// Syntax:- 
//Wait wait = new FluentWait(driver).withTimeOut(10,SECONDS).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);

public class WaitsInSelenium {
	WebDriver driver;

	//@Test
	public void implicitWait() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implementing implicit wait for entire session

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Strp by Step Automation");
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]")).sendKeys(Keys.RETURN);

		driver.findElement(By.xpath("abcg")).click(); //WebDriver will wait till 10 seconds before throwing exceptiom
	}

	//@Test
	public void explicitWait() {
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Strp by Step Automation");
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]")).sendKeys(Keys.RETURN);
		//WebDriver wait object is created to implement explicit wait for a particular element
		//The element should wait for 20 seconds before throwing timout exception
		//Expected condition shoul be defined while implementing explicit wait for an element
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("abcfsd")));
		ele.click();
	}

	//@Test
	public void fluentWait() {
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]")).sendKeys(Keys.RETURN);
		//User navigates to second page of google and click an element
		//Now we are going to do with manual intervention but webdriver wont throw exception as Fluent wait


		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(5, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkEle = driver.findElement(By.xpath("//h3[contains(text(),'ABCD (Diabetes Care) Ltd')]"));

				if(linkEle.isEnabled()==true) {
					System.out.println("element found");
				}
				return linkEle;
			}
		});
		element.click();			

	}

	//@Test
	public void fluentWait1() {
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]")).sendKeys(Keys.RETURN);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		  WebElement linkElement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	WebElement actLinkEle =  driver.findElement(By.xpath("//h3[contains(text(),'ABCD (1999) - IMDb')]"));
			       if(actLinkEle.isEnabled()) {
			    	   System.out.println("Element found");
			       }
			       return actLinkEle;
			     }
			   });
		  linkElement.click();
		
	}
	
	//@Test
	public void fluentWait2() {
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]")).sendKeys(Keys.RETURN);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(5,TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement abcdLinkElement = wait.until(new Function<WebDriver,WebElement>(){

			public WebElement apply(WebDriver driver) {
				
				WebElement eleLink = driver.findElement(By.xpath("//h3[contains(text(),'ABCD - Urban Dictionary')]"));
				if(eleLink.isEnabled()) {
					System.out.println("element found");
				}
				return eleLink;
			}			
		});
		abcdLinkElement.click();
		
	}
	
	@Test
	public void fluentWait3() {
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[1]")).sendKeys(Keys.RETURN);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(15,TimeUnit.SECONDS)
				.pollingEvery(3,TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement linkEle = wait.until(new Function<WebDriver, WebElement>(){

			public WebElement apply(WebDriver input) {
				WebElement link = driver.findElement(By.xpath("//h3[contains(text(),'ABCD Study')]"));
				if(link.isEnabled()) {
					System.out.println("Element found");
				}
				return link;
			}			
		});
		linkEle.click();
	}


}
