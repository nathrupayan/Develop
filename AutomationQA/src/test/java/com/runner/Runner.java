package com.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.InitDriver;
import com.base.LoadApplication;
import com.excel.writer.WriteExcel;
import com.pagemethod.caller.HomePageMethodCaller;

public class Runner {
	WebDriver driver;
	@BeforeTest
	public void startApplication() throws Exception
	{
		InitDriver initDriver = new InitDriver();
		driver = initDriver.init("chrome");
	}
	@Test
	public void runMyTest() throws Exception{
		LoadApplication la = new LoadApplication(driver);
		la.loadUrl();
		HomePageMethodCaller hpmc = new HomePageMethodCaller(driver);
		hpmc.homePageMethodCaller();
		WriteExcel we = new WriteExcel(driver);
		we.writeDataIntoExcel();
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
}