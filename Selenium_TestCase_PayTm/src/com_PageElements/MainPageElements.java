package com_PageElements;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import general_Functions.Constant_Functions;

public class MainPageElements extends Constant_Functions {

	@FindBy(xpath ="//a[@title=\"Men | Men Clothing\"]" )
	public static WebElement menclothing;

	

	@FindBy(xpath="//div[@class=\"rc-slider-handle rc-slider-handle-2\"]")
	public static WebElement maxiumprice;
	
	@FindBy(xpath="//div[@class=\"rc-slider-handle rc-slider-handle-1\"]")
	public static WebElement miniumprice;
	
	@FindBy(xpath = "//div[@class=\"_1fje\"]/div")
	public static List<WebElement> productdetails;
	
	
	@FindBy(xpath = "//div[@class=\"_3WhJ\"]")
	public static WebElement productclick;
	
	@FindBy(xpath = "//div[@class=\"_2viE\"]/h1")
	public static WebElement productname;
	
	

	
	
	
	
}
