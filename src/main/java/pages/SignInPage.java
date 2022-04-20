package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.PageBase;

public class SignInPage extends PageBase {
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}

	
	
	By EmaiTextbox = By.name("email_create");
	By Submit_Button = By.name("SubmitCreate");
	
	
	public void Register(String mail) {
	setElement(EmaiTextbox, mail);
		clickElement(Submit_Button);			
	}
}
