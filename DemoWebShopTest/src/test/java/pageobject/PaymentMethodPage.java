package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fixtures.Utilities;

public class PaymentMethodPage extends Utilities {
	 private WebDriver driver;
	 
	 
	     // Shipping RadioButtons
	 	 // Shipping time button Ground
		 @FindBy(id = "shippingoption_0")
		 private WebElement shippingOptionGround;
		 // Shipping time button NextDay
		 @FindBy(id = "shippingoption_1")
		 private WebElement shippingOptionNextDay;
		 // Shipping time button 2Day
		 @FindBy(id = "shippingoption_2")
		 private WebElement shippingOption2ndDay;
		 // Continue Button ShippingMethodePage
		 @FindBy(className = "shipping-method-next-step-button")
		 private WebElement shippingMethodContinueBtn;
		 // Payment method "Cash"
		 @FindBy(id = "paymentmethod_0")
		 private WebElement paymentMethodCash;
		 // Continue Button PaymentMthod Continue Button
		 @FindBy(className = "payment-method-next-step-button")
		 private WebElement paymentMethodContinueBtn;
		 // Continue Button PaymentInfo Continue Button
		 @FindBy(className = "payment-info-next-step-button")
		 private WebElement paymentMethodInfoContinueBtn;
		 // Confirm Button
		 @FindBy(className = "confirm-order-next-step-button")
		 private WebElement confirmBtn;
		 // Order Completed Button
		 @FindBy(className = "order-completed-continue-button")
		 private WebElement completedBtn;
		 
		 		 
		 
	public PaymentMethodPage(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver,this);
	}

	
	public void ShippingOptionGround() {
		waitForElement(shippingOptionGround, 3);
		 shippingOptionGround.click();
	 }
	 
	 public void ShippingOptionNextDay() {
		 waitForElement(shippingOptionNextDay, 3);
		 shippingOptionNextDay.click();
	 }
	 
	 public void ShippingOption2ndDay() {
		 waitForElement(shippingOption2ndDay, 3);
		 shippingOption2ndDay.click();
	 }
	 
	 public void ShippingMethodContinueBtn() {
		 waitForElement(shippingMethodContinueBtn, 3);
		 shippingMethodContinueBtn.click();
	 }
	 
	 public void PaymentMethodCash() {
		 waitForElement(paymentMethodCash, 3);
		 paymentMethodCash.click();
	 }
	 
	 public void PaymentMethodContinueBtn() {
		 waitForElement(paymentMethodContinueBtn, 3);
		 paymentMethodContinueBtn.click();
	 }
	 
	 public void PaymentMethodInfoContinueBtn() {
		 waitForElement(paymentMethodInfoContinueBtn, 3);
		 paymentMethodInfoContinueBtn.click();
	 }
	 
	 public void ConfirmBtn() {
		 waitForElement(confirmBtn, 3);
		 confirmBtn.click();
	 }
	 
	 public void CompletedBtn() {
		 waitForElement(completedBtn, 3);
		 completedBtn.click();
	 }
}
