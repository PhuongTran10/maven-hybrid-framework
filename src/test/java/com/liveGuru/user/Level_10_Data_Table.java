package com.liveGuru.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.liveGuru.AdminLoginPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_Data_Table extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomPage(driver);
		emailValid = "abc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		userName = "Automation Testing";
		
	}
	
	@Test
	public void User_01_Register_To_System() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputToFirstNameTextbox("Automation");
		registerPage.inputToLastNameTextbox("Testing");
		registerPage.inputToEmailAddressTextbox(emailValid);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		myDashboardPage = registerPage.clickToRegisterButton();
		
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		myDashboardPage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL_LIVE_GURU);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.loginAsAdmin("user01","guru99com");
		adminLoginPage.closeIncomingMessage();
		adminLoginPage.enterToHeaderTextboxByName("Email", emailValid);
		Assert.assertTrue(adminLoginPage.isNameAndEmailSearchedDisplayed(userName, emailValid));
		
	}
	

	@AfterClass
	public void afterClass() {
	driver.quit();
	}
	
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyDashboardPageObject myDashboardPage;
	private AdminLoginPageObject adminLoginPage;
	private String emailValid, password, userName; 

	
}
