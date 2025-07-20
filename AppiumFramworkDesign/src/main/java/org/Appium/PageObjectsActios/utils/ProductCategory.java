package org.Appium.PageObjectsActios.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCategory extends AndroidActions {
	
	AndroidDriver driver;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private  List<WebElement> addcart;
	
//	Click Cart
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement ClickCart;
	public ProductCategory(AndroidDriver driver) 
	{
		super(driver);
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	public void AddItemToCartByIndex(int index)
	{
		if (addcart.size() > 0) {
			addcart.get(0).click();
		} else {
		    System.out.println("Product list is empty");
		}
	}
	public CartPage ClickCart() throws InterruptedException
	{
		ClickCart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}

	

}
