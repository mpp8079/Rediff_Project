package com.reiff.testcases;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.rediff.config.ObjectRepository;
import com.rediff.utill.Driver;

public class AddStock {
	public static String companyText = "Ta";
	public static String purchase_date = "24/04/2015";
	public static String quantity = "100";
	public static String purchase_price = "15";

	public static void addNewStock() {
		// Driver.Instance.findElement(By.xpath(ObjectRepository.My_Portfolio)).sendKeys("Portfolioid134");
		// Driver.Instance.findElement(By.xpath(ObjectRepository.My_Portfolio)).sendKeys(Keys.ENTER);

		Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) Driver.Instance;
		jse.executeScript("window.scrollBy(182, 36)", "");
		Driver.click(ObjectRepository.add_Stock);
		Driver.waitAndClick(ObjectRepository.add_Stock_name, ".//*[@id='stockAddDate']");
		// Driver.Instance.findElement(By.xpath(ObjectRepository.add_Stock_name)).sendKeys(companyNane);
		selectCompanyName(ObjectRepository.add_Stock_name, companyText);

	}

	public static void selectCompanyName(String xPath, String company2) {
		String companyNane = "Tata Motors Ltd.";
		for (int i = 0; i < company2.length(); i++) {
			char character = company2.charAt(i);
			Driver.Instance.findElement(By.xpath(xPath)).sendKeys(String.valueOf(character));

			if (Driver.isElementPresent("//div[@id='ajax_listOfOptions']/div[text()='" + companyNane + "']")) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Driver.Instance
						.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[text()='" + companyNane + "']"))
						.click();
				// Driver.Instance.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[text()='"+company2+"']")).click();
				Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;

			}

		}

	}

	public static void addDate() {
		//Driver.Instance.findElement(By.id("stockPurchaseDate")).click();
		Date currentDate = new Date();
		System.out.println(currentDate);
		

	}

}
