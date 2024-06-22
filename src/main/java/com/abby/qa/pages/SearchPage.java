package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPproduct;
	
	
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement actualSearchMessage;

	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayValidHPproduct() {
		boolean text = validHPproduct.isDisplayed();
		return text;
	}
	
//	public String getActualSearchMessage() {
//		String text = validHPproduct.getText();
//		return text;
//	}

	public String getActualSearchMessage() {
		String text = actualSearchMessage.getText();
		return text;
	}
	
	

}
