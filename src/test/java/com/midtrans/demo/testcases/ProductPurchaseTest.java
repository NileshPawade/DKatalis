package com.midtrans.demo.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.midtrans.demo.BaseClass.TestBase;
import com.midtrans.demo.pages.CardDetails;
import com.midtrans.demo.pages.CheckOutPage;
import com.midtrans.demo.pages.CheckOutPage.OrderDetails;
import com.midtrans.demo.reports.LoggerHelper;
import com.midtrans.demo.pages.ProductPage;
import com.midtrans.demo.utilities.CommonUtlities;

public class ProductPurchaseTest extends TestBase {

	public ProductPurchaseTest() {
		super();
	}

	ProductPage productPage;
	CheckOutPage checkOutPage;
	OrderDetails orderDetails;
	CardDetails cardDetails;
	private final static Logger log=LoggerHelper.getLogger(ProductPurchaseTest.class);

	@BeforeTest
	public void setup() {
		initialisation();
		productPage = new ProductPage();
		checkOutPage = new CheckOutPage();
		orderDetails = new OrderDetails();
		cardDetails=new CardDetails();

	}

	@Test(dataProvider = "addCustomerDetails")
	public void ProductPurchaseSuccessFlowTest(String customerName, String email, String phone, String city,
			String address, String postalCode,String paymentMethod,String cardNumber,String expiryDate,String CVV,String OTP) {
		
		Assert.assertEquals(productPage.getBuyNowButton().isEnabled(), true);

		productPage.getBuyNowButton().click();
		
		log.info(productPage.getBuyNowButton().getText()+"is clicked");
		
		checkOutPage.AddCustomerDetails(customerName, email, phone, city, address, postalCode);

		checkOutPage.getCheckOutButton().click();
		
		log.info(checkOutPage.getCheckOutButton().getText()+"Button clicked");

		/*
		 * if(status.equalsIgnoreCase("pass")) {
		 * Assert.assertEquals(orderDetails.getOrderModal().isDisplayed(), true);
		 * orderDetails.getCancelOrder().click(); } else {
		 * Assert.assertEquals(productPage.getInValidCheckOutMsg().isDisplayed(), true);
		 * }
		 */

		driver.switchTo().frame(0);
		
		log.info("Switched to Frame");

		Assert.assertEquals(orderDetails.getPillowPrice().isDisplayed(), true);
		
		log.info("Pillow price is displayed");

		Assert.assertEquals(CommonUtlities.convertElementToNumber(orderDetails.getPillowPrice()), 20000);
		
		log.info("Pillow price is as expected"+CommonUtlities.convertElementToNumber(orderDetails.getPillowPrice()));

		Assert.assertEquals(orderDetails.getOrderItemName().getText().trim(), "Midtrans Pillow");
		
		log.info("Product Name is as expected"+orderDetails.getOrderItemName().getText().trim());

		Assert.assertEquals(CommonUtlities.convertElementToNumber(orderDetails.getOrderAmount()), 20000);
		
		log.info("Order Amount is as expected"+CommonUtlities.convertElementToNumber(orderDetails.getOrderAmount()));

		orderDetails.getShippingDetails().click();
		
		log.info("Clicked on Shipping Detail");

		Assert.assertEquals(orderDetails.getShippingCustomerName().getText().trim(), customerName);
		
		log.info("Customer name is as expected"+orderDetails.getShippingCustomerName().getText().trim());

		Assert.assertEquals(CommonUtlities.convertElementToNumber(orderDetails.getShippingPhone()),
				Long.parseLong(phone));
		
		log.info("phone number is as expected"+CommonUtlities.convertElementToNumber(orderDetails.getShippingPhone()));

		Assert.assertEquals(orderDetails.getShippingEmail().getText().trim(), email);
		
		log.info("Email is as expected"+orderDetails.getShippingEmail().getText().trim());

		Assert.assertEquals(orderDetails.getShippingAddress().getText(), address + " " + city + " " + postalCode);
		
		log.info("Shpping address is combination of address city and postal code"+orderDetails.getShippingAddress().getText());

		orderDetails.getContinueButton().click();
		
		log.info("clicked on "+orderDetails.getContinueButton().getText());
		

		//Assert.assertEquals(CommonUtlities.checkAvailabilityOfElementInList(orderDetails.getPaymentMethodsList(),paymentMethod),true);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(orderDetails.getPaymentMethodsList()));
		
		log.info("All payment Methods availability"+ExpectedConditions.visibilityOfAllElements(orderDetails.getPaymentMethodsList()));
		
		CommonUtlities.selectElementWithTextFromList(orderDetails.getPaymentMethodsList(),paymentMethod);
		
		log.info(paymentMethod+"Payment method selected");
		
		Assert.assertEquals(CommonUtlities.convertElementToNumber(cardDetails.getAmount()),19000);
		
		log.info("Amount after applying promo code"+CommonUtlities.convertElementToNumber(cardDetails.getAmount()));
		
		wait.until(ExpectedConditions.visibilityOf(cardDetails.getCardNumber()));
		
		
		cardDetails.getCardNumber().sendKeys(cardNumber);
		
		log.info("Card Number is :"+cardNumber+"is entered");
		
		
		cardDetails.getExpiryDate().sendKeys(expiryDate);
		
		log.info("Expiry Date is :"+expiryDate+"is entered");
		
		
		cardDetails.getcVV().sendKeys(CVV);
		
		log.info("CVV Number is :"+CVV+"is entered");
		
		
		CommonUtlities.scrollToElement(cardDetails.getEmail());
		
		log.info("Scrolled to Email");
		
		/*Assert.assertEquals(cardDetails.getEmail().getText(), email);
		
		CommonUtlities.scrollToElement(cardDetails.getPhone());
		
		Assert.assertEquals(cardDetails.getPhone().getAttribute("placeholder").replace("+",""),phone);*/
		
		CommonUtlities.scrollToElement(cardDetails.getPayNow());
		
		log.info("SCrolled to PayNow");
		
		cardDetails.getPayNow().click();
		
		log.info("Clicked On Pay Now");

	
		
		
	}

	@AfterTest
	public void tearDown() {
		
		driver.close();
		
		log.info("Driver instance closed");
	}

	@DataProvider(name = "addCustomerDetails")
	public String[][] addBuilderData() throws IOException {
		log.info("Reading data from Sheet CustomerAddress");
		String[][] arrayObject = CommonUtlities.getExcelData(
				
				System.getProperty("user.dir") + "/src/main/resources/Mindtrans.xls",
				"CustomerAddress");
		return arrayObject;
	}

}
