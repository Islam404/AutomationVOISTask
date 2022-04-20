package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class HistoryPage extends PageBase {

	public HistoryPage(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean isSameReference() {
		return isElementVisible(By.xpath("//td//a[contains(text(),\""+ConfirmationPage.reference_value+"\")]"));
		
	}

}
