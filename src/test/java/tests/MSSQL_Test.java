package tests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import common.ScreenshotURL;
import db.DBconnect;


public class MSSQL_Test {
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(MSSQL_Test.class);
	
	
	static String className = MSSQL_Test.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";
	
	
	@Test() 
	public void SalesTerritoryCount_Test() throws ClassNotFoundException
	{
			
		   DBconnect db = new DBconnect();
		   HashMap<String, Integer> hmap = db.GetSalesTerritoryCount();
		   int canadiancount = hmap.get("Canada");
		   Assert.assertEquals(canadiancount, 149, "Failed to assert Canadian sales territory count.");
		   
		   softAssert.assertAll();
	}


}
