package pageobject;

import org.openqa.selenium.WebDriver;

public class LoginData {

	private String username = "jawad.norosi@hotmail.com";
    private String password ="Qualistackbestefirma23";

    public void LoginData() {
       
    }

    public LoginData(WebDriver driver) {
		
	}

	public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
	
}
