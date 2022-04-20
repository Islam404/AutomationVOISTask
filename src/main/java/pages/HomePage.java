package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.PageBase;

public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	
	By signIn_Button = By.xpath("//a[contains(text(),'Sign in')]");
	
	
	
	public void SignIn() {
			
		clickElement(signIn_Button);			
	}
}
