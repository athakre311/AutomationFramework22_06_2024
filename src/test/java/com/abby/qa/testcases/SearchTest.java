  package com.abby.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abby.qa.pages.HomePage;
import com.abby.qa.pages.SearchPage;
import com.abhi.qa.base.Base;

public class SearchTest extends Base{

	public SearchTest() {
		super();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver =  initializaBrowserAndOpenApplication(prop.getProperty("browserName"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void verifySearchWithValidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterElementInSearchBox(dataProp.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayValidHPproduct(),"valid roduct");

//		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataProp.getProperty("validProduct"));
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	@Test (priority=2)
	public void verifySearchWithIvalidProduct() {
		
		
		HomePage homePage = new HomePage(driver);
		homePage.enterElementInSearchBox(dataProp.getProperty("invalidProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessage = searchPage.getActualSearchMessage();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("NoResult"),"Account massage not displayed");
	
		
//		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataProp.getProperty("invalidProduct"));
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
//		String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
//		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("NoResult"),"Account massage not displayed");
	}
	
	@Test (priority=3)
	public void verifySearchWithOutAnyProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterElementInSearchBox(dataProp.getProperty("invalidProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessageWithoutValur = searchPage.getActualSearchMessage();
		Assert.assertEquals(actualSearchMessageWithoutValur, dataProp.getProperty("NoResult"),"Account massage not displayed");
	
	
//		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
//		
//		
//		String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
//		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("NoResult"),"Account massage not displayed");
	}
}
