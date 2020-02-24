package tests;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import db.DBconnect2;

public class Mongo_Test {
		
		static SoftAssert softAssert = new SoftAssert();
		final static Logger log = LogManager.getLogger(MSSQL_Test.class);
		
		
		static String className = MSSQL_Test.class.getSimpleName();
	 	static Date date1= new Date();
	 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
	 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
		static String foldername = className+timestamp;
		static String errorname = "";
		
		
		@Test() 
		public void TomatoesorBaconRecipes_Test() throws ClassNotFoundException
		{
				
			   DBconnect2 db = new DBconnect2();
			   HashMap<String, String> hmap = db.GetTomatoesOrBaconRecipes();
			   HashMap<String, String> expected = new HashMap<String, String>();
			   expected.put("dishname", "Sphaghetti");
			   expected.put("dishname", "Brussels Sprouts");
			   expected.put("dishname", "Mini Tacos");
			   Assert.assertEquals(hmap.get("dishname"), expected.get("dishname"), "Failed to assert tomatoes or bacon recipes.");
			   
			   softAssert.assertAll();
		}


}
