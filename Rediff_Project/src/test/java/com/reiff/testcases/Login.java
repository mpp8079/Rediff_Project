package com.reiff.testcases;

import org.openqa.selenium.WebElement;

import com.rediff.config.ObjectRepository;
import com.rediff.utill.Driver;

public class Login {
	
	WebElement driver=null;
	
	
	
	
	public static void clickSignInLink(){		
		Driver.click(ObjectRepository.Money);
		Driver.click(ObjectRepository.login);		
		Driver.Wait();
	}
	
	
	
	public static void sendUserName(){		
		Driver.inputt(ObjectRepository.user_Name,"mpp1221@yahoo.com");
		Driver.click(ObjectRepository.user_submitt_button);	
		Driver.Wait();
	}
	
	
	public static void sendPass(){		
		Driver.inputt(ObjectRepository.password,"abc123");		
		Driver.Wait();
	}
	
	public static void clickLoginSubmit(){			
		Driver.click(ObjectRepository.Login_submitt_button);		
		Driver.Wait();
	}
	
	
	
	
	

}
