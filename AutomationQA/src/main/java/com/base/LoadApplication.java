package com.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class LoadApplication{
	WebDriver driver;
	public LoadApplication(WebDriver driver) {
		this.driver = driver;
	}
	public void loadUrl() throws Exception{
		LoadProperties lp = new LoadProperties();
		Properties prop = lp.loadProperties();
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
