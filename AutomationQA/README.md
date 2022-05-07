#Product Search Automation

##About the framework

The framework is written in Java 1.8. It uses Maven as built tool and TestNG 6.8 as the runner. The framework uses selenium 3.4 and has been tested with ChromeDriver
2.41 on Google Chrome web browser version 79.

###Java Packages and Classes

Following are the package structures:
	
	src/main/java
		1. com.base
			a. InitDriver.java: InitDriver.init(String) takes in the name of the browser as parameter and initializes the web browser Driver.
			b. LoadProperties.java: LoadProperties.loadProperties() load environment.properties file that has the url of Amazon.in.
			c. LoadApplication.java: LoadApplication.loadUrl() loads the Amazon.in url in the web browser.
		2. com.excel.writer
			a. WriteExcel.java: WriteExcel.writeDataIntoExcel() writes the Product Name and Product Price in a .xlsx file format.
		3. com.amazonPages: This package is created to contain all the page objects of a particular page in the website. 
		The class also contains java methods for any action to be performed on the web objects.
		4. com.pagemethod.caller: This package has java class for each web page to call the methods inside the clasess of com.signzy.amazonPages.
	src/test/java
		1. com.runner
			a. Runner.java: This class is the single entry point to the framework. It uses TestNG annotaions @BeforeTest(initialize driver),
			@Test(launch browser, load url, search product, write to excel) and @AfterTest to close the browser.
			
The directories PropertiesStorage and WebDrivers are created to contain the .properties files and selenium web drivers respectively.
The framework uses relative path to these directories to the refer to these resources.

##How to download the libries

The framework is built using Maven. The pom.xml file has all the library dependencies that needs to be downloaded before running the automation.

##How to run the automation

com.runner.Runner.java is the entry point. Run this class file using TestNG in Eclipse. Please make sure TestNG eclipse plugin is installed.
