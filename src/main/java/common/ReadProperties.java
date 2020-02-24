package common;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ReadProperties {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	public static final String basePath = System.getProperty("user.dir");
	public static Properties webLocatorProp;
	public static Properties globalProp;
	public static Logger log= LogManager.getLogger(Class.class);
	
	public static void retrieveGlobalProperties()
	{
		
		try {
        globalProp=new Properties();
		FileInputStream in=new FileInputStream(basePath+"/src/test/resources/global.properties");
        //FileInputStream in=new FileInputStream("C:\\EclipseProjects\\XOME\\src\\test\\resources\\global.properties");
        
		globalProp.load(in);
		in.close();
		}
		catch (Exception e) {
			log.info("Can't read global properties file.");
			log.error("An exception occurred.", e.getMessage());
		}
	}
	
		
}