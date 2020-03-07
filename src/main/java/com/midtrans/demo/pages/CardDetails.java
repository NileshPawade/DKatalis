package com.midtrans.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midtrans.demo.BaseClass.TestBase;

public class CardDetails extends TestBase {

	public CardDetails() {
		super();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='text-amount-amount']")
	private WebElement amount;

	@FindBy(xpath = "//*[@name=\"cardnumber\"]")
	private WebElement cardNumber;

	@FindBy(xpath = "//*[@placeholder=\"MM / YY\"]")
	private WebElement expiryDate;

	@FindBy(xpath = "//*[@inputmode=\"numeric\"]")
	private WebElement cVV;

	@FindBy(xpath = "//*[@class=\"checkbox checkbox-left\"]")
	private WebElement promoCode;

	@FindBy(xpath = "//*[@class=\"pull-right text-gray\"]")
	private WebElement promoAmount;

	@FindBy(xpath = "//*[@placeholder=\"budi@utomo.com\"]")
	private WebElement email;

	@FindBy(xpath = "(//input[@type=\"tel\"])[4]")
	private WebElement phone;

	@FindBy(xpath = "//*[@class=\"button-main show\"]")
	private WebElement payNow;

	@FindBy(xpath = "//*[@id=\"merchant_name\"]")
	private WebElement TmerchantName;

	@FindBy(xpath = "//*[@id=\"txn_amount\"]")
	private WebElement TtransactionAmount;

	@FindBy(xpath = "//*[@id=\"txn_time\"]")
	private WebElement transactionTime;

	@FindBy(xpath = "//*[@id=\"card_number\"]")
	private WebElement TcardNumber;

	@FindBy(xpath = "//*[@id=\"PaRes\"]")
	private WebElement Tpassword;

	@FindBy(xpath = "//*[@name=\"ok\"]")
	private WebElement TOk;

	@FindBy(xpath = "//*[@name=\"cancel\"]")
	private WebElement TCancel;

	@FindBy(xpath = "//*[@name='resend']")
	private WebElement resendOTP;

	@FindBy(xpath = "//*[@id=\"acsMain\"]/div/div/img")
	private WebElement bankLogo;

	public WebElement getBankLogo() {
		return bankLogo;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getExpiryDate() {
		return expiryDate;
	}

	public WebElement getcVV() {
		return cVV;
	}

	public WebElement getPromoCode() {
		return promoCode;
	}

	public WebElement getPromoAmount() {
		return promoAmount;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getPayNow() {
		return payNow;
	}

	public WebElement getTmerchantName() {
		return TmerchantName;
	}

	public WebElement getTtransactionAmount() {
		return TtransactionAmount;
	}

	public WebElement getTransactionTime() {
		return transactionTime;
	}

	public WebElement getTcardNumber() {
		return TcardNumber;
	}

	public WebElement getTpassword() {
		return Tpassword;
	}

	public WebElement getTOk() {
		return TOk;
	}

	public WebElement getTCancel() {
		return TCancel;
	}

	public WebElement getResendOTP() {
		return resendOTP;
	}
}