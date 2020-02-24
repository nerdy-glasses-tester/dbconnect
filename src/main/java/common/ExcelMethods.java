package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.nio.file.Paths;


public class ExcelMethods {

	//***********************************************************//
	//***                                  			         ***//
	//*** Created by Angela Tong APR 2018                     ***//
	//*** This piece of code got some help ***//
	//***********************************************************//
	
	//Works with TestData Excel spreadsheet.
	
	public static final String basePath = System.getProperty("user.dir");
	//public static final String basePath = Paths.get(".").toAbsolutePath().normalize().toString();
	public static final Logger log = LogManager.getLogger(ExcelMethods.class);
    //For Mac -comment out if using for windows
	public static final String FILE_NAME = basePath+"/testdata/TestData.xlsx";
	public static final String MOBILE_FILE_NAME = basePath+"/testdata/MobileTestData.xlsx";
    //For Windows -comment out if using for mac
    //private static final String FILE_NAME = "C:\\EclipseProjects\\dbconnect\\testdata\\TestData.xlsx";
    
	// Read and Provide value to Data Provider
    // Make sure the name of the test is on the tab of the excel sheet and make sure there are no leading and trailing spaces in the name or get nullpointer
    public static Object[][] getDataFromExcelTestData(String testName) throws Exception {
	String[][] arrayExcelData = null;
	FileInputStream fs = null;
	Workbook wb = null;
	try {
	    FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	    DataFormatter objDefaultFormat = new DataFormatter();
		wb = WorkbookFactory.create(excelFile);

		Sheet sh = wb.getSheet(testName);
		int totalNoOfCols = sh.getRow(0).getLastCellNum();
		int totalNoOfRows = sh.getLastRowNum() + 1; //including header
		arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
		for (int i = 1; i < totalNoOfRows; i++) { 
			Row row = sh.getRow(i);
			for (int j = 0; j < totalNoOfCols; j++) {
				Cell cellValue = row.getCell(j);
				String cellValueStr = objDefaultFormat.formatCellValue(cellValue);
				arrayExcelData[i - 1][j] = cellValueStr;
			}
		}

	
	} catch (Exception exp) {
		throw exp;
	} finally{
		try {
			if (fs != null) {
				fs.close();
			}
			if(wb != null){
				wb.close();
			}
		} catch (IOException ioExp) {
			log.error("Exception closing...", ioExp);
			}
		}
		return arrayExcelData;
	}
    
 
    public static Object[][] getMobileDataFromExcelTestData(String testName) throws Exception {
    	String[][] arrayExcelData = null;
    	FileInputStream fs = null;
    	Workbook wb = null;
    	try {
    	    FileInputStream excelFile = new FileInputStream(new File(MOBILE_FILE_NAME));
    	    DataFormatter objDefaultFormat = new DataFormatter();
    		wb = WorkbookFactory.create(excelFile);

    		Sheet sh = wb.getSheet(testName);
    		int totalNoOfCols = sh.getRow(0).getLastCellNum();
    		int totalNoOfRows = sh.getLastRowNum() + 1; //including header
    		arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
    		for (int i = 1; i < totalNoOfRows; i++) { 
    			Row row = sh.getRow(i);
    			for (int j = 0; j < totalNoOfCols; j++) {
    				Cell cellValue = row.getCell(j);
    				String cellValueStr = objDefaultFormat.formatCellValue(cellValue);
    				arrayExcelData[i - 1][j] = cellValueStr;
    			}
    		}

    	
    	} catch (Exception exp) {
    		throw exp;
    	} finally{
    		try {
    			if (fs != null) {
    				fs.close();
    			}
    			if(wb != null){
    				wb.close();
    			}
    		} catch (IOException ioExp) {
    			log.error("Exception closing...", ioExp);
    			}
    		}
    		return arrayExcelData;
    	}
        

	
}