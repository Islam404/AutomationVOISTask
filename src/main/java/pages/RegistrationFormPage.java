package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.PageBase;

public class RegistrationFormPage extends PageBase {
	
	public RegistrationFormPage(WebDriver driver) {
		super(driver);
	}

	//Select drpCountry = new Select(driver.findElement(By.id("country")));
	
	
	By firstNameTextbox = By.name("customer_firstname");
	By lastNameTextbox = By.name("customer_lastname");
	By passwordTextBox = By.name("passwd");
	By adressFirstNameTextbox = By.name("firstname");
	By adressLastNameTextbox = By.name("lastname");
	By adressLineTextbox = By.name("address1");
	By cityTextbox = By.name("city");
	By stateDropDownList = By.id("id_state");
	By zipCodeTextbox = By.id("postcode");
	By countyDropList = By.id("id_country");
	By phoneMobileTextBox = By.name("phone_mobile");
	By adressAliasTextBox = By.name("alias");
	By registeButton = By.xpath("//button[@id='submitAccount']");
	
	
	public void FillRegisterationForm(String firstName ,String lastName , String password,String adress, String adressLastName, String adressLine , 
			String city , String state,String zipCode , String country, String phone, String adress2) {		
		
		selectItemFromList(driver,stateDropDownList,state);
		selectItemFromList(driver,countyDropList,country);
		setElement(firstNameTextbox,firstName);
		setElement(lastNameTextbox,lastName);
		setElement(passwordTextBox,password);
		setElement(adressFirstNameTextbox,adress);
		setElement(adressLastNameTextbox,adressLastName);
		setElement(adressLineTextbox,adressLine);
		setElement(cityTextbox,city);
		setElement(zipCodeTextbox,zipCode);
		setElement(phoneMobileTextBox,phone);
		setElement(adressAliasTextBox,adress2);	
	}
	
	public void clickRegister() {
		clickElement(registeButton);
	}
}
