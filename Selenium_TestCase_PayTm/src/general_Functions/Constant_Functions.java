package general_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Constant_Functions {
	String Url;
	String Location;
	String Browser;
	public static WebDriver driver;
	static Properties propertyobj;
	org.apache.log4j.Logger objj=org.apache.log4j.Logger.getLogger(Constant_Functions.class);

	public static Properties Readingproperty() throws IOException {
		FileInputStream fileobj=new FileInputStream("General.properties");
		propertyobj= new Properties();
		propertyobj.load(fileobj);
		return propertyobj;
	}

	public static void loggerfilereading() {

		PropertyConfigurator.configure("loging.properties");
	}


	@BeforeSuite
	public void BrowserLaunching() throws IOException {
		loggerfilereading();
		objj.info("Property File Reading");
		Readingproperty();
		browserproperty();
	}


	public void browserproperty() {
		Location=propertyobj.getProperty("location");
		Url=propertyobj.getProperty("url");
		Browser=propertyobj.getProperty("Browser");

		System.setProperty("webdriver.chrome.driver",Location);
		driver=new ChromeDriver();
		
		objj.info("Browser Opening");
		driver.get(Url);
		
		objj.info("Window Maximizing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	public static void failed() {
		TakesScreenshot screenshotobj=(TakesScreenshot)driver;
		File fobj=screenshotobj.getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\Java\\Failedtes.png");
		try {
			FileHandler.copy(fobj, destination);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public void BrowserTermination() {
		//objj.info("Driver Terminating");
		//driver.quit();
	}

}
