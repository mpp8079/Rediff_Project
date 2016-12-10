package com.reiff.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rediff.config.ObjectRepository;
import com.rediff.utill.Driver;

public class Login {
	
	WebElement driver=null;
	
	@BeforeTest
	public void openBorwserAndUrl(){
		Driver.Initalize();
		Driver.Instance.navigate().to(ObjectRepository.getUrl.url);
		
	}	
	@Test
	public void clicklogin(){
		Driver.click(ObjectRepository.Money);
		Driver.click(ObjectRepository.login);
		Driver.inputt(ObjectRepository.user_Name,"mpp1221@yahoo.com");
		Driver.click(ObjectRepository.user_submitt_button);
		Driver.inputt(ObjectRepository.password,"abc123");
		Driver.click(ObjectRepository.Login_submitt_button);
		
		//Driver.Instance.findElement(By.xpath(ObjectRepository.Money)).click();
		//Driver.Instance.findElement(By.xpath(ObjectRepository.login)).click();
		//Driver.Instance.findElement(By.xpath(ObjectRepository.user_Name)).sendKeys("mpp1221@yahoo.com");
		//Driver.Instance.findElement(By.xpath(ObjectRepository.user_submitt_button)).click();
		//Driver.Instance.findElement(By.xpath(ObjectRepository.password)).sendKeys("abc123");;
		//Driver.Instance.findElement(By.xpath(ObjectRepository.Login_submitt_button)).click();
	
	}
	
	
	

}
