package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fixtures.Utilities;

public class LogInPage extends Utilities {
	
private WebDriver driver; 
	
	// Navigate to the LoginPage
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	private WebElement logIn; 
	
	// Input Box Username
	@FindBy(id = "Email")
	private WebElement inputUserName;
	
	// Input Box Password 
	@FindBy(id = "Password")
	private WebElement inputPassword;
	
	// Click on RememberME Checkbox  
	@FindBy(id = "RememberMe")
	private WebElement rememberMeBox;
	
	// Click on Log IN button 
	@FindBy(css =".login-button")
	private WebElement logInBtn;
	
	// Assertion Login 
	@FindBy(className = "account")
	private WebElement logInSuccessful;
	
	// Forgot Password
	@FindBy(className = "forgot-password")
	private WebElement forgotPassword;
	
	// Password recovery / Enter your Password 
	@FindBy(id = "Email")
	private WebElement emailAdress;
	
	// Recover Button
	@FindBy(css = "input[value='Recover']")
	private WebElement recoverBtn;
	
	// Status Message (Email with instructions has been sent to you.)
	@FindBy(linkText = "Email with instructions has been sent to you.")
	private WebElement statusMessagePwRecovery;  
	
	public LogInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void LogInClick() {
		logIn.click();	
	}
	
	public void Login(LoginData logindata) {
		waitForElement(inputUserName, 4);
		waitForElement(inputPassword, 4);
		inputUserName.sendKeys(logindata.getUsername());
		inputPassword.sendKeys(logindata.getPassword());
	}
	
	public void ClickRememberCheckBox() {
		waitForElement(rememberMeBox, 4);
		rememberMeBox.click();
	}
	
	public void ClickLogInBtn() {
		waitForElement(logInBtn, 3);
		logInBtn.click();	
	}
	
	
	public void ForgotPasswordBtn () {
		waitForElement(forgotPassword, 2);
		forgotPassword.click();
	}
	
	public void EmailAdressForRecovery(String emailadress) {
		waitForElement(emailAdress, 2);
		emailAdress.sendKeys(emailadress);
	}
	
	public void RecoverButton() {
		waitForElement(recoverBtn, 2);
		recoverBtn.click();
	}
	
	public String StatusMessage() {
		waitForElement(statusMessagePwRecovery, 2);
		return statusMessagePwRecovery.getText();
		
	}

	public String AssertLogIn1() {
		waitForElement(logInSuccessful, 2);
		return logInSuccessful.getText();
	}

		
}
