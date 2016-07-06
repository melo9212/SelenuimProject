package com.pageobjects;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.common.CommonMethods;

public class Login {
	private WebDriver driver;
	public CommonMethods cm;
	public HomePage homepage;
	
	@FindBy(how = How.NAME, using ="email_address")
	  private WebElement email;
	@FindBy(how = How.NAME, using = "password")
	  private WebElement password;
	@FindBy(how = How.XPATH, using = "//*[@id=\"tdb5\"]/span[2]")
	  private WebElement signin;
	

	public  Login(WebDriver driver){
		this.driver=driver;
		cm = new CommonMethods(driver);
		homepage = new HomePage(driver);
		homepage.clickLogyourselfLink();
		PageFactory.initElements(this.driver, this);
		String ExpectedText="Welcome, Please Sign In";
		String ActualText=driver.findElement(By.cssSelector("h1")).getText();
		System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
		Assert.assertEquals(ExpectedText,ActualText);
		}
	
	public void login(int j) throws InvalidFormatException, IOException{
		Properties prop=cm.prop("config.properties");
		String ex = prop.getProperty("Excel");	
		String sh = "Sheet2";
		System.out.println(cm.excel(ex,sh,0,j));
		cm.sendkey(email, cm.excel(ex,sh,1,j));
		cm.sendkey(password, cm.excel(ex,sh,2,j));
		signin.click();
		String expected = cm.excel(ex, sh, 3, j);
		String expected2 = cm.excel(ex, sh, 4, j);
		cm.verifyText(expected);
		homepage.clickLogOff();
		cm.verifyText(expected2);
	}
	
	public void Wronglogin(int j) throws InvalidFormatException, IOException{
		Properties prop=cm.prop("config.properties");
		String ex = prop.getProperty("Excel");	
		String sh = "Sheet2";
		System.out.println(cm.excel(ex,sh,0,j));
		cm.sendkey(email, cm.excel(ex,sh,1,j));
		cm.sendkey(password, cm.excel(ex,sh,2,j));
		signin.click();
		String expected = cm.excel(ex, sh, 3, j);
		cm.verifyText(expected);

	}

}
