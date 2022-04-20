package stepDefinitions;

import java.util.Random;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ConfirmationPage;
import pages.HistoryPage;
import pages.HomePage;
import pages.RegistrationFormPage;
import pages.ShoppingPage;
import pages.SignInPage;
import pages.MyAccountPage;

public class StepDefinitions extends TestBase{
	
	HomePage HomePage;
	SignInPage SignInPage;
	RegistrationFormPage RegistrationFormPage;
	MyAccountPage MyAccountPage;
	ShoppingPage shoppingPage;
	ConfirmationPage confirmationPage;
	HistoryPage historyPage;
	
	


@When("^user click on sign in to start Registration process$")
public void user_click_on_sign_in_to_start_registration_process() {
	
	HomePage = new HomePage(driver);
	HomePage.SignIn();
}

@And("^Provide valid (.+) to start the signup process$")
public void provide_valid_to_start_the_signup_process(String email) throws Throwable {
	Random rand = new Random();
	
	SignInPage = new SignInPage(driver);
	SignInPage.Register(email+ rand.nextInt(1000)+"@yahoo.com");
}

@Then("^SignUp Page is loaded$")
public void signup_page_is_loaded()  {
	
	RegistrationFormPage = new RegistrationFormPage(driver);
	
}

@And("^User Fill All The manadatory fields in the signup page like (.+), (.+), (.+), (.+), (.+), (.+), (.+), (.+), (.+), (.+), (.+), (.+)$")
public void user_fill_all_the_manadatory_fields_in_the_signup_page_like_(String firstname, String lastname, String password, String adress, String adresslastname, String adressline, String city, String state, String zipcode, String country, String phone, String adress2) {
	RegistrationFormPage.FillRegisterationForm(firstname, lastname, password, adress, adresslastname, adressline, city, state, zipcode, country, phone, adress2);
	RegistrationFormPage.clickRegister();
}
@Then("^Validate for Welcome Text Message$")
public void validate_for_welcome_text_message()  {
	MyAccountPage = new MyAccountPage(driver);
    Assert.assertEquals(MyAccountPage.checkRegistrationStatus(), true);
	
}

@Then("^select blouse from women section$")
public void select_blouse_from_women_section()  {
	MyAccountPage.selectBlouse();
	shoppingPage=new ShoppingPage(driver);
	shoppingPage.selectBlouse();
}
@Then("^user proceed to checkout$")
public void user_proceed_to_checkout() {
	confirmationPage=new ConfirmationPage(driver);
	confirmationPage.proceedToCheckout();
}
@Then("^Validate the reference is the same reference from checkout page$")
public void validate_the_reference_is_the_same_reference_from_checkout_page()  {
	
   historyPage=new HistoryPage(driver);
   Assert.assertEquals(historyPage.isSameReference(), true);
}

}
