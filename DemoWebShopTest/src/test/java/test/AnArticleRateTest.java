package test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.GenerelPage;
import pageobject.LogInPage;
import pageobject.LoginData;
import pageobject.ProductPage;
import pageobject.ProductReviewsPage;

class AnArticleRateTest {
	
	WebDriver driver = new ChromeDriver();

	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("initialize WebDriver");
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://demowebshop.tricentis.com/");	
	}

	@AfterEach
	void tearDown() throws Exception {
		
		System.out.println("test completed");
		//driver.close();
	}

	@Test
	void RatingTest() throws InterruptedException {
		
		GenerelPage generelPage = new GenerelPage(driver);
		LogInPage loginPage = new LogInPage(driver);
		LoginData loginData = new LoginData(driver);
		ProductPage productPage = new ProductPage(driver);
		ProductReviewsPage productReviewsPage = new ProductReviewsPage(driver);
		
		// here the user is logged in 
		generelPage.selectHeaderLink(1);
		loginPage.Login(loginData);
		loginPage.ClickRememberCheckBox();
		loginPage.ClickLogInBtn();
		
		// call up the desired product via the search bar
		generelPage.SearchStore("JEWELRY");
		// click search bar button
		generelPage.SearchBtn();
		// the product is clicked
		productPage.CreateYourOwnJewelryProduct();
		// write review button click
		productPage.ClickOnAddYourReview();
		// here a tittle is given for the rating
		productReviewsPage.ReviewTittleInput("Product Test");
		// The rating is given here
		productReviewsPage.ReviewTextInput("The product looks very good");
		// The star rating
		// Rating: Bad to Excellent from 1 - 5 
		productReviewsPage.selectRatingRadioOption(3);
		// submit button is pressed
		productReviewsPage.SubmitReviewBtn();
		// the user is logged out 
		generelPage.selectHeaderLink(1);
		
		
		// Assert
		//String assertmessage = productReviewsPage.AssertRating();
		//assertTrue(assertmessage.contains("EXISTING REVIEWS"));
		
	}

}
