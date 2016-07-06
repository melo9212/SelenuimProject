package com.tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.common.CommonMethods;
import com.pageobjects.*;

public class TestHomepage {
	private WebDriver driver;
	public HomePage homepage;
	public CommonMethods cm;

	@BeforeMethod
	public void setUp() throws InvalidFormatException, IOException{
		cm=new CommonMethods(driver);
		Properties prop=cm.prop("config.properties");
		String browser = prop.getProperty("BrowserType");
		String url 	= prop.getProperty("URL");		
		driver=cm.openBrowser(browser);
		cm.goToURL(url);
		homepage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		cm.closeBrowser();		
	}
	
	@Test
	public void homepagelink1(){
		homepage.clickSamsung();
	}
	
	@Test
	public void homepagelink2(){
		homepage.clickMouse();
	}
	
	@Test
	public void homepagelink3(){
		homepage.clickHewlett();
	}
	
	@Test
	public void homepagelink4(){
		homepage.clickKeyboard();
	}
	
	@Test
	public void homepagelink5(){
		homepage.clickDisciple();
	}
	
	@Test
	public void homepagelink6(){
		homepage.clickTime();
	}
	
	@Test
	public void homepagelink7(){
		homepage.clickUnreal();
	}
	
	@Test
	public void homepagelink8(){
		homepage.clickSwat();
	}
	
	@Test
	public void homepagelink9(){
		homepage.clickBeloved();
	}	
}
