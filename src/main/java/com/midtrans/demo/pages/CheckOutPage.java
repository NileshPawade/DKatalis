package com.midtrans.demo.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midtrans.demo.BaseClass.TestBase;
import com.midtrans.demo.reports.LoggerHelper;


public class CheckOutPage extends TestBase {

	public CheckOutPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	private final static Logger log=LoggerHelper.getLogger(CheckOutPage.class);

	@FindBy(css = "input.text-right")
	private WebElement pillowPrice;

	@FindBy(css = "tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
	private WebElement quantities;

	@FindBy(css = "td.amount")
	private WebElement totalAmount;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement customerName;

	@FindBy(xpath = "//input[@type=\"email\"]")
	private WebElement customerEmail;

	@FindBy(xpath = "(//input)[4]")
	private WebElement customerPhoneNumber;

	@FindBy(xpath = "(//input)[5]")
	private WebElement customerCity;

	@FindBy(css = "textarea")
	private WebElement customerAddress;

	@FindBy(xpath = "(//input)[6]")
	private WebElement customerPostalCode;

	@FindBy(css = "div.cart-checkout")
	private WebElement checkOutButton;

	@FindBy(css = "div.cart-checkout-settings > img")
	private WebElement checkOutSettingButton;

	@FindBy(css = "div.cancel-btn")
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

	public void AddCustomerDetails(String customerName, String email, String phone, String city, String address,
			String postalCode) {
		getCustomerName().clear();
		
		log.info("Customer Name field is Cleared");

		getCustomerName().sendKeys(customerName);
		
		log.info("Input is inserted as: "+customerName);

		getCustomerEmail().clear();
		log.info("Email field is Cleared");
		
		getCustomerEmail().sendKeys(email);
		
		log.info("Email is inserted as: "+email);


		getCustomerPhoneNumber().clear();
		log.info("Phone number field is Cleared");

		getCustomerPhoneNumber().sendKeys(phone);
		log.info("Phone number is inserted as: "+phone);


		getCustomerCity().clear();
		log.info("city number field is Cleared");

		

		getCustomerCity().sendKeys(city);
		log.info("City detail is inserted as: "+phone);


		getCustomerAddress().clear();
		log.info("Address field is Cleared");

		getCustomerAddress().sendKeys(address);
		log.info("Phone number is inserted as: "+address);


		getCustomerPostalCode().clear();
		log.info("Postal number field is Cleared");

		getCustomerPostalCode().sendKeys(postalCode);
		log.info("Postal number is inserted as: "+postalCode);


	}

	public static class OrderDetails {

		public OrderDetails() {
			super();
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//*[@class=\"app-container\"]")
		private WebElement orderContainer;

		@FindBy(css = "#snap-midtrans")
		private WebElement cancelOrder;

		@FindBy(xpath = "//*[@class=\"text-amount-amount\"]")
		private WebElement pillowPrice;

		@FindBy(xpath = "(//*[@class='text-actionable'])[1]")
		private WebElement orderDetails;

		@FindBy(xpath = "//*[@class=\"item-name\"]")
		private WebElement orderItemName;

		@FindBy(xpath = "//*[@class=\"table-amount text-body\"]")
		private WebElement orderAmount;

		@FindBy(xpath = "(//*[@class='text-actionable'])[2]")
		private WebElement shippingDetails;

		@FindBy(xpath = "(//*[@class=\"text-body\"])[1]")
		private WebElement ShippingCustomerName;

		@FindBy(xpath = "(//*[@class=\"text-body\"])[4]")
		private WebElement shippingAddress;

		@FindBy(xpath = "(//*[@class=\"text-body\"])[2]")
		private WebElement ShippingPhone;

		@FindBy(xpath = "(//*[@class=\"text-body\"])[3]")
		private WebElement ShippingEmail;

		@FindBy(xpath = "//*[@class=\"button-main-content\"]")
		private WebElement continueButton;

		@FindBy(xpath = "//*[@class=\"list-title text-actionable-bold\"]")
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

		public static class CheckOutSettingPage {

			public CheckOutSettingPage() {

				super();
				PageFactory.initElements(driver, this);
			}

			@FindBy(css = "a.btn.btn-transparent")
			private WebElement cancelSetting;

			@FindBy(xpath = "//*[@id=\"saveSetting\"]")
			private WebElement saveSettingCheck;

			@FindBy(css = "a.btn.btn-primary")
			private WebElement startButton;

			@FindBy(xpath = "(//*[@class=\"radio-group inline-block main-setting-radio\"])[1]")
			private WebElement commonFeaturesRadio;

			@FindBy(xpath = "(//*[@class=\"radio-group inline-block main-setting-radio\"])[2]")
			private WebElement AdvancedFeaturesRadio;

			@FindBy(xpath = "(//*[@name=\\\"is_snap_pop_up\\\"])[1]")
			private WebElement uiMethodPopUpRadio;

			@FindBy(xpath = "(//*[@name=\"is_snap_pop_up\"])[2]")
			private WebElement uiMethodredirectionRadio;

			@FindBy(xpath = "//*[@name=\"enabled_payments_use\"]")
			private WebElement activePaymentAll;

			@FindBy(xpath = "//*[@id=\"customselect\"]")
			private WebElement activePayementCustom;

			@FindBy(xpath = "//*[@id=\"enabled_payments:credit_card\"]")
			private WebElement CustomCreditCard;

			@FindBy(xpath = "//*[@id=\"enabled_payments:bank_transfer\"]")
			private WebElement CustomATM;

			@FindBy(xpath = "//*[@id=\"enabled_payments:gopay\"]")
			private WebElement customGOPay;

			@FindBy(xpath = "//*[@id=\"enabled_payments:cimb_clicks\"]")
			private WebElement customCIMB;

			@FindBy(xpath = "//*[@id=\"enabled_payments:mandiri_clickpay\"]")
			private WebElement customMandiriClick;

			@FindBy(xpath = "//*[@id=\"enabled_payments:mandiri_ecash\"]")
			private WebElement customMandiriECash;

			@FindBy(xpath = "//*[@id=\"enabled_payments:bri_epay\"]")
			private WebElement customEPayBRI;

			@FindBy(xpath = "//*[@id=\"enabled_payments:bca_klikpay\"]")
			private WebElement customBCAKlickPay;

			@FindBy(xpath = "//*[@id=\"enabled_payments:bca_klikbca\"]")
			private WebElement customKlikBCA;

			@FindBy(xpath = "//*[@id=\"enabled_payments:indosat_dompetku\"]")
			private WebElement customIndosatDompetku;

			@FindBy(xpath = "//*[@id=\"enabled_payments:indomaret\"]")
			private WebElement customIndomaret;

			@FindBy(xpath = "//*[@id=\"enabled_payments:customKioson\"]")
			private WebElement customKioson;

			@FindBy(xpath = "//*[@id=\"enabled_payments:gci\"]")
			private WebElement GiftCardIndonesia;

			@FindBy(xpath = "(//*[@name=\"use_merchant_keys\"])[1]")
			private WebElement MerchantSettingDisable;

			@FindBy(xpath = "(//*[@name=\\\"use_merchant_keys\\\"])[2]")
			private WebElement MerchantSettingEnable;

			public WebElement getCancelSetting() {
				return cancelSetting;
			}

			public WebElement getSaveSettingCheck() {
				return saveSettingCheck;
			}

			public WebElement getStartButton() {
				return startButton;
			}

			public WebElement getCommonFeaturesRadio() {
				return commonFeaturesRadio;
			}

			public WebElement getAdvancedFeaturesRadio() {
				return AdvancedFeaturesRadio;
			}

			public WebElement getUiMethodPopUpRadio() {
				return uiMethodPopUpRadio;
			}

			public WebElement getUiMethodredirectionRadio() {
				return uiMethodredirectionRadio;
			}

			public WebElement getActivePaymentAll() {
				return activePaymentAll;
			}

			public WebElement getActivePayementCustom() {
				return activePayementCustom;
			}

			public WebElement getCustomCreditCard() {
				return CustomCreditCard;
			}

			public WebElement getCustomATM() {
				return CustomATM;
			}

			public WebElement getCustomGOPay() {
				return customGOPay;
			}

			public WebElement getCustomCIMB() {
				return customCIMB;
			}

			public WebElement getCustomMandiriClick() {
				return customMandiriClick;
			}

			public WebElement getCustomMandiriECash() {
				return customMandiriECash;
			}

			public WebElement getCustomEPayBRI() {
				return customEPayBRI;
			}

			public WebElement getCustomBCAKlickPay() {
				return customBCAKlickPay;
			}

			public WebElement getCustomKlikBCA() {
				return customKlikBCA;
			}

			public WebElement getCustomIndosatDompetku() {
				return customIndosatDompetku;
			}

			public WebElement getCustomIndomaret() {
				return customIndomaret;
			}

			public WebElement getCustomKioson() {
				return customKioson;
			}

			public WebElement getGiftCardIndonesia() {
				return GiftCardIndonesia;
			}

			public WebElement getMerchantSettingDisable() {
				return MerchantSettingDisable;
			}

			public WebElement getMerchantSettingEnable() {
				return MerchantSettingEnable;
			}

		}

	}

}
