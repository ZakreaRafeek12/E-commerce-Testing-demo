package org.Appium.AppiumFramworkDesign;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.Appium.PageObjectsActios.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	boolean canScrollMore;
	
	public FormPage formpage;
	public AndroidDriver driver;
	@BeforeClass
	public void Appiumtest() throws MalformedURLException, URISyntaxException
	{
//		Start automation on Android Device 
		UiAutomator2Options options= new  UiAutomator2Options();
//		this is Device Name on Amlator 
		options.setDeviceName("AutoAndroid");
//		this is path app
//		options.setApp("C:\\Users\\zakre\\eclipse-workspace\\Appiumproject\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\zakre\\eclipse-workspace\\AppiumFramworkDesign\\src\\test\\java\\Resources\\General-Store.apk");
//		open  session in  Appium 
	
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formpage = new FormPage(driver);
		 
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}

}
