package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class ShoppingPage extends PageBase{

	public ShoppingPage(WebDriver driver) {
		super(driver);
		
	}
	
	By blouse_btn=By.xpath("//h5//a[@title=\"Blouse\"]");
	By addToCart_Btn=By.xpath("//button[@name=\"Submit\"]");
	By proceed_checkout_Btn=By.xpath("//a[@title=\"Proceed to checkout\"]");
	public void selectBlouse(){
		clickElement(blouse_btn);
		clickElement(addToCart_Btn);
		clickElement(proceed_checkout_Btn);
	}

}
