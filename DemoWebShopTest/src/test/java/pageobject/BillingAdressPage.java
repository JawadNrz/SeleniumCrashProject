package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import fixtures.Utilities;

public class BillingAdressPage extends Utilities {

	 private WebDriver driver;
	 private Faker faker;

	 
	 
	 //here the elements of the checkout page of the area Billing address are identified 
	 @FindBy(id = "BillingNewAddress_FirstName")
	 private WebElement firstNameInput;
	    
	 @FindBy(id = "BillingNewAddress_LastName")
	 private WebElement lastNameInput;
	    
	 @FindBy(id = "BillingNewAddress_Email")
	 private WebElement emailInput;
	 
	 @FindBy(id = "BillingNewAddress_CountryId")
	 private WebElement countryDropDownBilling;
	 
	 @FindBy(id = "BillingNewAddress_City")
	 private WebElement cityInput;
	 
	 @FindBy(id = "BillingNewAddress_Address1")
	 private WebElement adress1Input;
	 
	 @FindBy(id = "BillingNewAddress_ZipPostalCode")
	 private WebElement postalCodeInput;
	 
	 @FindBy(id = "BillingNewAddress_FaxNumber")
	 private WebElement FaxNumberInput;
	 
	 @FindBy(xpath = "//input[@onclick='Billing.save()']")
	 private WebElement continueBtnBilling;
	 
	 @FindBy(id = "billing-address-select")
	 private WebElement billingSelectAdress;
	 
	 @FindBy(id = "BillingNewAddress_PhoneNumber")
	 private WebElement Phonenumber;
	
	 
	 public BillingAdressPage(WebDriver driver) {
	        super(driver);
	        this.faker = new Faker();
	        PageFactory.initElements(driver,this);
		}
	
	 public void fillBillingAddressForm() {
		 /* firstNameInput.sendKeys(faker.name().firstName());
		  lastNameInput.sendKeys(faker.name().lastName());
		  emailInput.sendKeys(faker.internet().emailAddress()); */
		  waitForElement(countryDropDownBilling, 2);
		  waitForElement(cityInput, 2);
		  waitForElement(adress1Input, 2);
		  waitForElement(postalCodeInput, 2);
		  waitForElement(Phonenumber, 2);
		  countryDropDownBilling.sendKeys("Germany");
	      cityInput.sendKeys(faker.address().city());
	      adress1Input.sendKeys(faker.address().streetAddress());
	      postalCodeInput.sendKeys(faker.address().zipCode());
	      Phonenumber.sendKeys(faker.phoneNumber().phoneNumber());
	   }
	 
	 public void BillingAdressCountinueBtn() {
		 waitForElement(continueBtnBilling, 4);
		 continueBtnBilling.click();
	 }
	 
	 public void SelectBillingAdress(String visibleText) {
		 waitForElement(billingSelectAdress, 3);
		 Select selectbillingadress = new Select(billingSelectAdress);
		 selectbillingadress.selectByVisibleText(visibleText);
		   
	   }
	   
	 
}
