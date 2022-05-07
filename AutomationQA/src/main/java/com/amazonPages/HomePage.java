package com.amazonPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	public void searchWristWatches() throws Exception{
		WebElement seacrhBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		seacrhBox.sendKeys("Wrist Watches");
		driver.findElement(By.xpath("//input[@class='nav-input'][@value='Go']")).click();
		Thread.sleep(500);
	}
	public void selectAnalogueDisplay() throws Exception{
		driver.findElement(By.xpath("//li[@aria-label='Analogue']/span/a/div/label/input/following-sibling::i")).click();
		Thread.sleep(500);
	}
	public void selectBandMaterial() throws Exception{
		driver.findElement(By.xpath("//li[@aria-label='Leather']/span/a/div/label/input/following-sibling::i")).click();
		Thread.sleep(500);
	}
	public void selectBrandTitan() throws Exception{
		driver.findElement(By.xpath("//span[text()='See more']")).click();
		driver.findElement(By.xpath("//li[@aria-label='Titan']/span/a/div/label/input/following-sibling::i")).click();
		Thread.sleep(500);
	}
	public void select25PercentOrMoreDiscount() throws Exception{
		driver.findElement(By.xpath("//li[@id='p_n_pct-off-with-tax/2665400031']/span/a")).click();
		Thread.sleep(500);
	}
	public List<String> getProductsNamesList() {
		ArrayList<String> listProductName = new ArrayList<String>();
		List<WebElement> allProducts = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		System.out.println(allProducts.size());
		for(WebElement element:allProducts) {
			listProductName.add(element.getText());
		}
		System.out.println(listProductName);
		return listProductName;
	}
	public List<String> getProductsPricesList() {
		ArrayList<String> listProductPrices = new ArrayList<String>();
		List<WebElement> allProductPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println(allProductPrices.size());
		for(WebElement element:allProductPrices) {
			listProductPrices.add(element.getText());
		}
		System.out.println(listProductPrices);
		return listProductPrices;
	}

	public void printNthProduct(int n) throws Exception{
		List<WebElement> allProducts = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		String nthProductName = allProducts.get(n-1).getText();
		System.out.println(n+"th Product Name is: "+nthProductName);
	}
}
