package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.common.CommonMethods;

public class HomePage {
	  private WebDriver driver;
	  public CommonMethods cm;
	  
	  @FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div/div[1]/a[1]/u")
	  	private WebElement logyourselflink;
	  @FindBy(how =How.XPATH, using = "//*[@id='tdb4']/span")
	  	private WebElement logoutlink;
	  @FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/div/div[1]/a[2]/u")
	    private WebElement createAccountLink;
	  @FindBy(how = How.XPATH, using ="//*[@id=\'bodyContent\']/div/div[2]/table/tbody/tr[1]/td[1]/a[1]/img")
	    private WebElement samsungLink;
	  @FindBy(how = How.XPATH, using ="//*[@id=\'bodyContent\']/div/div[2]/table/tbody/tr[1]/td[2]/a[1]/img")
	    private WebElement hewlettLink;
	  @FindBy(how = How.XPATH, using ="//*[@id=\'bodyContent\']/div/div[2]/table/tbody/tr[1]/td[3]/a[1]/img")
	    private WebElement mouseLink;
	  @FindBy(how = How.XPATH, using ="//*[@id=\"bodyContent\"]/div/div[2]/table/tbody/tr[2]/td[1]/a[1]/img")
	    private WebElement keyboardLink;
	  @FindBy(how = How.XPATH, using ="//*[@id=\"bodyContent\"]/div/div[2]/table/tbody/tr[2]/td[2]/a[1]/img")
	    private WebElement disciplesLink;
	  @FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/div/div[2]/table/tbody/tr[2]/td[3]/a[2]")
	    private WebElement timeLink;
	  @FindBy(how = How.XPATH, using ="//*[@id=\"bodyContent\"]/div/div[2]/table/tbody/tr[3]/td[1]/a[2]")
	    private WebElement unrealLink;
	  @FindBy(how = How.XPATH, using ="//*[@id=\"bodyContent\"]/div/div[2]/table/tbody/tr[3]/td[2]/a[2]")
	    private WebElement swatLink;
	  @FindBy(how = How.XPATH, using ="//*[@id=\"bodyContent\"]/div/div[2]/table/tbody/tr[3]/td[3]/a[2]")
	    private WebElement belovedLink;
	  @FindBy(how = How.XPATH, using = "//*[@id=\"columnLeft\"]/div[1]/div[2]/a[1]")
	    private WebElement hardwarelink;
	  @FindBy(how = How.XPATH, using = "//*[@id=\"columnLeft\"]/div[1]/div[2]/a[2]")
	    private WebElement softwarelink;
	  
	  
		public  HomePage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(this.driver, this);
			String ExpectedText="Welcome to iBusiness";
		    String ActualText=driver.findElement(By.cssSelector("h1")).getText();
		    System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
		    Assert.assertEquals(ExpectedText,ActualText);
		}
		
		public void clickLogyourselfLink(){
			logyourselflink.click();
			System.out.println("click log in");
			
		}
		
		public void clickLogOff(){
			logoutlink.click();
			System.out.println("click the log off ");
			   
		}
		
		public void createAccount(){
			createAccountLink.click();
			System.out.println("click create an account");
		}
		
		public void clickSamsung(){
			cm = new CommonMethods(driver);
			samsungLink.click();
			cm.verifyText("Samsung Galaxy");
		}
		
		public void clickHewlett(){
			cm = new CommonMethods(driver);
			hewlettLink.click();
			cm.verifyText("Hewlett Packard LaserJet 1100Xi");
		}
		
		public void clickMouse(){
			cm = new CommonMethods(driver);
			mouseLink.click();
			cm.verifyText("Microsoft IntelliMouse Explorer");
		}
		
		public void clickKeyboard(){
			cm = new CommonMethods(driver);
			keyboardLink.click();
			cm.verifyText("Microsoft Internet Keyboard PS/2");
		}
		
		public void clickDisciple(){
			cm = new CommonMethods(driver);
			disciplesLink.click();
			cm.verifyText("Disciples: Sacred Lands");
		}
		
		public void clickTime(){
			cm = new CommonMethods(driver);
			timeLink.click();
			cm.verifyText("The Wheel Of Time");
		}
		
		public void clickUnreal(){
			cm = new CommonMethods(driver);
			unrealLink.click();
			cm.verifyText("Unreal Tournament");
		}
		
		public void clickSwat(){
			cm = new CommonMethods(driver);
			swatLink.click();
			cm.verifyText("SWAT 3: Close Quarters Battle");
		}
		
		public void clickBeloved(){
			cm = new CommonMethods(driver);
			belovedLink.click();
			cm.verifyText("Beloved");
		}
		
		public void clickHardwarePage(){
			hardwarelink.click();
		}
		
		public void clickSoftwarePage(){
			softwarelink.click();
		}
}
