package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import fixtures.Utilities;


public class ShippingAdressPage extends Utilities {
	 private WebDriver driver;
	 
	 // PickUpStore CheckBox
	 @FindBy(id = "PickUpInStore")
	 private WebElement PickUpInStoreCheckBox;
	 // Shipping Continue Button 
	 @FindBy(xpath = "//input[@onclick='Shipping.save()']")
	 private WebElement continueBtnShipping;
	 

	 public ShippingAdressPage(WebDriver driver) {
	        super(driver);
	        PageFactory.initElements(driver,this);
		}
	 
	 public void ShippingContinueBtn() {
		 waitForElement(continueBtnShipping, 4);
		 continueBtnShipping.click();
	 }
	 
}
