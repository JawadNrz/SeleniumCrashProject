package test;

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
import pageobject.WishListPage;

class WishListTest {

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
			//driver.close();
	}

	@Test
	void test() throws InterruptedException {
		
		// Arrange
		LogInPage loginPage = new LogInPage(driver);
		LoginData loginData = new LoginData(driver);
		GenerelPage generelPage = new GenerelPage(driver);
		ProductPage productPage = new ProductPage(driver);
		WishListPage wishListPage = new WishListPage(driver);
		
		// here the user is logged in 
		loginPage.LogInClick();
		loginPage.Login(loginData);
		loginPage.ClickRememberCheckBox();
		loginPage.ClickLogInBtn();
	
		// Act
		
		// the option jewelry is called up on the menu bar
		generelPage.selectMenuItem("JEWELRY");
		//generelPage.selectMenuBarObject(5);
		Thread.sleep(2000);
		
		// The desired product is filtered here according to various criteria
		productPage.selectSortBy("Price: Low to High");
		Thread.sleep(3000);
		productPage.selectDisplayPerPage("12");
		Thread.sleep(3000);
		productPage.selectViewAs("List");
		Thread.sleep(3000);
		productPage.CreateYourOwnJewelryProduct();
		Thread.sleep(3000);
		productPage.selectMaterialOwnJewelry("Silver (1 mm)");
		
		// the product is selected according to desire 
		productPage.LenghtInCmField("30 cm");
		
		// Here the radio button is selected 
		// 0=Ladybug  1=Heart   2=Star  3=None
		productPage.selectRadioOption(2);
		
		// Here enter the desired number of the product and added to wish list
		productPage.SelectQtyField("5");
		productPage.ClickOnAddToWishListBtn();
		// HeaderLink 3 is the Wishlist Button 
		generelPage.selectHeaderLink(3);
		
		// the product is removed from the wish list
		wishListPage.RemoveCheckbox();
		wishListPage.UpdateCartBtn();
		
		
		// Assert
		// Verify that all the radio buttons are indeed selected
      
    }
	   
	
	   }

	
	
	
	


