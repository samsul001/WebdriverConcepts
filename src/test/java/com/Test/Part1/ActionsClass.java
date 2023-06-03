//Actions class is an advanced User Interactions API for handling special mouse events. 
//Following are the methods available in Actions class for handling special mouse events.

//Methods() => cickAndHold(), contextClick(), doubleClick(), dragAndDrop(source, target), 
// dragAndDropBy(source, x-offset, y-offset), moveToElement(), moveOfset(x-offset, y-offset), release().

//Actions => MouseHover, Mouse Right click, drag and drop, Slider, Resizable

//Mouse Hover => moveToElement().build().perform()
//Right click => contextClick().build().perform()
//Drag and dropdown => clickAndHold().moveToElement().release().build().perform();
//slider => moveToElement().dragAndDropBy(); or moveToElement().clickAndHold().moveByOffset().build.perform();
//Resize => moveToElement().dragAndDropBy();

/*
 * Drag and Dropdown
 * -----------------
 * http://www.dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html
 * http://www.dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
 * http://www.dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz-d2.html
 * 
 * Slider
 * ------
 * http://demo.automationtesting.in/Slier.html
 * 
 * Re-Sizing
 * ---------
 * https://strml.github.io/react-resizable/examples/1.html
 * 
 * Mouse Hover
 * -----------
 * http://opensource-demo.orangehrmlive.com/index.php/dashboard * 
 */

package com.Test.Part1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsClass {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUpBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\WebDriverConcepts\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	//@Test
	public void mouseHoverExample() {		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		Actions act = new Actions(driver);
		
		WebElement admin = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
		WebElement usermg =driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
		WebElement users = driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"));
		//moveToElement()
		/*Type-1 , write actions on elements in sebsequent next steps		 
		act.moveToElement(admin).build().perform(); //Mouse hover to admin
		act.moveToElement(usermg).build().perform(); //Mosue hover to usermg
		act.moveToElement(users).click().build().perform(); //Mousehover to user and click users link
		*/
		
		act.moveToElement(admin).moveToElement(usermg).moveToElement(users).click().build().perform();
		
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
	
	//@Test
	public void mouseRightClick() {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);		
		WebElement button = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		act.contextClick(button).build().perform(); //right click on element
		driver.findElement(By.xpath("/html/body/ul/li[1]/span")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		
		driver.quit();
	}
	
	//@Test
	public void dragAndropDown() {
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement source1 = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement target1 = driver.findElement(By.xpath("//div[@id='box103']"));
		
		WebElement source2 = driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement target2 = driver.findElement(By.xpath("//div[@id='box105']"));
		
		WebElement source3 = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement target3 = driver.findElement(By.xpath("//div[@id='box106']"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(source1).moveToElement(target1).release().build().perform();
		act.clickAndHold(source2).moveToElement(target2).release().build().perform();
		act.clickAndHold(source3).moveToElement(target3).release().build().perform();
		
		
	}
	
	//@Test
	public void sliderHandling() {
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement draggingElement = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		Actions act = new Actions(driver);
		act.moveToElement(draggingElement).dragAndDropBy(draggingElement, 300, 0).build().perform();
		
		//driver.quit();
	}
	
	@Test
	public void sliderHandling1() {
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement draggingElement = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		Actions act = new Actions(driver);
		act.moveToElement(draggingElement).clickAndHold(draggingElement).moveByOffset(100, 0).build().perform();
		act.moveToElement(draggingElement).dragAndDropBy(draggingElement, 300, 0).dragAndDropBy(draggingElement, -300, 0).build().perform();
		
		driver.quit();
	}
	
	//@Test
	public void Resizeable() throws InterruptedException {
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		WebElement resizeElement = driver.findElement(By.xpath("//div[@id='resizable']//child::div[3]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(resizeElement).dragAndDropBy(resizeElement, 100, 150).build().perform();
		Thread.sleep(3000);
	}
}
