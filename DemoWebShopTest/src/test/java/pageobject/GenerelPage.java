package pageobject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import fixtures.Utilities;

public class GenerelPage extends Utilities{

	
	private WebDriver driver; 
	

	// DemoWebShop Logo on the HomePage
	@FindBy(css = "img[alt='Tricentis Demo Web Shop']")
	private WebElement homePageBtn;
	
	// Wishlist 
	@FindBy(xpath = "//span[normalize-space()='Wishlist']")
	private WebElement wishList;
	
	// Shopping Cart Button on HomePage
	@FindBy(css = ".Shopping cart")
	private WebElement shoppingCart;
	
	// LogOut Button on the HomePage
	@FindBy(xpath ="//a[@class='ico-logout']")
	private WebElement logOutBtn;
	
	// RegisterBtn
	@FindBy(className = "ico-register")
	private WebElement reigsterBtn;
	
	// My account - Customer info - Email Button on HomePage
	@FindBy(css = ".account")
	private WebElement customerInfoBtn;
	
	// Search Store / Search Box 
	@FindBy(id = "small-searchterms")
	private WebElement searchStore;
	
	// Search Button on the HomePage
	@FindBy(css = ".search-box-button")
	private WebElement searchBtn;
	
	//Menu Bar 
	@FindBy(css = "ul.top-menu li a")
	public List<WebElement> menuBarObjects;
	
	//Menu Bar 
	@FindBy(css = "div.header-links ul li a")
	public List<WebElement> headerLink;
	
	//@FindBy(xpath = "//ul[@class='top-menu']/li/a")
	  //private WebElement menuBarObjects;


	public GenerelPage(WebDriver driver) {
		super(driver);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	
		}
	

	public void HomePageLogo() {
		waitForElement(homePageBtn, 2);
		homePageBtn.click();
	}
	
	public void SearchBtn() {
		waitForElement(searchBtn, 5);
		searchBtn.click();
	}
		
	public void SearchStore(String name) {
		waitForElement(searchStore, 5);
		searchStore.sendKeys(name);
	}
	
	public void selectMenuItem(String visibleText) {
        for (WebElement item : menuBarObjects) {
            if (item.getText().equals(visibleText)) {
                item.click();
                break;
            }
        }
    } 

	public void selectHeaderLink(int index) {
		headerLink.get(index).click();
	  }

	public void selectHeaderLinks() {
		int menuButtonCount = headerLink.size();
			for (int i = 0; i < menuButtonCount; i++) {
				selectHeaderLink(i);
			}

		}
	}

// das ist eine Methode( for loop) um Elemente dynamisch aufzurufen mithilfe von Index!
	/*
	public void selectMenuBarObject(int index) {
		    menuBarObjects.get(index).click();
		  }
	
	public void selectMenuBarObjects() {
        int menuButtonCount = menuBarObjects.size();
        for (int i = 0; i < menuButtonCount; i++) {
            selectMenuBarObject(i);
        }
    }*/
		
	
	   

	      
	    
	    
	
	
		
	
	

