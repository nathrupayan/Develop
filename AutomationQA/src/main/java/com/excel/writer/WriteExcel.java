package com.excel.writer;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.amazonPages.HomePage;

public class WriteExcel {
	WebDriver driver;
	public String[] columns = {"Name of the Product", "Price of the Product"};
	public WriteExcel(WebDriver driver) {
		this.driver = driver;
	}
	public void writeDataIntoExcel() throws Exception{
		HomePage hp =new HomePage(driver);
		List<String> productsNamesList = hp.getProductsNamesList();
		List<String> productsPricesList = hp.getProductsPricesList();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Product");
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(0);

		for(int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum=1;
		int j = 0;
		for(String productName:productsNamesList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(productName);
			row.createCell(1).setCellValue(productsPricesList.get(j));
			j++;
		}
		for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
		FileOutputStream fileOut = new FileOutputStream("ProductDetails.xlsx");
		workbook.write(fileOut);
		fileOut.close();
	}
}

