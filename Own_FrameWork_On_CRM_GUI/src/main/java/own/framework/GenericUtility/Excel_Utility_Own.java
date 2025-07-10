package own.framework.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility_Own {

	public String getDataFromExcel(String SheetName, int rowNum, int CelNum) throws Exception {
		FileInputStream fis = new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(rowNum).getCell(CelNum).getStringCellValue();
		return data;
	}

	public int getRowCount(String SheetName) throws Exception {
		FileInputStream fis = new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(SheetName).getLastRowNum();
		return rowcount;
	}

	public short getcellCount(String SheetName) throws Exception {
		FileInputStream fis = new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Row row = wb.getSheet(SheetName).getRow(0);
		return (row == null) ? 0 : row.getLastCellNum();
	}

	public void setDataIntoExcel(String SheetName, int rowNum, int CelNum, String data) throws Exception {
		FileInputStream fis = new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(SheetName).getRow(rowNum).createCell(CelNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./TestData/testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
	}
}