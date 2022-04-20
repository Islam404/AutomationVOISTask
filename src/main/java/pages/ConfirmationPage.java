package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PageBase;

public class ConfirmationPage extends PageBase {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		
	}
By first_proceedToCheckoutButton=By.xpath("//a//span[text()=\"Proceed to checkout\"]");
By second_proceedToCheckoutButton=By.xpath("//button//span[text()=\"Proceed to checkout\"]");
By terms_checkBox=By.xpath("//label[@for=\"cgv\"]");
By third_proceedToCheckoutButton=By.xpath("//button[@name=\"processCarrier\"]");
By bankWire_Btn=By.xpath("//a[@class=\"bankwire\"]");
By confirm_order=By.xpath("//button//span[text()=\"I confirm my order\"]");
By back_to_order_btn=By.xpath("//a[@title=\"Back to orders\"]");
By reference=By.className("box");
static String reference_value=null;

public void proceedToCheckout() {
	clickElement(first_proceedToCheckoutButton);
	clickElement(second_proceedToCheckoutButton);
	clickElement(terms_checkBox);
	clickElement(third_proceedToCheckoutButton);

	clickElement(bankWire_Btn);
	clickElement(confirm_order);
	
	String value=getAttribute(driver, reference, "textContent");
	
	reference_value=value.substring(value.indexOf("reference")+10,value.indexOf("reference")+19);
	
	clickElement(back_to_order_btn);
	
	
	
}


}
