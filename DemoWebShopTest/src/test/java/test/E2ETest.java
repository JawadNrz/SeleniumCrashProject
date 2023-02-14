package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.BillingAdressPage;
import pageobject.GenerelPage;
import pageobject.LogInPage;
import pageobject.LoginData;
import pageobject.PaymentMethodPage;
import pageobject.ProductPage;
import pageobject.ShippingAdressPage;
import pageobject.ShoppingCartPage;


class E2ETest {
	
	WebDriver driver=new ChromeDriver();
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("initialize WebDriver");
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://demowebshop.tricentis.com/");
	
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("test completed");
		
	}

	@Test
	public void GenerelPage() throws InterruptedException {
		System.out.println("Login was successful");
	
		// Arrange
		
		GenerelPage generelPage = new GenerelPage(driver);
		LogInPage loginPage = new LogInPage(driver);
		LoginData loginData = new LoginData(driver);
		ProductPage productPage = new ProductPage(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		BillingAdressPage billingAdressPage = new BillingAdressPage(driver);
		ShippingAdressPage shippingAdressPage = new ShippingAdressPage(driver);
		PaymentMethodPage paymentMethodPage = new PaymentMethodPage(driver);
		
		// Act
		
		// here the user is logged in 
		// here the login button is called dynamically with the index
		generelPage.selectHeaderLink(1);
		loginPage.Login(loginData);
		loginPage.ClickRememberCheckBox();
		loginPage.ClickLogInBtn();
		
		// the option jewelry is called up on the menu bar
		generelPage.selectMenuItem("JEWELRY");
		//generelPage.selectMenuBarObject(5);
			
		// The desired product is filtered here according to various criteria
		productPage.selectSortBy("Price: Low to High");
		// here the Displayperpage is selected
		productPage.selectDisplayPerPage("12");
	    // here the view is selected
		productPage.selectViewAs("List");
	    // the desired product is clicked
		productPage.CreateYourOwnJewelryProduct();
		// the product is configured according to request 
		productPage.selectMaterialOwnJewelry("Silver (1 mm)");
		// the product is selected according to desire 
		productPage.LenghtInCmField("30 cm");
		// Here the radio button is selected 
		// 0=Ladybug  1=Heart   2=Star  3=None
		productPage.selectRadioOption(2);
		// Here enter the desired number of the product and added to wish list
		productPage.SelectQtyField("5");
		// Product is packed in the shopping cart
		productPage.ClickAddToCartBtn();
	
		// shopping cart is called
		generelPage.selectHeaderLink(2);
		
		/* Here the number of the product is increased to 10 and then the country and city with 
		zip code is selected and the AGB checkbox is selected and the check-out button is confirmed */ 
		shoppingCartPage.SelectCountryDropDown("Germany");
		shoppingCartPage.PostalCodeField("22115");		
		shoppingCartPage.EstimateShippingBtn();		
		shoppingCartPage.AgreeCheckBox();		
		shoppingCartPage.CheckOutBtn();
		
		// the billing address fields are filled in here with DataFaker
		billingAdressPage.SelectBillingAdress("New Address");
		billingAdressPage.fillBillingAddressForm();
		billingAdressPage.BillingAdressCountinueBtn();
		
	    // it is pressed on the continue button on the shippingadresspage 
		shippingAdressPage.ShippingContinueBtn();
		
	    // here first the shipping time is selected then the payment method (cash) 
		// then you confirm the order 
		paymentMethodPage.ShippingOptionNextDay();
	    paymentMethodPage.ShippingMethodContinueBtn();
	    paymentMethodPage.PaymentMethodCash();
	    paymentMethodPage.PaymentMethodContinueBtn();
	    paymentMethodPage.PaymentMethodInfoContinueBtn();
	    paymentMethodPage.ConfirmBtn();
	    paymentMethodPage.CompletedBtn();
	    // the last thing to do is to log off the user 
	    generelPage.selectHeaderLink(1);
	    
	    // Assert
	}
}   
		 


