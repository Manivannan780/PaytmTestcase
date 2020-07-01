package com_PageTestCase;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com_PageElements.MainPageElements;
import general_Functions.Constant_Functions;
import general_Functions.Listenerclass;

@Listeners(Listenerclass.class)
public class Testcase1 extends Constant_Functions {

	static Logger logobj=Logger.getLogger(Testcase1.class);
	public static String productext="";
	


	@Test
	public void Page1()   {
		logobj.info("Elements fetching");
		
		PageFactory.initElements(driver, MainPageElements.class);
		
		logobj.info("Clicking Men clothing");
		driver.navigate().refresh();
		MainPageElements.menclothing.click();

		logobj.info("Price Selection");
		priceselection();

		logobj.info("Fetching the product Details size");
		produtdetailsize();


		logobj.info("Getting the number of rows count");
		fetchingcolcount();

		logobj.info("Clicking the product");
		MainPageElements.productclick.click();

		logobj.info("driver passed to New Window");
		NewWindow();

		logobj.info("Assert Verification");
		verification();

	}

	public static void priceselection() {
		Actions actobj=new Actions(driver);
		actobj.dragAndDrop(MainPageElements.maxiumprice, MainPageElements.miniumprice).build().perform();

	}
	public static void produtdetailsize() {
		System.out.println(MainPageElements.productdetails.size());
	}

	public static void fetchingcolcount() {

		for(int i=0;i<MainPageElements.productdetails.size();i++) { String
			xpathrows="//div[@class=\'_1fje\']/div["+i+"]/div";
		List<WebElement>cols=driver.findElements(By.xpath(xpathrows));
		System.out.println("Number of rows are"+cols.size());

		}

	}
	public static  void NewWindow() {
		String Parentwindow=driver.getWindowHandle();
		Set<String>allwindow=driver.getWindowHandles();
		for (String child : allwindow) {

			driver.switchTo().window(child);
		}
		productext=MainPageElements.productname.getText();
		System.out.println(productext);
		driver.close();
		driver.switchTo().window(Parentwindow);
	}

	public static void verification() {
		Assert.assertEquals(productext, "Rupa 1 Sleeveless Round Neck Men Vest - White");
	}
}
