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

public class CreateAnAccount {

	private WebDriver driver;
	public CommonMethods cm;
	public HomePage homepage;
	

	@FindBy(how = How.XPATH, using ="//*[@id='tdb4']/span[2]")
	  private WebElement clickcontinue;
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[2]/td[2]/input")
	  private WebElement firstname;
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[3]/td[2]/input")
	  private WebElement lastname;
	@FindBy(how = How.XPATH, using ="//*[@id='dob']")
	  private WebElement birth;
	@FindBy(how = How.NAME, using ="email_address")
	  private WebElement email;
	@FindBy(how = How.NAME, using ="company")
	  private WebElement company;
	@FindBy(how = How.NAME, using ="street_address")
	  private WebElement address;
	@FindBy(how = How.NAME, using ="suburb")
	  private WebElement suburb;
	@FindBy(how = How.NAME, using ="postcode")
	  private WebElement post;
	@FindBy(how = How.NAME, using ="city")
	  private WebElement city;
	@FindBy(how = How.NAME, using ="state")
	  private WebElement state;
	@FindBy(how = How.NAME, using ="telephone")
	  private WebElement number;
	@FindBy(how = How.NAME, using ="fax")
	  private WebElement fax;
	@FindBy(how = How.NAME, using ="password")
	  private WebElement password;
	@FindBy(how = How.NAME, using ="confirmation")
	  private WebElement confirm;
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")
	  private WebElement genderM;
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[2]")
	  private WebElement genderF;
	@FindBy(how = How.NAME, using ="newsletter")
	  private WebElement news;
	@FindBy(how = How.NAME, using ="country")
	  private WebElement country;
	
	
	public  CreateAnAccount(WebDriver driver){
		this.driver=driver;
		homepage = new HomePage(driver);
		homepage.createAccount();
		PageFactory.initElements(this.driver, this);
		String ExpectedText="My Account Information";
		String ActualText=driver.findElement(By.cssSelector("h1")).getText();
		System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
		Assert.assertEquals(ExpectedText,ActualText);
		cm = new CommonMethods(driver);
		}
	
	public void clickContinue(){
		clickcontinue.click();	
		System.out.println("pressed continue");
	}
	
	public void CreateAccount(int j) throws IOException, InvalidFormatException{
		Properties prop=cm.prop("config.properties");
		String ex = prop.getProperty("Excel");
		String sh = "Sheet1";
		System.out.println(cm.excel(ex,sh,0,j));
		gender(cm.excel(ex,sh,16,j));
		country(cm.excel(ex,sh,17,j));
		news(cm.excel(ex,sh,15,j));	
		cm.sendkey(firstname,cm.excel(ex,sh,1,j));
		cm.sendkey(lastname, cm.excel(ex,sh,2,j));
		cm.sendkey(email,cm.excel(ex,sh,3,j));
		cm.sendkey(company, cm.excel(ex,sh,4,j));
		cm.sendkey(address,cm.excel(ex,sh,5,j));
		cm.sendkey(suburb, cm.excel(ex,sh,6,j));
		cm.sendkey(post,cm.excel(ex,sh,7,j));		
		cm.sendkey(state, cm.excel(ex,sh,8,j));
		cm.sendkey(number,cm.excel(ex,sh,9,j));
		cm.sendkey(fax, cm.excel(ex,sh,10,j));
		cm.sendkey(password,cm.excel(ex,sh,11,j));
		cm.sendkey(confirm, cm.excel(ex,sh,12,j));
		cm.sendkey(city,cm.excel(ex,sh,13,j));
		cm.sendkey(birth, cm.excel(ex,sh,14,j));
		clickcontinue.click();		
	}
	
	public void CreateAccountError(int j) throws IOException, InvalidFormatException{
		Properties prop=cm.prop("config.properties");
		String ex = prop.getProperty("Excel");
		String sh = "Sheet1";
		System.out.println(cm.excel(ex,sh,0,j));
		gender(cm.excel(ex,sh,16,j));
		System.out.println("is this working");
		country(cm.excel(ex,sh,17,j));
		news(cm.excel(ex,sh,15,j));

		cm.sendkey(firstname,cm.excel(ex,sh,1,j));
		cm.sendkey(lastname, cm.excel(ex,sh,2,j));
		cm.sendkey(email,cm.excel(ex,sh,3,j));
		cm.sendkey(company, cm.excel(ex,sh,4,j));
		cm.sendkey(address,cm.excel(ex,sh,5,j));
		cm.sendkey(suburb, cm.excel(ex,sh,6,j));
		cm.sendkey(post,cm.excel(ex,sh,7,j));		
		cm.sendkey(state, cm.excel(ex,sh,8,j));
		cm.sendkey(number,cm.excel(ex,sh,9,j));
		cm.sendkey(fax, cm.excel(ex,sh,10,j));
		cm.sendkey(password,cm.excel(ex,sh,11,j));
		cm.sendkey(confirm, cm.excel(ex,sh,12,j));
		cm.sendkey(city,cm.excel(ex,sh,13,j));
		cm.sendkey(birth, cm.excel(ex,sh,14,j));
		clickcontinue.click();		
		String expected ="Errorshaveoccuredduringtheprocessofyourform.Pleasemakethefollowingcorrections:" + cm.excel(ex,sh,18,j);
		cm.verifyAlert(expected);	
	}	
	
	public void gender(String i){

			if(i.equals("male")){
				genderM.click();
			}
			else if(i.equals("female")){
				genderF.click();
			}		
			else{
			System.out.println(i);
		}
	}
	
	public void news(String i){
		String check = i;
		if(check == "true"){
		news.click();
		}
		else{
			
		}
	}
	
	public void country(String i) throws InvalidFormatException, IOException{
		cm.dropdown(country,i);
	}
}
