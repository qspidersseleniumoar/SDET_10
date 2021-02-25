package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

 

/**
 * 
 * @author Deepak
 *
 */
public class ExcelUtility {
	public String getExcelData(String sheetName , int rowNum , int colNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		wb.close();
		return row.getCell(colNum).getStringCellValue();		
	}
	
	
	
	public int getRowCount(String sheetName)throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);	
		return sh.getLastRowNum();			
	}
	public void setExcelData(String shettName , int rowNum , int colNum ,String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shettName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./Data/testData.xlsx");
				wb.write(fos);
		wb.close();
	}
	
	
	
	
}









