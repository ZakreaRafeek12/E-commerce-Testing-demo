package org.Appium.PageObjectsActios.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	protected AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }
	public void LongPressAction(WebElement longPress)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		        "elementId",((RemoteWebElement) longPress).getId(),
		        "duration", 1500
		    ));
	}
	public void scrollDemoAction()
	{
		boolean canScrollMore;
		 do{ 
			   canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    	    "left", 100, "top", 100, "width", 200, "height", 200,
		    	    "direction", "down",
		    	    "percent", 3.0
		    	));
		   }
		   while(canScrollMore);
	}
	
	public void SwipDemoAction(WebElement ele,String direction)
	{
		( (JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	public void ScrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	
	public void DragDrop(WebElement ele,int X,int Y)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
	    	    "elementId", ((RemoteWebElement) ele).getId(),
	    	    "endX", X,
	    	    "endY", Y
	    	));
	}

}
