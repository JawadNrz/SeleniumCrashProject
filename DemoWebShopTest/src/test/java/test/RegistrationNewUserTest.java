package test;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.GenerelPage;
import pageobject.RegisterPage;


class RegistrationNewUserTest {

	WebDriver driver = new ChromeDriver();
	
	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("initialize WebDriver");
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");	
			
	}

	@AfterEach
	void tearDown() throws Exception {
		
	    System.out.println("test completed");
		driver.close();
	}

	@Test
	
	public void RegistrationUser() throws InterruptedException { 
		
		// Arrange
		GenerelPage generelPage = new GenerelPage(driver);
		RegisterPage registerPage = new RegisterPage(driver);
		
		
		// Act
		
		// the registerien button in the header link is clicked on
		generelPage.selectHeaderLink(0);
		Thread.sleep(2000);
		
		// a new user was created here 
		registerPage.selectMaleGender();
	    registerPage.fillingTheRegisterFields();
		registerPage.clickRegisterButton();
		
		
		// Assert
		// Successful registration is recognized by the "Register" heading in the register page 
		
		String successmessage = registerPage.AssertRegistration();
		assertEquals(successmessage, "Register");
		registerPage.ContinueBtn();
		
	}

}
