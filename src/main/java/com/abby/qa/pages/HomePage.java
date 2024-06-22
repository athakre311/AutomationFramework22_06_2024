package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerOption;
	
	
	@FindBy(xpath = "//input[@name='search']")
	WebElement enterElement;
	
	@FindBy(xpath = "//div[@id='search']/descendant::button")
	WebElement SearchButton;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegistePage selectRegisterOption() {
		registerOption.click();
		return new RegistePage(driver);
	}
	
	public void enterElementInSearchBox(String searchme) {
		enterElement.sendKeys(searchme);
	}
	
	public void clickOnSearchButton() {
	SearchButton.click();
	}

	
}
