package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.GenerelPage;

class SearchBarTest {
	
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
	void SearchBarTest1() {
		
		// Arrange
		GenerelPage generelPage = new GenerelPage(driver);
		
		// Act
		// call up the desired product via the search bar
		generelPage.SearchStore("SmartPhone");
		// click search bar button
		generelPage.SearchBtn();
	
		
	}
	
	@Test
	void SearchBarTest2() {
		
		// Arrange
		GenerelPage generelPage = new GenerelPage(driver);
	
		// Act
		// call up the desired product via the search bar
		generelPage.SearchStore(" BLUE AND GREEN SNEAKER");
		// click search bar button
		generelPage.SearchBtn();
	
	
	}

}

