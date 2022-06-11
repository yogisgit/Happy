package com.happy.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtility {
public Object[][] getData() throws IOException {
		
		ArrayList<String> trk = new ArrayList();
		ArrayList<Integer> form = new ArrayList();
		String path = System.getProperty("user.dir")+"/src/main/java/com/happy/testData/Book1.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();
		
		for(int r=0;r<=rows;r++)
		{	
			XSSFRow row=sheet.getRow(r); //0
			
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING: 
					trk.add(cell.getStringCellValue()); 
					break;
				case NUMERIC: 
					form.add((int)(cell.getNumericCellValue()));
					break;
				}
			}
		}
		
		Random random = new Random();
		int x = random.nextInt(4);
		
		Object[][] obj = new Object[1][2];
		
		int size = trk.size();
		for(int i=0; i<size; i++) {
			if(i==x) {
				obj[0][0]=trk.get(i);
				obj[0][1]=form.get(i);
			}
		}
		return obj;
	}
	
}
