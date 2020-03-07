package com.midtrans.demo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.midtrans.demo.BaseClass.TestBase;
import com.midtrans.demo.pages.CheckOutPage;
import com.midtrans.demo.pages.ProductPage;
import com.midtrans.demo.utilities.CommonUtlities;

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
	
	@Test(dataProvider="addCustomerDetails")
	public void ProductPurchaseSuccessFlowTest(String customerName,String email,String phone,String city,String address,String postalCode)
	{
		Assert.assertEquals(productPage.getBuyNowButton().isEnabled(), true);
		
		productPage.getBuyNowButton().click();
		
		checkOutPage.AddCustomerDetails(customerName, email, phone, city, address, postalCode);
		
		/*
		 * checkOutPage.getCustomerName().clear();
		 * 
		 * checkOutPage.getCustomerName().sendKeys("Nilesh");
		 * 
		 * checkOutPage.getCustomerEmail().clear();
		 * 
		 * checkOutPage.getCustomerEmail().sendKeys("abc@gmail.com");
		 * 
		 * checkOutPage.getCustomerPhoneNumber().clear();
		 * 
		 * checkOutPage.getCustomerPhoneNumber().sendKeys("123434234234");
		 * 
		 * checkOutPage.getCustomerCity().clear();
		 * 
		 * checkOutPage.getCustomerCity().sendKeys("Pune");
		 * 
		 * checkOutPage.getCustomerAddress().clear();
		 * 
		 * checkOutPage.getCustomerAddress().sendKeys("Maharashtra,India");
		 * 
		 * checkOutPage.getCustomerPostalCode().clear();
		 * 
		 * checkOutPage.getCustomerPostalCode().sendKeys("3442232");
		 */
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider(name = "addCustomerDetails")
	public String[][] addBuilderData() throws IOException {
		String[][] arrayObject = CommonUtlities.getExcelData(
				System.getProperty("user.dir") + "/src/main/java/com/midtrans/demo/resources/Mindtrans.xls", "CustomerAddress");
		return arrayObject;
	}

}
