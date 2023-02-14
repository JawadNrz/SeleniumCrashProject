package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import fixtures.Utilities;

public class WishListPage extends Utilities {

	private WebDriver driver; 

	
	// Remove CheckBox
	@FindBy(xpath = "//input[@name='removefromcart']")
	private WebElement removeFromWishlistCheckbox;
	
	// Add to cart Checkbox on WishlistPage
	@FindBy(xpath = "//input[@name='removefromcart']")
	private WebElement addToCartFromWishlistCheckbox;
	
	// Update wishList Button
	@FindBy(xpath = "//input[@name='updatecart']")
	private WebElement updateCartFromWishlistBtn;
	
	// Add to Cart Button on WishlistPage
	@FindBy(xpath = "//input[@name='addtocartbutton']")
	private WebElement addToCartFromWishlistBtn;
	
	// Email a friend Button on WishlistPage
	@FindBy(xpath = "//input[@value='Email a friend']")
	private WebElement emailAFirendFromWishlistBtn;
	
	// The wishlist URL for sharing
	@FindBy(xpath = "//a[@class='share-link']")
	private WebElement sharingLinkFromWishlist;
	
	// number of articles
	@FindBy(css = "input[value='1']")
	private WebElement numberOfArticlesFromWishlist;
	
	// Confirmation message for deleting an item from wishlist  
	@FindBy(css = ".wishlist-content")
	private WebElement assertMessageDeleteItem;
	
	
	// Methods
	
	public WishListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void RemoveCheckbox() {
		waitForElement(removeFromWishlistCheckbox, 4);
		removeFromWishlistCheckbox.click();
	}
	
	public void AddToCartCheckBox() {
		waitForElement(addToCartFromWishlistCheckbox, 2);
		addToCartFromWishlistCheckbox.click();
	}
	
	public void UpdateCartBtn() {
		waitForElement(updateCartFromWishlistBtn, 3);
		updateCartFromWishlistBtn.click();
	}
	
	public void EmaiAFriendBtn() {
		waitForElement(emailAFirendFromWishlistBtn, 2);
		emailAFirendFromWishlistBtn.click();
	}
	
	public void SharingLink() {
		waitForElement(sharingLinkFromWishlist, 2);
		sharingLinkFromWishlist.click();
	}
	
	public void NumberOfArticles(String ArticleNbr) {
		waitForElement(numberOfArticlesFromWishlist, 4);
		numberOfArticlesFromWishlist.sendKeys(ArticleNbr);
	}
	
	public String AssertMessageDeleteItemFromWishlist() {

		return assertMessageDeleteItem.getText();
	}
}


