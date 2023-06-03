package com.Test.Part1;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileWithSikuli {
	
	WebDriver driver;
	
	@Test
	public void uploadScene1() throws InterruptedException, FindFailed {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		Actions act = new Actions(driver);
		driver.get("http://demo.automationtesting.in/Register.html");
		act.moveToElement(driver.findElement(By.xpath("//*[@type='file']"))).click().build().perform();
		
		Screen s = new Screen();
		
		String imagesFilePath = "D:\\SikuliScreenshots\\";
		String inputFilePath = "D:\\ImagesToUpload\\";
		
		Pattern fileInputTextBox = new Pattern(imagesFilePath+"FileTextBox");
		Pattern openButton = new Pattern(imagesFilePath+"OpenButton");
		
		s.wait(fileInputTextBox,20);
		s.type(fileInputTextBox,inputFilePath+"Scene1");
		s.click(openButton);
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
	
	//@Test
	public void uploadScene2() throws InterruptedException, FindFailed {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		Actions act = new Actions(driver);
		driver.get("http://demo.automationtesting.in/Register.html");
		act.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();
		
		Screen s =new Screen();
		
		String impagePath = "D:\\SikuliScreenshots\\";
		String inputFilePath = "D:\\ImagesToUpload\\";
		
		Pattern fileInputTextBox = new Pattern(impagePath+"FileTextBox");
		Pattern openButton = new Pattern(impagePath+"OpenButton");
		
		s.wait(fileInputTextBox,20);
		s.type(fileInputTextBox,inputFilePath+"Scene2");
		s.click(openButton);
		
		Thread.sleep(4000);
		driver.quit();
		
	}
	
	//@Test
	public void uploadEmployeePic() throws InterruptedException, FindFailed {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions act = new Actions(driver);
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		WebElement addEmployee = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_addEmployee']")));
		addEmployee.click();
		
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("abcd23588");
		driver.findElement(By.xpath("//*[@id='middleName']")).sendKeys("cxzas1222");
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("1assasdd");
		
		act.moveToElement(driver.findElement(By.xpath("//*[@type='file']"))).click().build().perform();
		
		Screen s = new Screen();
		
		String imagePath = "D:\\SikuliScreenshots\\";
		String inputFilePath = "D:\\ImagesToUpload\\";
		
		Pattern fileInputText = new Pattern(imagePath+"FileTextBox");
		Pattern openButton = new Pattern(imagePath+"OpenButton");
		
		s.wait(fileInputText,10);
		s.type(fileInputText,inputFilePath+"Employee_photo");
		s.click(openButton);
		
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		
		String expText = "Personal Details";
		String actText = driver.findElement(By.xpath("//h1[text()='Personal Details']")).getText();
		Assert.assertEquals(actText, expText);
		
	}
	
	//@Test
	public void downloadFile() throws FindFailed {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("testing");
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
		
		Screen s = new Screen();
		
		String imagePath = "D:\\SikuliScreenshots\\";
		
		Pattern saveRadioButton = new Pattern(imagePath+"saveRadioButton");
		Pattern okButton = new Pattern(imagePath+"OKButton");
		s.wait(saveRadioButton,20);
		s.click(saveRadioButton);
		s.click(okButton);
		
		if(fileExist("C:\\Users\\SaMsuL LiViC\\Downloads\\info.txt")==true) {
			System.out.println("txt file exists");
		}
		else {
			System.out.println("file does not exist");
		}
		
		driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys("testing");
		driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();
		
		Pattern saveRadioButton1 = new Pattern(imagePath+"saveRadioButton");
		Pattern okButton1 = new Pattern(imagePath+"OKButton");
		s.wait(saveRadioButton1,20);
		s.click(saveRadioButton1);
		s.click(okButton1);		
		

		if(fileExist("C:\\Users\\SaMsuL LiViC\\Downloads\\info.pdf")==true) {
			System.out.println("pdf file exists");
		}
		
		else {
			System.out.println("file does not exist");
		}
		
	}
	
	//@Test
	public void downloadFileInDesiredLocationInChrome() throws FindFailed {
		
		//download files in required location using chrome browser
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", "false");
		chromePrefs.put("download.default_directory", "D:\\SikuliDownloads");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("testing");
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
		
		/*Screen s = new Screen();
		
		String imagePath = "D:\\SikuliScreenshots\\";
		
		Pattern saveRadioButton = new Pattern(imagePath+"saveRadioButton");
		Pattern okButton = new Pattern(imagePath+"OKButton");
		s.wait(saveRadioButton,20);
		s.click(saveRadioButton);
		s.click(okButton);*/
		
		if(fileExist("C:\\Users\\SaMsuL LiViC\\Downloads\\info.txt")==true) {
			System.out.println("txt file exists");
		}
		else {
			System.out.println("file does not exist");
		}
		
		driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys("testing");
		driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();
		
		/*Pattern saveRadioButton1 = new Pattern(imagePath+"saveRadioButton");
		Pattern okButton1 = new Pattern(imagePath+"OKButton");
		s.wait(saveRadioButton1,20);
		s.click(saveRadioButton1);
		s.click(okButton1);		*/
		

		if(fileExist("C:\\Users\\SaMsuL LiViC\\Downloads\\info.pdf")==true) {
			System.out.println("pdf file exists");
		}
		
		else {
			System.out.println("file does not exist");
		}
	}
	
	@Test
	public void downloadFileInDesiredLocationWithFF() throws FindFailed {
		
		FirefoxProfile profile = new FirefoxProfile();
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain, application/pdf"); //set mime types
		profile.setPreference("browser.download.manager.showWhenStarting", false); //This will disable downloa popup window in ff
				
		//download files in desired location using chrome browser
		profile.setPreference("browser.download.dir", "D:\\SikuliDownloads");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("pdfjs.disabled", true); //only for pdf file (Important)
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("testing");
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
		
		/*Screen s = new Screen();
		
		String imagePath = "D:\\SikuliScreenshots\\";
		
		Pattern saveRadioButton = new Pattern(imagePath+"saveRadioButton");
		Pattern okButton = new Pattern(imagePath+"OKButton");
		s.wait(saveRadioButton,20);
		s.click(saveRadioButton);
		s.click(okButton);*/
		
		if(fileExist("C:\\Users\\SaMsuL LiViC\\Downloads\\info.txt")==true) {
			System.out.println("txt file exists");
		}
		else {
			System.out.println("file does not exist");
		}
		
		driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys("testing");
		driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();
		
		/*Pattern saveRadioButton1 = new Pattern(imagePath+"saveRadioButton");
		Pattern okButton1 = new Pattern(imagePath+"OKButton");
		s.wait(saveRadioButton1,20);
		s.click(saveRadioButton1);
		s.click(okButton1);		*/
		

		if(fileExist("C:\\Users\\SaMsuL LiViC\\Downloads\\info.pdf")==true) {
			System.out.println("pdf file exists");
		}
		
		else {
			System.out.println("file does not exist");
		}
	}
	
	boolean fileExist(String path) {
		File f = new File(path);
		
		if(f.exists()==true) {
			return true; 
		}
		else {
			return false;
		}
	}
	

}
