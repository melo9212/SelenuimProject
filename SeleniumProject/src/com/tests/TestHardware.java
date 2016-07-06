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

public class TestHardware {
	private WebDriver driver;
	public CommonMethods cm;
	public HardwarePage hardware;
	
	@BeforeMethod
	public void setUp() throws InvalidFormatException, IOException{
		cm=new CommonMethods(driver);
		Properties prop=cm.prop("config.properties");
		String browser = prop.getProperty("BrowserType");
		String url 	= prop.getProperty("URL");		
		driver=cm.openBrowser(browser);
		cm.goToURL(url);
		hardware = new HardwarePage(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		cm.closeBrowser();		
	}
	
	@Test
	public void HardwarePagelink1(){
		hardware.clickCdr();
	}
	
	@Test
	public void HardwarePagelink2(){
		hardware.clickGraphic();
	}
	
	@Test
	public void HardwarePagelink3(){
		hardware.clickKeyboard();
	}
	
	@Test
	public void HardwarePagelink4(){
		hardware.clickMemory();
	}
	
	@Test
	public void HardwarePagelink5(){
		hardware.clickMice();
	}
	
	@Test
	public void HardwarePagelink6(){
		hardware.clickMonitor();
	}
	
	@Test
	public void HardwarePagelink7(){
		hardware.clickPrinter();
	}
	
	@Test
	public void HardwarePagelink8(){
		hardware.clickSpeaker();
	}
}
