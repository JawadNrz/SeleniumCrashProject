package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.github.javafaker.Faker;

import fixtures.Utilities;

public class RegisterPage extends Utilities {

	 private WebDriver driver;
	 private Faker faker;

	    
	    @FindBy(id = "gender-male")
	    private WebElement genderMaleRadioButton;
	    
	    @FindBy(id = "gender-female")
	    private WebElement genderFemaleRadioButton;
	    
	    @FindBy(id = "FirstName")
	    private WebElement firstNameInput;
	    
	    @FindBy(id = "LastName")
	    private WebElement lastNameInput;
	    
	    @FindBy(id = "Email")
	    private WebElement emailInput;
	    
	    @FindBy(id = "Password")
	    private WebElement passwordInput;
	    
	    @FindBy(id = "ConfirmPassword")
	    private WebElement confirmPasswordInput;
	    
	    @FindBy(id = "register-button")
	    private WebElement registerButton;
	    
	    @FindBy(xpath = "//h1[normalize-space()='Register']")
	    private WebElement registerCompleted;
	    
	    @FindBy(className = "register-continue-button")
	    private WebElement continueBtn;
	    
	
	    
	    public RegisterPage(WebDriver driver) {
	    	super(driver);
	        this.faker = new Faker();
	        PageFactory.initElements(driver,this);
	    }
	    
	    
	    public void selectMaleGender() {
	    	waitForElement(genderMaleRadioButton, 3);
	        genderMaleRadioButton.click();
	    }
	    
	    public void selectFemaleGender() {
	    	waitForElement(genderFemaleRadioButton, 3);
	        genderFemaleRadioButton.click();
	    }
	    
	    public void fillingTheRegisterFields() {
			  firstNameInput.sendKeys(faker.name().firstName());
			  lastNameInput.sendKeys(faker.name().lastName());
			  emailInput.sendKeys(faker.internet().emailAddress()); 
			  String password = faker.internet().password();
			  passwordInput.sendKeys(password);
			  confirmPasswordInput.sendKeys(password);
		   }
	   
	    
	    public void clickRegisterButton() {
	    	waitForElement(registerButton, 3);
	        registerButton.click();
	    }
	    
	    public void ContinueBtn() {
	    	waitForElement(continueBtn, 3);
	        continueBtn.click();
	    }
	    
		public String AssertRegistration() {
			waitForElement(registerCompleted, 3);
			return registerCompleted.getText();
		}
		
	}
	   
	

