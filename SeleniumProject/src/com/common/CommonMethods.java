package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonMethods {
	private WebDriver driver;
	
	public CommonMethods(WebDriver driver){
		this.driver = driver;
	}
	
	public void setDriver(WebDriver driver){
		this.driver = driver;
	}
	
	//To open browser
	public WebDriver openBrowser(String browserType){
		if (browserType.contentEquals("Firefox")){
			driver=new FirefoxDriver();
			System.out.println("opening browser");
		}else if (browserType.contentEquals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
			DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
	   		Capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
	   		driver = new ChromeDriver(Capabilities); 
	   		System.out.println("opening browser");
		}else{
			System.out.println("Please select the Firefox or Chome Browser");
			Assert.fail("Browser not selected");
		}
			
		driver.manage().window().maximize();
		System.out.println(" Browser is mazimized");
		driver.manage().deleteAllCookies();
		System.out.println("deleted all cookies");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	//To read from property file
	public Properties prop(String properties) throws IOException, InvalidFormatException{
		File file = new File(properties);
		FileInputStream fileInput = null;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop;
	}
	
	//To read from excel sheet
	public String excel(String excel, String sheet, int i, int j) throws IOException, InvalidFormatException{
		
		FileInputStream file=new FileInputStream(excel);
		Workbook wb=WorkbookFactory.create(file);
		Sheet sh=wb.getSheet(sheet);
		Row row=sh.getRow(i);
		Cell cell=row.getCell(j);
		String val=null;
		if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
			 val=String.valueOf((int)(cell.getNumericCellValue()));	
		}
		else if (cell.getCellType()==Cell.CELL_TYPE_BOOLEAN){
			val=String.valueOf(cell.getBooleanCellValue());							
		}
		else {
			val =cell.getStringCellValue();
		}
		return val;
	}
	
	//To open dropdown box
	public void dropdown(WebElement id, String text) throws IOException, InvalidFormatException {
		Select dropdown = new Select(id);
		dropdown.selectByVisibleText(text);
	}
	
	//To fill text box
	public void sendkey(WebElement id, String text) throws IOException, InvalidFormatException {
		id.clear();
		id.sendKeys(text);
	}
	
	public void verifyAlert(String expected){
		Alert alert=driver.switchTo().alert();
		String actual = alert.getText();
//		System.out.println(actual);
		String part1 = expected.replaceAll("\\s+","");
		String part = actual.replaceAll("\\s+","");
		Assert.assertEquals(part.trim(),part1.trim());
		alert.accept();
	}
	
	//Go to URL
	public void goToURL(String sURL){
		driver.get(sURL);
		System.out.println("opening url="+sURL);
	}
	
	//Close browser
	public void closeBrowser(){
		driver.quit();
		System.out.println("close the browser ");
	}
	
	public void verifyText(String expected){
		 try{
			 driver.findElement(By.xpath("//*[contains(text(),'"+ expected.trim() +"')]"));
			 System.out.println("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" verified");
			// return true;
		 }
		 catch(NoSuchElementException e){
			 System.out.println("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
			 Assert.fail("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
		 }
		 
	}
	
	
	public void verify(String expect, String actual){
//		String parentWindowHandler = driver.getWindowHandle();
//		String subWindowHandler = null;		
//		driver.switchTo().window(subWindowHandler); 
		Assert.assertEquals(expect,actual);
//		driver.switchTo().window(parentWindowHandler);
	}
}
