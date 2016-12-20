package com.rediff.config;

public class ObjectRepository {
	
	public static String login=".//*[@id='signin_info']/a[1]";
	public static String Money=".//*[@id='homewrapper']/div[5]/a[3]/div/u";
	public static String My_Portfolio=".//*[@id='wrapper']/div[2]/ul/li[2]/a";
	public static String user_Name =".//*[@id='useremail']";
	public static String password =".//*[@id='userpass']";
	public static String user_submitt_button =".//*[@id='emailsubmit']";
	public static String Login_submitt_button =".//*[@id='loginsubmit']";
	public static String createProfile_button =".//*[@id='createPortfolioButton']";		
	public static String createProfile_Link =".//*[@id='createPortfolio']";
	public static String profile_Text_Box=".//*[@id='create']";
	public static String profile_Delete=".//*[@id='deletePortfolio']";
	public static String rename_protfolio=".//*[@id='renamePortfolio']";
	public static String rename_Text_Box=".//*[@id='rename']";
	public static String rename_button =".//*[@id='renamePortfolioButton']";	
	public static String add_Stock=".//*[@id='addStock']";
	public static String add_Stock_button=".//*[@id='addStockButton']";	
	public static String add_Stock_name=".//*[@id='addstockname']";
	
	
	public static class getUrl{
		public static String url="http://www.rediff.com/";
	}
	
	public static class browser{
		public static String browser="Chrome";
	}

}
