package com.rediff.rough;

import java.util.Date;

import com.rediff.utill.Xls_Reader;

public class DataFromExcel {
	
	public static void main(String[] args) {
		testData();
		
	}
	
	
	public static void testData(){
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\resources\\xls\\DataReading.xlsx");
		int rcount = xls.getRowCount("Data");		
		System.out.println(rcount);
		for(int i=0;i<=rcount;i++){
			String getData =xls.getCellData("Data",0,i);
			String getData1 =xls.getCellData("Data",1,i);
			String getData2 =xls.getCellData("Data",2,i);
			System.out.print(getData);
			System.out.print("|"+getData1);
			System.out.println("|"+getData2);
			Date date = new Date();
			date.getDate();
			System.out.println(	date.getTimezoneOffset());
		}
		
			
			
		}
		
	
	
	
	

}
