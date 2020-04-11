package com.pagemethod.caller;

import org.openqa.selenium.WebDriver;

import com.amazonPages.HomePage;

public class HomePageMethodCaller {
	WebDriver driver;
	public HomePageMethodCaller(WebDriver driver) {
		this.driver=driver;
	}
	public void homePageMethodCaller() throws Exception {
		HomePage lp = new HomePage(driver);
		lp.searchWristWatches();
		lp.selectAnalogueDisplay();
		lp.selectBandMaterial();
		lp.selectBrandTitan();
		lp.select25PercentOrMoreDiscount();
		lp.printNthProduct(10);
	}
}
