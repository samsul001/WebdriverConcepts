//HEADLESS BROWSER IN SELENIUM WEBDRIVER
//Headless browser is a browser simulation program that does not have a user interface(UI less)
//Headless browser programs operate like any other browser, but do not display UI. Selenium executes it's test in backround
//Ex. of headless browsers => chrome, firefox, HtmlUnitDriver and PhantomJS
//HtmlUnitDrriver is a builtin headless browser in selenium webdriver , it is present in org.openqa.selenium.htmlunit package

//WHAT IS HEADLESS BROWSER TESTING?
//Executing webapplication UI tests without opening browsr's user interface is called headless browser testing.
//Headless browser operate like any other normal browser
//Testers have full control over the webpages loaded into the headless browsers, only difference is we do not see any GUI.

//WHEN TO GO FOR HEADLESS BROWSER TESTING ?
//We can use headless testing once cross browser testing is completed but want to run regression in subsequent releases and
//with contineous integeration
//We have no option other than using headless testing when our machine doest have GUI. For instance, if we want to run our tests
//in unix.
//It is recommended to use headless browsers when tests are execute in parallel as user interface  based browsers
//consume a lot of memory/resources
package com.Test.Part1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlessBrowser {
	WebDriver driver;
	//Chrome headless - Type 1
	@Test(priority = 1, description = "type1 - chrome healess")
	public void chromeHeadless() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.get("https://www.ebay.com");
		System.out.println("Title: "+driver.getTitle());
	}
	
	//Chrome headless - Type 2
	@Test(priority = 2, description = "type2 - chrome healess")
	public void chromHeadless1() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("https://www.ebay.com");
		System.out.println("Current URL: "+driver.getCurrentUrl());
	}
	
	//ff headless - Type 1
	@Test(priority = 3, description = "type1 - FF headless")
	public void fireFoxHeadless() {
		System.setProperty("webdriver.gecko.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		driver = new FirefoxDriver(options);
		driver.get("https://www.amazon.in");
		System.out.println("Title: "+driver.getTitle());
	}
	
	//ff headless - Type 2
	@Test(priority = 4, description = "type2 - FF headless")
	public void fireFoxHeadless1() {
		System.setProperty("webdriver.gecko.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		driver.get("https://www.amazon.in");
		System.out.println("CurrentURL: "+driver.getCurrentUrl());
	}
	
	@Test(priority = 5, description = "htmlunit browser")
	public void htmlUnitDriver() {
		HtmlUnitDriver hDriver = new HtmlUnitDriver();
		hDriver.get("https://www.ebay.com");
		System.out.println("Title: "+ hDriver.getTitle());
		System.out.println("CurrentURL: "+ hDriver.getCurrentUrl());
	}

}
