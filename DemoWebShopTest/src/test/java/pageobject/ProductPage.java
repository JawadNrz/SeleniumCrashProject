package pageobject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import fixtures.Utilities;

public class ProductPage extends Utilities {

	private WebDriver driver; 
	
	   // We can use this options for every Class on our Projects
	   // ViewAs DropDown For All Products 
	   @FindBy(id = "products-viewmode")
	   WebElement viewAs;
	   // OrderBy DropDown for All Products 
	   @FindBy(id = "products-orderby")
	   WebElement sortBy;
	   // PageSize DropDown for All Products 
	   @FindBy(id = "products-pagesize")
	   WebElement displayPerPage;
	   
	   // from here on everything belongs to a certain product
	   // ProductName: Create Your Own Jewelry
	   @FindBy(xpath = "//div[@class='product-item']//img[@title='Show details for Create Your Own Jewelry']")
	   WebElement createYourJewelryProduct;
	
	   // Material DropDown on Create Your Own Jewelry Page
	   @FindBy(id = "product_attribute_71_9_15")
	   WebElement materialDropDown;
	
	   @FindBy(id = "product_attribute_71_10_16")
	   WebElement lengthInCmField;
	   
	   // Pendant RadioButtons 
	    @FindBy(xpath = "//input[@type='radio']")
	    public List<WebElement> radioButtons;
	   
	    // 
	    @FindBy(id = "addtocart_71_EnteredQuantity")
	    WebElement qtyNumberJewelry;
	    
	    @FindBy(id = "add-to-wishlist-button-71")
	    WebElement addToWishlistBtn;
	    
	    // Add your review Button
	    @FindBy(xpath = "//a[normalize-space()='Add your review']")
	    WebElement addYourReviewBtn;
	    
	    // Add to Cart Button 
	    @FindBy(className = "add-to-cart-button")
	    WebElement addToCartBtn;
	    // up to here
	    
	    
	   
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	  public void selectSortBy(String visibleText) {
		  waitForElement(sortBy, 5);
	      Select sortBySelect = new Select(sortBy);
	      sortBySelect.selectByVisibleText(visibleText);
	   }

	   public void selectDisplayPerPage(String visibleText) {
		  waitForElement(displayPerPage, 5);
	      Select displayPerPageSelect = new Select(displayPerPage);
	      displayPerPageSelect.selectByVisibleText(visibleText);
	   }
	   public void selectViewAs(String visibleText) {
		   waitForElement(viewAs, 5);
		   Select viewAsSelect = new Select(viewAs);
		   viewAsSelect.selectByVisibleText(visibleText);
	   }
	
	   public void CreateYourOwnJewelryProduct() {
		   waitForElement(createYourJewelryProduct, 5);
		   createYourJewelryProduct.click();
	   }
	   
	   public void selectMaterialOwnJewelry(String visibleText) {
		   waitForElement(materialDropDown, 5);
		   Select materialSelect = new Select(materialDropDown);
		   materialSelect.selectByVisibleText(visibleText);
	   }
	
	   public void LenghtInCmField(String cm) {
		   waitForElement(lengthInCmField, 5);
		   lengthInCmField.sendKeys(cm);
	   }
	   
	   public void selectRadioOption(int index){
	        radioButtons.get(index).click();
	    }

	    public void selectAllRadioOptions() {
	        int radioButtonCount = radioButtons.size();
	        for (int i = 0; i < radioButtonCount; i++) {
	            selectRadioOption(i);
	        }
	    }
	    
	    public void SelectQtyField(String number) {
	    	waitForElement(qtyNumberJewelry, 4);
	    	qtyNumberJewelry.clear();
	    	qtyNumberJewelry.sendKeys(number);
	    }
	    
	    public void ClickOnAddToWishListBtn() {
	    	waitForElement(addToWishlistBtn, 4);
	    	addToWishlistBtn.click();
	    	
	    }
	    
	    public void ClickOnAddYourReview() {
	    	waitForElement(addYourReviewBtn, 4);
	    	addYourReviewBtn.click();
	    }
	    	
	    public void ClickAddToCartBtn() {
	    	waitForElement(addToCartBtn, 5);
	    	addToCartBtn.click();
	    	
	    }
	    
	}
	   
	  
	
	   
	

