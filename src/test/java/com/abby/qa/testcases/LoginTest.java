package com.abby.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.abby.qa.pages.AccountPage;
import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.LoginPage;
import com.abby.qa.utils.Utilities;
import com.abhi.qa.base.Base;

public class LoginTest extends Base{
	
	public WebDriver driver;
	LoginPage loginPage;
	
	public LoginTest() {
		super();
	}
	
	
//	public void setUp() {
//		driver =  initializaBrowserAndOpenApplication(prop.getProperty("browserName"));
//		HomePage homePage = new HomePage(driver);
//		homePage.clickOnMyAccount();
//		registePage = homePage.selectRegisterOption();	
//	}

	@BeforeMethod
	public void setUp() {
		driver =  initializaBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
	}

	@AfterMethod
	public void closed11() {
		driver.quit();
	}

	

	@Test(priority = 1, dataProvider="ValidCredentialProvider")
	public void verifyLoginWithValidCreadentials(String email, String password) {
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLogInButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusedityourAccountInformation(),
				"Edit your account information option is not displayed");
	}
	
	@DataProvider(name="ValidCredentialProvider")
	public Object[][] supplyTestData() 
	{
		Object[][] data = Utilities.getTextDataFromExcel("Sheet1");
		return data;
		
	}
	

	@Test(priority = 2)
	public void verifyLoginWithInvalidCreadentials() {

		loginPage.enterEmailAddress(Utilities.generateTimeStamp());
		loginPage.enterPassword(dataProp.getProperty("ivalidPassword"));
		loginPage.clickOnLogInButton();

		String actualWorningMassage = loginPage.retrivrEmailPasswordNotMatchingWarning();
		String ExpectedWorningMassage = dataProp.getProperty("emilPassWordNoMatchWorning");

		Assert.assertTrue(actualWorningMassage.contains(ExpectedWorningMassage),
				"Expected Wornng massage i not displayed");
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		loginPage.enterEmailAddress(Utilities.generateTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLogInButton();

		String actualWorningMassage = loginPage.retrivrEmailPasswordNotMatchingWarning();
		String ExpectedWorningMassage = dataProp.getProperty("emilPassWordNoMatchWorning");

		Assert.assertTrue(actualWorningMassage.contains(ExpectedWorningMassage),
				"Expected Wornng massage i not displayed");
	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {

		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("ivalidPassword"));
		loginPage.clickOnLogInButton();

		String actualWorningMassage = loginPage.retrivrEmailPasswordNotMatchingWarning();
		String ExpectedWorningMassage = dataProp.getProperty("emilPassWordNoMatchWorning");

		Assert.assertTrue(actualWorningMassage.contains(ExpectedWorningMassage),
				"Expected Wornng massage i not displayed");
	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredential() {

		loginPage.clickOnLogInButton();

		String actualWorningMassage = loginPage.retrivrEmailPasswordNotMatchingWarning();
		String ExpectedWorningMassage = dataProp.getProperty("emilPassWordNoMatchWorning");

		Assert.assertTrue(actualWorningMassage.contains(ExpectedWorningMassage),
				"Expected Wornng massage i not displayed");
	}
}
