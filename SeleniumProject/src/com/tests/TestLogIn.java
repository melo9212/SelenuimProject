package com.tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.common.*;
import com.pageobjects.*;

public class TestLogIn {
	private WebDriver driver;
	public CommonMethods cm;
	public Login login; 
	
	@BeforeMethod
	public void setUp() throws InvalidFormatException, IOException{
		cm=new CommonMethods(driver);
		Properties prop=cm.prop("config.properties");
		String browser = prop.getProperty("BrowserType");
		String url 	= prop.getProperty("URL");		
		driver=cm.openBrowser(browser);
		cm.goToURL(url);
		login = new Login(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		cm.closeBrowser();		
	}
	
	@Test
	public void login() throws InvalidFormatException, IOException{
		login.login(1);
	}
	
	@Test
	public void wrongLogin() throws InvalidFormatException, IOException{
		login.Wronglogin(2);
	}
	
	
	

}
