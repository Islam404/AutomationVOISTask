package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.PageBase;

public class MyAccountPage extends PageBase {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	
	
	By welcomeText = By.xpath("//p[contains(text(),'Welcome to your account')]");
	By womenBtn = By.xpath("//a[@title=\"Women\"]");
	By blousesBtn = By.xpath("//a[@title=\"Blouses\"]");
	
	public boolean checkRegistrationStatus() {
			
	return	isElementVisible(welcomeText);			
	}
	
	public void selectBlouse() {
		moveTo(driver,womenBtn);
		clickElement(blousesBtn);
	}
}
