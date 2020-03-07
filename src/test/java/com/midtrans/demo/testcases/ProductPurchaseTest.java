package com.midtrans.demo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.midtrans.demo.BaseClass.TestBase;
import com.midtrans.demo.pages.CheckOutPage;
import com.midtrans.demo.pages.ProductPage;

public class ProductPurchaseTest extends TestBase {
	
	public ProductPurchaseTest() {
		super();
	}
	ProductPage productPage;
	CheckOutPage checkOutPage;
	
	@BeforeTest
	public void setup()
	{
		initialisation();
		productPage=new ProductPage();
		checkOutPage=new CheckOutPage();
		
	}
	
	@Test
	public void ProductPurchaseSuccessFlowTest()
	{
		Assert.assertEquals(productPage.getBuyNowButton().isEnabled(), true);
		productPage.getBuyNowButton().click();
		
		checkOutPage.getCustomerName().clear();
		
		checkOutPage.getCustomerName().sendKeys("Nilesh");
		
		checkOutPage.getCustomerEmail().clear();
		
		checkOutPage.getCustomerEmail().sendKeys("abc@gmail.com");
		
		checkOutPage.getCustomerPhoneNumber().clear();
		
		checkOutPage.getCustomerPhoneNumber().sendKeys("123434234234");
		
		checkOutPage.getCustomerCity().clear();
		
		checkOutPage.getCustomerCity().sendKeys("Pune");
		
		checkOutPage.getCustomerAddress().clear();
		
		checkOutPage.getCustomerAddress().sendKeys("Maharashtra,India");
		
		checkOutPage.getCustomerPostalCode().clear();
		
		checkOutPage.getCustomerPostalCode().sendKeys("3442232");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
