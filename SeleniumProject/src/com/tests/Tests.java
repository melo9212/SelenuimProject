package com.tests;

import java.io.IOException;
import java.util.Properties;

//import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.common.CommonMethods;
//import com.pageobjects.CreateAnAccount;
//import com.pageobjects.HomePage;
import com.pageobjects.*;


public class Tests {

	private WebDriver driver;
	
	public HomePage homepage;
	public CreateAnAccount account;
	public CommonMethods cm;
	public HardwarePage hardware;
	public SoftwarePage software;
	
//	private Logger logger= Logger.getLogger(HomePage.class);
	
	@BeforeMethod
	public void setUp() throws InvalidFormatException, IOException{
		cm=new CommonMethods(driver);
		Properties prop=cm.prop("config.properties");
		String browser = prop.getProperty("BrowserType");
		String url 	= prop.getProperty("URL");		
		driver=cm.openBrowser(browser);
		cm.goToURL(url);
		account = new CreateAnAccount(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		cm.closeBrowser();		
	}
	
	

	@Test
	public void CreateAccount() throws IOException, InvalidFormatException{
		account.CreateAccount(1);			
	}
	
	@Test
	public void CreateAccountError() throws IOException, InvalidFormatException{
		account.clickContinue();
		String expected = "Errors have occured during the process of your form.\r\n" + 
				"\r\n" + 
				"Please make the following corrections:\r\n" + 
				"\r\n" + 
				"* Please select your Gender.\r\n" + 
				"* Your First Name must contain a minimum of 2 characters.\r\n" + 
				"* Your Last Name must contain a minimum of 2 characters.\r\n" + 
				"* Your Date of Birth must be in this format: MM/DD/YYYY (eg 05/21/1970)\r\n" + 
				"* Your E-Mail Address must contain a minimum of 6 characters.\r\n" + 
				"* Your Street Address must contain a minimum of 5 characters.\r\n" + 
				"* Your Post Code must contain a minimum of 4 characters.\r\n" + 
				"* Your City must contain a minimum of 3 characters.\r\n" + 
				"* Your State must contain a minimum of 2 characters.\r\n" + 
				"* You must select a country from the Countries pull down menu.\r\n" + 
				"* Your Telephone Number must contain a minimum of 3 characters.\r\n" + 
				"* Your Password must contain a minimum of 5 characters.";
		
		cm.verifyAlert(expected);
	}
	
	@Test
	public void firstnameError() throws IOException, InvalidFormatException{
		account.CreateAccountError(2);	
	}
	
	@Test
	public void lastnameError() throws IOException, InvalidFormatException{
		account.CreateAccountError(3);
	}
	
	@Test
	public void emailError() throws IOException, InvalidFormatException{
		account.CreateAccountError(4);
	}
	
	@Test
	public void addressError() throws IOException, InvalidFormatException{
		account.CreateAccountError(5);
	}
	
	@Test
	public void postError() throws IOException, InvalidFormatException{
		account.CreateAccountError(6);
	}
	
	@Test
	public void stateError() throws IOException, InvalidFormatException{
		account.CreateAccountError(7);
	}
	
	@Test
	public void phoneError() throws IOException, InvalidFormatException{
		account.CreateAccountError(8);
	}
	
	@Test
	public void passwordError() throws IOException, InvalidFormatException{
		account.CreateAccountError(9);
	}
	
	@Test
	public void confirmError() throws IOException, InvalidFormatException{
		account.CreateAccountError(10);
	}
	
	@Test
	public void cityError() throws IOException, InvalidFormatException{
		account.CreateAccountError(11);
	}
	
	@Test
	public void dobError() throws IOException, InvalidFormatException{
		account.CreateAccountError(12);
	}
	
	@Test
	public void genderError() throws IOException, InvalidFormatException{
		account.CreateAccountError(13);
	}
	
}
