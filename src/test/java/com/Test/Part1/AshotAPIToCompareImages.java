package com.Test.Part1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

//Ashot API, Gson, Hamcreast-all dependency jar files are required to do image comparison in Selenium
//Ashot API is used capture screenshots of an image elements on the webpage
//Ashot API helps to compare existing image with newly captured image

//AShot().takeScreenshots => to capture screenshot of image element
//getImage() => to convert screenshot file into image file
//ImageIO => To read or write a image file in a location
//BufferedImage => DataType to hold image value
//ImageDiffer => Class providing .makeDiff() method to compare images
//ImageDiff => Asert class of two image files
//hasDiff() => to find whether two images are same or different

public class AshotAPIToCompareImages {

	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	//@Test(priority = 1)
	public void captureImageFromWebApp() throws IOException {
		
		WebElement logoImpageCapture = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		Screenshot logoImageScreenshot= new AShot().takeScreenshot(driver, logoImpageCapture);
		ImageIO.write(logoImageScreenshot.getImage(), "png", new File("D:\\AShotImages\\OrangeHrmLogo3.png"));
		
		File file = new File("D:\\AShotImages\\OrangeHrmLogo3.png");
		
		if(file.exists()==true) {
			System.out.println("Image captured");
		}
		else {
			System.out.println("Imgae not captured");
		}
	}
	
	//@Test(priority = 2)
	public void compareImages() throws IOException {
		
		BufferedImage ExpectedImage = ImageIO.read(new File("D:\\AShotImages\\OrangeHrmLogo.png"));
		
		WebElement logoImpageCapture = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		Screenshot logoImageScreenshot= new AShot().takeScreenshot(driver, logoImpageCapture);
		BufferedImage actualImage = logoImageScreenshot.getImage();
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(ExpectedImage, actualImage);
		
		if(diff.hasDiff()==true) {
			System.out.println("Images are not same");
		}
		else {
			System.out.println("Images are same");
		}
	}
}
