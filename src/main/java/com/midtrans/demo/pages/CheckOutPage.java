package com.midtrans.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midtrans.demo.BaseClass.TestBase;

public class CheckOutPage extends TestBase {
		
		public CheckOutPage() {
			super();
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css="input.text-right")
		private WebElement pillowPrice;
		
		@FindBy(css="tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
		private WebElement quantities;
		
		@FindBy(css="td.amount")
		private WebElement totalAmount;
		
		@FindBy(xpath="(//input[@type='text'])[1]")
		private WebElement customerName;
		
		@FindBy(xpath="//input[@type=\"email\"]")
		private WebElement customerEmail;
		
		@FindBy(xpath="(//input)[4]")
		private WebElement customerPhoneNumber;

		@FindBy(xpath="(//input)[5]")
		private WebElement customerCity;

		@FindBy(css="textarea")
		private WebElement customerAddress;
		
		@FindBy(xpath="(//input)[6]")
		private WebElement customerPostalCode;
		
		@FindBy(css="div.cart-checkout")
		private WebElement checkOutButton;
		
		@FindBy(css="div.cart-checkout-settings > img")
		private WebElement checkOutSettingButton;
		
		@FindBy(css="div.cancel-btn")
		private WebElement cancelButton;
		
		public WebElement getPillowPrice() {
			return pillowPrice;
		}

		public String getPillowPriceStringValue() {
			return pillowPrice.getAttribute("value");
		}
		
		
		public WebElement getQuantities() {
			return quantities;
		}


		public WebElement getTotalAmount() {
			return totalAmount;
		}



		public WebElement getCustomerName() {
			return customerName;
		}



		public WebElement getCustomerEmail() {
			return customerEmail;
		}



		public WebElement getCustomerPhoneNumber() {
			return customerPhoneNumber;
		}



		public WebElement getCustomerCity() {
			return customerCity;
		}

		
		public WebElement getCustomerAddress() {
			return customerAddress;
		}


		public WebElement getCustomerPostalCode() {
			return customerPostalCode;
		}



		public WebElement getCheckOutButton() {
			return checkOutButton;
		}



		public WebElement getCheckOutSettingButton() {
			return checkOutSettingButton;
		}



		public WebElement getCancelButton() {
			return cancelButton;
		}
		
		public void AddCustomerDetails(String customerName,String email,String phone,String city,String address,String postalCode)
		{
			getCustomerName().clear();
			
			getCustomerName().sendKeys(customerName);
			
			getCustomerEmail().clear();
			
			getCustomerEmail().sendKeys(email);
			
			getCustomerPhoneNumber().clear();
			
			getCustomerPhoneNumber().sendKeys(phone);
			
			getCustomerCity().clear();
			
			getCustomerCity().sendKeys(city);
			
			getCustomerAddress().clear();
			
			getCustomerAddress().sendKeys(address);
			
			getCustomerPostalCode().clear();
			
			getCustomerPostalCode().sendKeys(postalCode);
			
		}

}
