package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.GenerelPage;
import pageobject.LogInPage;
import pageobject.LoginData;

class LogInTest {

	WebDriver driver=new ChromeDriver();
	
	@BeforeEach
	public void setUp() throws Exception {
		
		System.out.println("initialize WebDriver");
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	
	}
	
	@AfterEach 
	public void tearDown() throws Exception {
		
		System.out.println("test completed");
		driver.close();
	}
	
	
	@Test
	public void LogInTestUser() {
		System.out.println("Login was successful");

			// Arrange
		 
			LogInPage loginPage = new LogInPage(driver);
			LoginData loginData = new LoginData(driver);
			GenerelPage generelPage = new GenerelPage(driver);
			

			// Act
			// The login button is clicked
			generelPage.selectHeaderLink(1);
			// The login data is entered and the user is logged in 
			loginPage.Login(loginData);
			loginPage.ClickRememberCheckBox();
			loginPage.ClickLogInBtn();
			
			// Assert
			// Successful login is confirmed by email address at the top of the header link 
			String successmessage = loginPage.AssertLogIn1();
			assertTrue(successmessage.contains("jawad.norosi@hotmail.com"));
			
		
			
	}

}
