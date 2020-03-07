package com.midtrans.demo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.midtrans.demo.BaseClass.TestBase;
import com.midtrans.demo.pages.CheckOutPage;
import com.midtrans.demo.pages.CheckOutPage.OrderDetails;
import com.midtrans.demo.pages.ProductPage;
import com.midtrans.demo.utilities.CommonUtlities;

public class ProductPurchaseTest extends TestBase {
	
	public ProductPurchaseTest() {
		super();
	}
	ProductPage productPage;
	CheckOutPage checkOutPage;
	OrderDetails orderDetails;
	
	@BeforeTest
	public void setup()
	{
		initialisation();
		productPage=new ProductPage();
		checkOutPage=new CheckOutPage();
		orderDetails=new OrderDetails();
		
	}
	
	@Test(dataProvider="addCustomerDetails")
	public void ProductPurchaseSuccessFlowTest(String customerName,String email,String phone,String city,String address,String postalCode)
	{
		Assert.assertEquals(productPage.getBuyNowButton().isEnabled(), true);
		
		productPage.getBuyNowButton().click();
		
		checkOutPage.AddCustomerDetails(customerName, email, phone, city, address, postalCode);
		
checkOutPage.getCheckOutButton().click();
		
		/*if(status.equalsIgnoreCase("pass"))
			{
			 Assert.assertEquals(orderDetails.getOrderModal().isDisplayed(), true);
			 orderDetails.getCancelOrder().click();
			}
		else {
			Assert.assertEquals(productPage.getInValidCheckOutMsg().isDisplayed(), true);
		}*/
		
		driver.switchTo().frame(0);

		Assert.assertEquals(orderDetails.getPillowPrice().isDisplayed(), true);
		
		Assert.assertEquals(CommonUtlities.convertElementToNumber(orderDetails.getPillowPrice()),20000);
		
		Assert.assertEquals(orderDetails.getOrderItemName().getText().trim(), "Midtrans Pillow");
		
		Assert.assertEquals(CommonUtlities.convertElementToNumber(orderDetails.getOrderAmount()), 20000);
		
		
		orderDetails.getShippingDetails().click();
		
		Assert.assertEquals(orderDetails.getShippingCustomerName().getText().trim(), customerName);
		
		Assert.assertEquals(CommonUtlities.convertElementToNumber(orderDetails.getShippingPhone()), Long.parseLong(phone));
		
		Assert.assertEquals(orderDetails.getShippingEmail().getText().trim(), email);
		
		Assert.assertEquals(orderDetails.getShippingAddress().getText(), address+" "+city+" "+postalCode);
		
		orderDetails.getContinueButton().click();
		
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
