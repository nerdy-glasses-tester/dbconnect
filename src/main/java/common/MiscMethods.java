package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class MiscMethods extends TestBase{
		
		public static ArrayList<Integer> sortDescending(ArrayList<Integer> arr){
		    Comparator<Integer> c = Collections.reverseOrder();
		    Collections.sort(arr,c);
		    return arr;
		  }


		public static ArrayList<Integer> sortAscending(ArrayList<Integer> arr){   
		    Collections.sort(arr);
		    return arr;
		  }
		
	    public static String returnsStringforIntegerArrayList(ArrayList<Integer> arr) {
	    		//String listString = arr.stream().map(Object::toString).collect(Collectors.joining(", ")); //This needs Java 1.8
	    		String listString = arr.toString().replaceAll(",","");
	    		return listString;
	    }

		
	    public static boolean isElementPresent(WebDriver webdriver, By selector) {
	        webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	        boolean returnVal = true;
	        try{
	            webdriver.findElement(selector);
	        } catch (NoSuchElementException e){
	            returnVal = false;
	        } finally {
	            webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        }
	        return returnVal;
	    }

	    
	    public static void swipeUp(AppiumDriver<?> appiumDriver) {
	        Dimension size = appiumDriver.manage().window().getSize();
	        int starty = (int) (size.height * 0.2);
	        int endy = (int) (size.height * 0.8);
	        int startx = size.width / 2;
	        new TouchAction(appiumDriver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(startx, endy)).release().perform();

	    }

	    public static void swipeDown(AppiumDriver<?> appiumDriver) {
	        Dimension size = appiumDriver.manage().window().getSize();
	        int starty = (int) (size.height * 0.8);
	        int endy = (int) (size.height * 0.2);
	        int startx = size.width / 2;
	        new TouchAction(appiumDriver).press(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy)).release().perform();

	    }
}
