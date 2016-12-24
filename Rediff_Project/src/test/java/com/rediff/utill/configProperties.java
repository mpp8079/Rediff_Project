package com.rediff.utill;

import java.io.FileInputStream;
import java.util.Properties;
public class configProperties {
	
	public static Properties pro ;
	
	
	public  static void getProperties(){
		pro =new Properties();
		try {
			FileInputStream file = new FileInputStream("C:\\rediff_project\\Rediff_Project\\Rediff_Project\\src\\properties\\config.properties");
			pro.load(file);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
