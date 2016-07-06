package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.common.CommonMethods;

public class SoftwarePage {
	private WebDriver driver;
	public CommonMethods cm;
	public HomePage homepage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr/td[1]/a")
	  private WebElement action;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr/td[2]/a")
	  private WebElement simulation;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyContent\"]/div/div/table/tbody/tr/td[3]/a")
	  private WebElement strategy;

	public  SoftwarePage(WebDriver driver){
		this.driver=driver;
		cm = new CommonMethods(driver);
		homepage = new HomePage(driver);
		homepage.clickSoftwarePage();
		PageFactory.initElements(this.driver, this);
		String ExpectedText="Software";
		String ActualText=driver.findElement(By.cssSelector("h1")).getText();
		System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
		Assert.assertEquals(ExpectedText,ActualText);

		}
	
	public void clickAction(){
		action.click();
		cm.verifyText("Action");
	}
	
	public void clickSimulation(){
		simulation.click();
		cm.verifyText("Simulation");
	}
	
	public void clickStrategy(){
		strategy.click();
		cm.verifyText("Strategy");
	}
	
}
