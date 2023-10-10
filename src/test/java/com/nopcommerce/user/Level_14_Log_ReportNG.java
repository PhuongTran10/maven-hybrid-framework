package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_14_Log_ReportNG extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "Testing";
		existingEmail = "abc"+ generateFakeNumber() + "@gmail.com";
		validPassword = "123456";
	}
	
	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Register - Step 04: Enter to Email textbox with value is '" + existingEmail + "'");
		registerPage.inputToEmailTextbox(existingEmail);
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Register - Step 07: Click to 'Register' button");
		homePage = registerPage.clickToRegisterButton();
		
		
		log.info("Register - Step 08: Verify success register message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed..");
		
		log.info("Register - Step 10: Click to Logout link");
		if(!registerPage.isLoginLinkDisplayed()) {
			homePage = registerPage.clickToLogoutLink();
		}	
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login Page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to Email textbox with value is '" + firstName + "'");
		loginPage.inputToEmailTextbox(existingEmail);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Login - Step 04: Click to 'Login' button");		
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify 'My account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: Navigate to 'Customer infor' page");
		customerInforPage = homePage.clickToMyAccountLink();
		
		log.info("Login - Step 07: Verify 'Customer infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforHeaderDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
}
