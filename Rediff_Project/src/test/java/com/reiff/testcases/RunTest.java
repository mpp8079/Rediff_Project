package com.reiff.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rediff.config.ObjectRepository;
import com.rediff.utill.Driver;

public class RunTest {

	
	@BeforeTest
	public void openBorwserAndUrl(){
		Driver.Initalize();
	Driver.Instance.navigate().to(ObjectRepository.getUrl.url);
		
	}	
	
	@Test
	public void runTest(){
		
		
		Login.clickSignInLink();
		Login.sendUserName();
		Login.sendPass();		
		Login.clickLoginSubmit();
		//ProfileCreatAndSelect.createProfile();
		//ProfileCreatAndSelect.deleteProfile();
		//ProfileCreatAndSelect.renameProfile();
		AddStock.addNewStock();
		
	
	}
}
