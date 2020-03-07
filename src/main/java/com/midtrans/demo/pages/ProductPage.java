package com.midtrans.demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midtrans.demo.BaseClass.TestBase;
import com.midtrans.demo.reports.LoggerHelper;

public class ProductPage extends TestBase {

	private final static Logger log = LoggerHelper.getLogger(ProductPage.class);

	public ProductPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.btn.buy")
	private WebElement buyNowButton;

	@FindBy(css = "div.price > span:nth-child(2)")
	private WebElement pillowPrice;

	@FindBy(className = "//a[@class='btn btn-signup']")
	private WebElement signUpButton;

	public WebElement getBuyNowButton() {
		
		return buyNowButton;
	}

	public WebElement getPillowPrice() {
		return pillowPrice;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}

}
