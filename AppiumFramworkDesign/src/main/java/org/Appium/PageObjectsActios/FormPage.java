package org.Appium.PageObjectsActios;

import org.Appium.PageObjectsActios.utils.AndroidActions;
import org.Appium.PageObjectsActios.utils.ProductCategory;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	AndroidDriver driver;

    public FormPage(AndroidDriver driver) 
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	
	
//	Enter The Name 
	@AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
	private WebElement namefield;
	
//	select gender female
	@AndroidFindBy(xpath ="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
//	Select genderMAle
	@AndroidFindBy(xpath ="//android.widget.RadioButton[@text='Male']")
	private WebElement MaleOption;
	
//	Select Section Countries
	@AndroidFindBy(xpath ="//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]" )
	private WebElement SectionCountry;
	
//	Press The button Login
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement PressButtonLogin;
	
	public void setName(String name)
	{
		namefield.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void Setgender(String gender)
	{
		if(gender.contains("Female"))
			femaleOption.click();
		else
			MaleOption.click();
	}
	
	
	public void SetCountrySelection(String NameCountry)
	{
		SectionCountry.click();
		ScrollToText(NameCountry);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\""+NameCountry+"\"]")).click();
	}
	
	public ProductCategory Submitshop()
	{
		PressButtonLogin.click();
		return new ProductCategory(driver);
	}
	

}
