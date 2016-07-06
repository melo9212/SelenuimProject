package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.common.CommonMethods;

public class HardwarePage {
	private WebDriver driver;
	public CommonMethods cm;
	public HomePage homepage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr[1]/td[1]/a")
	  private WebElement cdr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr[1]/td[2]/a") 
	  private WebElement graphic;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr[1]/td[3]/a")
	  private WebElement keyboard;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr[2]/td[1]/a")
	  private WebElement memory;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr[2]/td[2]/a")
	  private WebElement mice;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr[2]/td[3]/a")
	  private WebElement monitor;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr[3]/td[1]/a")
	  private WebElement printer;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr[3]/td[2]/a")
	  private WebElement speaker;
	
	public  HardwarePage(WebDriver driver){
		this.driver=driver;
		cm = new CommonMethods(driver);
		homepage = new HomePage(driver);
		homepage.clickHardwarePage();
		PageFactory.initElements(this.driver, this);
		String ExpectedText="Hardware";
	    String ActualText=driver.findElement(By.cssSelector("h1")).getText();
	    System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
	    Assert.assertEquals(ExpectedText,ActualText);
	}
	
	public void clickCdr(){
		cdr.click();
		cm.verifyText("CDROM Drives");
	}
	
	public void clickGraphic(){
		graphic.click();
		cm.verifyText("Graphics Cards");
	}
	
	public void clickKeyboard(){
		keyboard.click();
		cm.verifyText("Keyboards");
	}
	
	public void clickMemory(){
		memory.click();
		cm.verifyText("Memory");
	}
	
	public void clickMice(){
		mice.click();
		cm.verifyText("Mice");
	}
	
	public void clickMonitor(){
		monitor.click();
		cm.verifyText("Monitors");
	}
	
	public void clickPrinter(){
		printer.click();
		cm.verifyText("Printers");
	}
	
	public void clickSpeaker(){
		speaker.click();
		cm.verifyText("Speakers");
	}

}
