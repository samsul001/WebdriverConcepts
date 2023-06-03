package com.Test.Part1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Cookies are temporary files created by browser/client side. 

//Cookie is a predefined class in Selenium webdriver

//Selenium commands for cookies
//driver.manage().getCookies(); --> Return all list of cookies
//driver.manage().getCookieNamed(arg0); --> Return specific cookie named
//driver.manage().addCookie(arg0) --> Create and add the cookie
//driver.manage().deleteCookie(arg0) --> Delete specific cookie
//driver.manage().deleteCookieNamed(arg0) --> Delete specific cookie accoring to name
//driver.manage().deleteAllCookies() --> Delete all cookies

public class CookiesHandling {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void cookiesHandling() {
		
		//1. to return all cookies
		Set<Cookie> cookies = driver.manage().getCookies();		
		System.out.println("Size of cookies: "+cookies.size()); //return size of the cookies
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie);
		}
		
		System.out.println("................................................................");
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		
		System.out.println("===============================================================");
		
		//2. to return specific cookie named
		System.out.println(driver.manage().getCookieNamed("session-id"));
		
		System.out.println("===============================================================");
		
		//3. to create and cookie
		Cookie cobj = new Cookie("Mycookies141414", "axs12345_14:14:2010-march");
		driver.manage().addCookie(cobj);
		cookies = driver.manage().getCookies();
		System.out.println("Cookie size after adding new cookie:- "+cookies.size());
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie);
		}
		
		System.out.println("................................................................");
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		
		System.out.println("===============================================================");
		
		//4. to delete specific cookie
		driver.manage().deleteCookie(cobj);
		
		cookies=driver.manage().getCookies();
		System.out.println("size of cookies after delete: "+cookies.size());
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		
		System.out.println("===============================================================");
		
		//5. to delete specific cookie according to name
		driver.manage().deleteCookieNamed("i18n-prefs");
		cookies=driver.manage().getCookies();
		System.out.println("size of cookies after delete: "+cookies.size());
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		
		System.out.println("===============================================================");
		
		//6. to delete all cookies
		driver.manage().deleteAllCookies();
		
		cookies=driver.manage().getCookies();
		System.out.println("size of cookies after delete: "+cookies.size());
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		
		System.out.println("===============================================================");
	}
	
}
