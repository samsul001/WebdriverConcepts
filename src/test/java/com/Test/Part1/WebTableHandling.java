package com.Test.Part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableHandling {
	WebDriver driver;	
	//@Test
	public void readDataInWebTable() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/workspace_selenium/sample.html");
		driver.manage().window().maximize();

		int rowCount = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		System.out.println(rowCount);

		int colCount = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/td")).size();
		System.out.println(colCount);

		for(int i=2;i<=rowCount;i++) {
			for(int j=1;j<=colCount;j++) {
				System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
			}
			System.out.println();
		}

		driver.quit();
	}

	/*Test case:- 1
	 * Open url: http://opensource-demo.orangehrmlive.com/
	 * Login (Admin/admin123)
	 * Admin-> Admin User management -> users
	 * validation:- Count the employees whose status is enabled
	 */
	@Test
	public void tc001_validatingUsernameEnabled() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']")).click();
		driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']")).click();
		
		int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();		
		int countOfStatusEnabledUser = 0;
		
		for(int i=1;i<=rowCount;i++) {
			String statusText = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[5]")).getText();
			if(statusText.equals("Enabled")) {
				countOfStatusEnabledUser = countOfStatusEnabledUser+1;
			}
		}
		System.out.println("Total Count of the employees whose status is enabled: "+countOfStatusEnabledUser);		
		driver.quit();
	}
	
	/*Test case:- 2
	 * Open url: http://opensource-demo.orangehrmlive.com/
	 * Login (Admin/admin123)
	 * PIM -> Employee list
	 * validation:- Retrive all employee details from a table
	 */
	//@Test
	public void getCellDataFromEmployeeTable() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		
		int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td")).size();
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=1;j<=colCount;j++) {
				String tableCellData = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(tableCellData+" ");
			}
			System.out.println();
		}
		driver.quit();
		
	}

}
