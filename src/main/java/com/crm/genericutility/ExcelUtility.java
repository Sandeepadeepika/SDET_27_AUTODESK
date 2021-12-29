package com.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



/**
 * its developed using Apache POi libraries,which used to handle microsoft Excel sheet
 * @author SANDEEP K S
 *
 */
public class ExcelUtility {
	/**
	 * its used read the data from excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		String data=row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * used get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable 
	 * @throws throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
		}
	public void setDataExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.createCell(cellNum); 
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/Testdata.xlsx");
		wb.write(fos);
		wb.close();
	}
}

	


