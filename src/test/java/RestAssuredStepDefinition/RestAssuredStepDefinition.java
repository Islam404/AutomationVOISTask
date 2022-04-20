package RestAssuredStepDefinition;

import java.util.List;
import java.util.Random;

import org.junit.Assert;

import RestAssured.ColorLovers;
import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.ConfirmationPage;
import pages.HistoryPage;
import pages.HomePage;
import pages.RegistrationFormPage;
import pages.ShoppingPage;
import pages.SignInPage;
import pages.MyAccountPage;

public class RestAssuredStepDefinition {
	
ColorLovers color = new ColorLovers();
Response response ;

@When("^user try to GET Correct URL$")
public void user_try_to_get_correct_url() {
  response =color.getResponseFromURI();

}

@Then("^user gets  total numviews to be greater than (.+)$")
public void user_gets_total_numviews_to_be_greater_than(String number) {
	
	int referanceNumber = Integer.parseInt(number);
	
List <String> numviewslist = color.parseResponse(response);

Assert.assertEquals(color.isNumViewsValueGreater(referanceNumber, numviewslist), true);
}

}
