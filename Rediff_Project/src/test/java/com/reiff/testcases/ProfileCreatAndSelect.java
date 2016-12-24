package com.reiff.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.rediff.config.ObjectRepository;
import com.rediff.utill.Driver;

public class ProfileCreatAndSelect {
	
	
	public static void createProfile(){
		//Driver.Initalize();
		Driver.click(ObjectRepository.createProfile_Link);		
		WebElement ele = Driver.Instance.findElement(By.xpath(ObjectRepository.profile_Text_Box));
		ele.clear();
		ele.sendKeys("Protfolio121");
		Driver.Wait();
		//Driver.inputt(".//*[@id='create']", "Protfolio01");
		//Driver.click(".//*[@id='create']");
		Driver.Instance.findElement(By.xpath(ObjectRepository.createProfile_button)).sendKeys(Keys.ENTER);;
	}
	
	public static void deleteProfile(){
		Driver.Instance.findElement(By.xpath(".//*[@id='portfolioid']")).sendKeys("Portfolioi122");	
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Driver.Instance.findElement(By.xpath(".//*[@id='portfolioid']")).sendKeys(Keys.ENTER);
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Driver.click(ObjectRepository.profile_Delete);
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Driver.Instance.switchTo().alert().accept();
		
	}
	
	public static void renameProfile(){
		Driver.Instance.findElement(By.xpath(".//*[@id='portfolioid']")).sendKeys("Portfolioi121");	
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Driver.Instance.findElement(By.xpath(".//*[@id='portfolioid']")).sendKeys(Keys.ENTER);
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement el = Driver.Instance.findElement(By.xpath(ObjectRepository.rename_protfolio));
		el.click();
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement el1 = Driver.Instance.findElement(By.xpath(ObjectRepository.rename_Text_Box));
		el1.clear();
		el1.sendKeys("Portfolioi122");
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Driver.Instance.findElement(By.xpath(ObjectRepository.rename_button)).click();
		
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}

}
