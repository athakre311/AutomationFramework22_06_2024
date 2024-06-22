package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBotton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}


	public void clickOnLogInButton( ) {
		loginBotton.click();
	}
	
	public String retrivrEmailPasswordNotMatchingWarning( ) {
		String worningText = emailPasswordNotMatchingWarning.getText();
		return worningText;
	}

//	/
}
