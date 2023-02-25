package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ListCustomerPage extends BasePage{
	
	WebDriver driver;
	
	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//WebElement
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") WebElement SUMMARY_ON_PROFILE_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]") WebElement DELETE_OK_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BAR_ON_LIST_CUSTOMER_ELEMENT;
	
	
	//Intractable Mehods
	
	
	public void validateProfilePage() {
		waitForElement(driver, 5, SUMMARY_ON_PROFILE_ELEMENT);
		Assert.assertTrue(SUMMARY_ON_PROFILE_ELEMENT.isDisplayed(), "Profile page not found..");
	}
	
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[1]/td[7]/a[2]
	//tbody/tr[1]/td[7]/a[1]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_delete = "]/td[7]/a[2]";
	String after_xpath_profile = "]/td[7]/a[1]";
	
	
	public void validateInsertedNameAndDelete() {
		
		for(int i = 1; i <= 5; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if(name.contains(AddCustomerPage.getInsertedName())) {
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
				DELETE_OK_BUTTON_ELEMENT.click();
			}
		}
		
	}
	
	public void clickOnAddCustomerOnListCustomer() {
		ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT.click();
	}
	
	public void insertOnSearchBarOnListCustomer() {
		SEARCH_BAR_ON_LIST_CUSTOMER_ELEMENT.sendKeys(AddCustomerPage.getInsertedName());
	}

	public void validateInsertedNameAndProfile() {
		
		for(int i = 1; i <=5; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if(name.contains(AddCustomerPage.getInsertedName())) {
				driver.findElement(By.xpath(before_xpath + i + after_xpath_profile)).click();
			}
			break;
		}
		
	}
	
	
	

}
