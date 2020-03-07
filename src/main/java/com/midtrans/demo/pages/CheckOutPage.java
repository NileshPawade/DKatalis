package com.midtrans.demo.pages;

import java.util.List;

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
		public static class OrderDetails
		{
			
			public OrderDetails() {
			super();
			PageFactory.initElements(driver, this);
			}
			
			@FindBy(xpath="//*[@class=\"app-container\"]")
			private WebElement orderContainer;
			
			@FindBy(css="#snap-midtrans")
			private WebElement cancelOrder;
			
			@FindBy(xpath="//*[@class=\"text-amount-amount\"]")
			private WebElement pillowPrice;
			
			@FindBy(xpath="(//*[@class='text-actionable'])[1]")
			private WebElement orderDetails;
			
			@FindBy(xpath="//*[@class=\"item-name\"]")
			private WebElement orderItemName;
			
			@FindBy(xpath="//*[@class=\"table-amount text-body\"]")
			private WebElement orderAmount;
			
			@FindBy(xpath="(//*[@class='text-actionable'])[2]")
			private WebElement shippingDetails;
			
			@FindBy(xpath="(//*[@class=\"text-body\"])[1]")
			private WebElement ShippingCustomerName;
			
			@FindBy(xpath="(//*[@class=\"text-body\"])[4]")
			private WebElement shippingAddress;
			
			@FindBy(xpath="(//*[@class=\"text-body\"])[2]")
			private WebElement ShippingPhone;
			
			@FindBy(xpath="(//*[@class=\"text-body\"])[3]")
			private WebElement ShippingEmail;
			
			@FindBy(xpath="//*[@class=\"button-main-content\"]")
			private WebElement continueButton;
			
			@FindBy(xpath="//*[@class=\"list-title text-actionable-bold\"]")
			private List<WebElement> paymentMethodsList;
			
		
			public List<WebElement> getPaymentMethodsList() {
				return paymentMethodsList;
			}


			public WebElement getCancelOrder() {
				return cancelOrder;
			}


			public WebElement getPillowPrice() {
				return pillowPrice;
			}


			public WebElement getOrderDetails() {
				return orderDetails;
			}


			public WebElement getOrderItemName() {
				return orderItemName;
			}


			public WebElement getOrderAmount() {
				return orderAmount;
			}


			public WebElement getShippingDetails() {
				return shippingDetails;
			}


			public WebElement getShippingCustomerName() {
				return ShippingCustomerName;
			}


			public WebElement getShippingAddress() {
				return shippingAddress;
			}


			public WebElement getShippingPhone() {
				return ShippingPhone;
			}


			public WebElement getShippingEmail() {
				return ShippingEmail;
			}


			public WebElement getContinueButton() {
				return continueButton;
			}


			public WebElement getOrderContainer() {
				return orderContainer;
			}
		
		}

}
