package com.abby.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistePage {
	
	WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement inputFirstname;
	
	@FindBy(id = "input-lastname")
	private WebElement inputLastname;
	
	@FindBy(id = "input-email")
	private WebElement inputEmail;
	
	@FindBy(id = "input-telephone")
	private WebElement inputTelephone;
	
	@FindBy(id = "input-password")
	private WebElement inputPassword;
	
	@FindBy(id = "input-confirm")
	private WebElement inputConfirm;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement button;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement agreeButton;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement alreadRegisteredMassage;
	
	@FindBy(xpath = "(//div[@id='content'])/h1")
	private WebElement successfullyCreatedMassage;
	

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarningMassage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNamWarningMassage;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMassage;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMassage;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMassage;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMassage;
	

	public RegistePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterInputFirstname(String firstName) {
		inputFirstname.sendKeys(firstName);
	}
	
	public void enterInputLastname(String lastName) {
		inputLastname.sendKeys(lastName);
	}
	
	public void enterInputEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void enterInputTelephone(String telephone) {
		inputTelephone.sendKeys(telephone);
	}
	
	public void enterInputPassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	public void enterInputConfirm(String cPassword) {
		inputConfirm.sendKeys(cPassword);
	}
	
	public void clickOnAgreeButton() {
		agreeButton.click();
	}
	
	public void clickCheckBoxNew(){
		button.click();
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
	
	public String accountSuccessfullyCreatedHeading() {
		String aText = successfullyCreatedMassage.getText();
		return aText;
	}
	
	public String accountAlreadRegisteredMassage() {
		String aText = alreadRegisteredMassage.getText();
		return aText;
	}
	
//	new
	
	
	public String privacyPolicyWarningM() {
		String aText = privacyPolicyWarningMassage.getText();
		return aText;
	}
	public String firstNamWarningM() {
		String aText = firstNamWarningMassage.getText();
		return aText;
	}
	public String lastNameWarningM() {
		String aText = lastNameWarningMassage.getText();
		return aText;
	}
	public String emailWarningM() {
		String aText = emailWarningMassage.getText();
		return aText;
	}
	public String telephoneWarningM() {
		String aText = telephoneWarningMassage.getText();
		return aText;
	}
	public String passwordWarningM() {
		String aText = passwordWarningMassage.getText();
		return aText;
	}
	

}
