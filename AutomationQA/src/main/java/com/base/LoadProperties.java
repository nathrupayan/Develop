package com.base;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperties {

	public Properties loadProperties() throws Exception{
		Properties prop = new Properties();
		String localDir = System.getProperty("user.dir");
		String relativePath = localDir + "\\PropertiesStorage\\environment.properties";
		FileInputStream fis = new FileInputStream(relativePath);
		prop.load(fis);
		return prop;
	}
}
