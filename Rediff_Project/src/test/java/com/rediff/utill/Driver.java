package com.rediff.utill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.rediff.config.ObjectRepository;

import junit.framework.Assert;

public class Driver {
	
	public static WebDriver Instance=null;
	//private static String browser="chrome";

	public static void Initalize(){
		if(Instance==null){
			if(ObjectRepository.browser.browser.equalsIgnoreCase("FireFox"))
			Instance = new FirefoxDriver();
			
			
			else if(ObjectRepository.browser.browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\rediff_project\\Rediff_Project\\Rediff_Project\\chromedriver.exe");
			Instance = new ChromeDriver();
			
		}else if(ObjectRepository.browser.browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.IE.driver", "C:\\rediff_project\\Rediff_Project\\Rediff_Project\\IEDriverServer.exe");
			Instance = new InternetExplorerDriver();
		
		}else{
			Assert.fail("Invalid Browser");
		}
		
		Instance.manage().window().maximize();
		Instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	}
	
	public static void click(String x_path){
		WebElement ele =Instance.findElement(By.xpath(x_path));
		ele.click();
	}
	
	public static void inputt(String x_path , String data){
		WebElement ele =Instance.findElement(By.xpath(x_path));
		ele.sendKeys(data);
	}
	
	public static void close(){
		Instance.close();
	}
	
	public static void quit(){
		Instance.quit();
	}
}