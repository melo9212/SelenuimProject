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

public class TestSoftware {
	private WebDriver driver;
	public CommonMethods cm;
	public SoftwarePage software;
	
	@BeforeMethod
	public void setUp() throws InvalidFormatException, IOException{
		cm=new CommonMethods(driver);
		Properties prop=cm.prop("config.properties");
		String browser = prop.getProperty("BrowserType");
		String url 	= prop.getProperty("URL");		
		driver=cm.openBrowser(browser);
		cm.goToURL(url);
		software = new SoftwarePage(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		cm.closeBrowser();		
	}
	
	@Test
	public void SoftwarePageLink1(){
		software.clickAction();
	}
	
	@Test
	public void SoftwarePageLink2(){
		software.clickSimulation();
	}
	
	@Test
	public void SoftwarePageLink3(){
		software.clickStrategy();
	}
}
