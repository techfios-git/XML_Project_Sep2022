package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {

	WebDriver driver;

	
	@Test
	@Parameters({"UserName", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void userShouldBeAbleToAddCustomer(String userName, String password, String fullName, String company, String email, String phone, String address, String city, String country, String state, String zip) throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSininButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerMenuElement();
		dashboardPage.clickAddCustomerMenuElement();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage();
		addCustomerPage.insertFullname(fullName);
		addCustomerPage.selectFromCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.clickSaveButton();

		ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.validateProfilePage();
		dashboardPage.clickListCustomerMenuElement();
		
		listCustomerPage.validateInsertedNameAndDelete();
		
		BrowserFactory.tearDown();

	}

}
