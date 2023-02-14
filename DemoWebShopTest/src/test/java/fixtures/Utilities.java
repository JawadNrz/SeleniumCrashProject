package fixtures;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	 protected WebDriver driver;
	 private WebDriverWait wait;
	
	public Utilities(WebDriver driver) {
	    this.driver = driver;
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  }
	  
	  public void waitForElement(WebElement element, int timeInSeconds) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
	    wait.until(ExpectedConditions.visibilityOf(element));
	  }

}
