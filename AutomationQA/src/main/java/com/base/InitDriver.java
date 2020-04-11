package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitDriver {
	WebDriver driver;
	public WebDriver init(String browser) {
		try {
			String localDir = System.getProperty("user.dir");
			if(browser.equals("chrome")) {
				String relativeChromeDriverPath = localDir + "\\WebDrivers\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", relativeChromeDriverPath);
				driver= new ChromeDriver();
			}
			else if(browser.equals("mozilla")) {
				String relativeFirefoxDriverPath = localDir + "\\WebDrivers\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", relativeFirefoxDriverPath);
				driver= new FirefoxDriver();
			}
			else if(browser.equals("ie")) {
				String relativeIEDriverPath = localDir + "\\WebDrivers\\iexploredriver.exe";
				System.setProperty("webdriver.ie.driver", relativeIEDriverPath);
				driver= new InternetExplorerDriver();
			}
			else if(browser.equals("safari")) {
				String relativeSafariDriverPath = localDir + "\\WebDrivers\\safaridriver.exe";
				System.setProperty("webdriver.safari.driver", relativeSafariDriverPath);
				driver= new InternetExplorerDriver();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
