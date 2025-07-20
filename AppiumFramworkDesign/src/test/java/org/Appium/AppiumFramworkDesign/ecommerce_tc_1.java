package org.Appium.AppiumFramworkDesign;

import org.Appium.PageObjectsActios.FormPage;
import org.Appium.PageObjectsActios.utils.CartPage;
import org.Appium.PageObjectsActios.utils.ProductCategory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class ecommerce_tc_1 extends BaseTest{

	@Test(dataProvider = "getData")
	public void FillForm(String name,String gender,String country) throws InterruptedException
	{
//		Create The Object From "FormPage" = Driver == Androiddriver
		formpage =new FormPage(driver);
//		Enter The UserName
		formpage.setName(name);
//		Select gender 
		formpage.Setgender(gender);
//		Select Country
		formpage.SetCountrySelection(country);
//		Submit Button
		ProductCategory product =formpage.Submitshop();
		
//		Use function AddItemToCartByIndex to add item to cart 
		product.AddItemToCartByIndex(0);
		product.AddItemToCartByIndex(0);
		
		CartPage Cart = product.ClickCart();
		
	}
	@BeforeMethod
	public void PreSetup()
	{
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent"," com.androidsample.generalstore/.MainActivity"));

	}
	@DataProvider
	public Object[][] getData()
	{
		 return new Object[][] { {"Zakaria rafeek","Female","Argentina"},{"Mohamed","Male","Argentina"} };
	}
}
