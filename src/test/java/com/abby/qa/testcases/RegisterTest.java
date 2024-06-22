package com.abby.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.RegistePage;
import com.abby.qa.utils.Utilities;
import com.abhi.qa.base.Base;

public class RegisterTest extends Base {

	public WebDriver driver;
	
	RegistePage registePage;
	
	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver =  initializaBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registePage = homePage.selectRegisterOption();	
	}

	@AfterMethod
	public void closed11() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {

		registePage.enterInputFirstname(dataProp.getProperty("firstName"));
		registePage.enterInputLastname(dataProp.getProperty("lastName"));
		
		registePage.enterInputEmail((Utilities.generateTimeStamp()));
		registePage.enterInputTelephone(dataProp.getProperty("telephone"));   
		registePage.enterInputPassword(prop.getProperty("validPassword"));
		registePage.enterInputConfirm(prop.getProperty("validPassword"));
		registePage.clickOnAgreeButton();
		registePage.clickOnSubmitButton();
		
//		driver.findElement(By.id("input-firstname")).sendKeys("Abhishek");
//		driver.findElement(By.id("input-lastname")).sendKeys("Abhishek");
//
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys("123456789");
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@type='submit']")).click();

//		driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		String actualText = registePage.accountSuccessfullyCreatedHeading();
		String expectedText = dataProp.getProperty("accountSuccessfullyCreatedHeading");
		Assert.assertEquals(actualText, expectedText, "Account is not created");

	}

	@Test(priority = 2)
	public void verifyRegisteringAnAccountWithAllFields() {
		
		registePage.enterInputFirstname(dataProp.getProperty("firstName"));
		registePage.enterInputLastname(dataProp.getProperty("lastName"));
		
		registePage.enterInputEmail((Utilities.generateTimeStamp()));
		registePage.enterInputTelephone(dataProp.getProperty("telephone"));   
		registePage.enterInputPassword(prop.getProperty("validPassword"));
		registePage.enterInputConfirm(prop.getProperty("validPassword"));
		
		registePage.clickCheckBoxNew();
		registePage.clickOnAgreeButton();
		registePage.clickOnSubmitButton();

//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
	
		String actualText = registePage.accountSuccessfullyCreatedHeading();
		String expectedText = dataProp.getProperty("accountSuccessfullyCreatedHeading");
		Assert.assertEquals(actualText, expectedText, "Account is not created");
	}

	@Test(priority = 3)
	public void verifyRegisteringAnAccountWithExistingEmailAddress() {
		
		registePage.enterInputFirstname(dataProp.getProperty("firstName"));
		registePage.enterInputLastname(dataProp.getProperty("lastName"));

//		driver.findElement(By.id("input-firstname")).sendKeys("Abhishek");
//		driver.findElement(By.id("input-lastname")).sendKeys("Abhishek");
		
		registePage.enterInputEmail(prop.getProperty("validEmail"));

//		driver.findElement(By.id("input-email")).sendKeys("amotooricap3@gmail.com");
		
		registePage.enterInputTelephone(dataProp.getProperty("telephone"));   
		registePage.enterInputPassword(prop.getProperty("validPassword"));
		registePage.enterInputConfirm(prop.getProperty("validPassword"));
		
		registePage.clickCheckBoxNew();
		registePage.clickOnAgreeButton();
		registePage.clickOnSubmitButton();
		
//		driver.findElement(By.id("input-telephone")).sendKeys("123456789");
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String actualText = registePage.accountAlreadRegisteredMassage();
		String expectedText = dataProp.getProperty("duplicateEmailWarning");
		Assert.assertEquals(actualText, expectedText, "Account is not created");

//		String actualText = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
//		Assert.assertEquals(actualText,dataProp.getProperty("duplicateEmailWarning"), "Error");

	}

	@Test(priority = 4)
	public void verifyRegisteringAnAccountWithoutFillingAnyData() {

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		registePage.clickOnSubmitButton();

		
		String policyWorning = registePage.privacyPolicyWarningM();
		Assert.assertEquals(policyWorning, dataProp.getProperty("privacyPolicyWarning"), "Error");

		String firstNameWorning = registePage.firstNamWarningM();
		Assert.assertEquals(firstNameWorning, dataProp.getProperty("firstNamWarning"), "Error");

		String lastNameWorning = registePage.lastNameWarningM();
		Assert.assertEquals(lastNameWorning, dataProp.getProperty("lastNameWarning"), "Error");

		String emailWorning = registePage.emailWarningM();
		Assert.assertEquals(emailWorning, dataProp.getProperty("emailWarning"), "Error");

		String telephoneWorning = registePage.telephoneWarningM();
		Assert.assertEquals(telephoneWorning, dataProp.getProperty("telephoneWarning"), "Error");

		String passwordWorning = registePage.passwordWarningM();
		Assert.assertEquals(passwordWorning, dataProp.getProperty("passwordWarning"), "Error");

		
		
//		String policyWorning = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
//		Assert.assertEquals(policyWorning, dataProp.getProperty("privacyPolicyWarning"), "Error");
//
//		String firstNameWorning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"))
//				.getText();
//		Assert.assertEquals(firstNameWorning, dataProp.getProperty("firstNamWarning"), "Error");
//
//		String lastNameWorning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div"))
//				.getText();
//		Assert.assertEquals(lastNameWorning, dataProp.getProperty("lastNameWarning"), "Error");
//
//		String emailWorning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div"))
//				.getText();
//		Assert.assertEquals(emailWorning, dataProp.getProperty("emailWarning"), "Error");
//
//		String telephoneWorning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"))
//				.getText();
//		Assert.assertEquals(telephoneWorning, dataProp.getProperty("telephoneWarning"), "Error");
//
//		String passwordWorning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div"))
//				.getText();
//		Assert.assertEquals(passwordWorning, dataProp.getProperty("passwordWarning"), "Error");

	}
}
