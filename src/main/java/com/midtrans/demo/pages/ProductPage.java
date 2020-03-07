package com.midtrans.demo.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midtrans.demo.BaseClass.TestBase;

public class ProductPage extends TestBase {

public ProductPage() {
super();
PageFactory.initElements(driver, this);
}


@FindBy(css="a.btn.buy")
private WebElement buyNowButton;

@FindBy(css="div.price > span:nth-child(2)")
private WebElement pillowPrice;

@FindBy(className="//a[@class='btn btn-signup']")
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
