package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignupPage;
import utils.Driver;

public class SignupStep {
    @Given("The user clicks on the sign up link")
    public void the_user_clicks_on_the_sign_up_link() {
        SignupPage signupPage = new SignupPage();
        signupPage.getSignupButton().click();
    }

    @When("The user fills up the fields with valid info")
    public void the_user_fills_up_the_fields_with_valid_info() throws InterruptedException {
        SignupPage signupPage = new SignupPage();
        signupPage.signupWithValidData();
        Thread.sleep(5000);
    }

    @Then("user should be able to navigate to login page")
    public void user_should_be_able_to_navigate_to_login_page() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "Login - Duobank URLA (Uniform Residential Loan Application) Mortgage Application");
    }


    @When("The user enters existing email")
    public void the_user_enters_existing_email() throws InterruptedException {
        SignupPage signupPage = new SignupPage();
//        signupPage.getSignupButton().click();
        signupPage.signupWithExistEmail();
        Thread.sleep(2000);
    }

    @Then("This email already used should be displayed")
    public void thisEmailAlreadyUsedShouldBeDisplayed() {
        SignupPage signupPage = new SignupPage();
        Assert.assertTrue(signupPage.getEmailError().isDisplayed());
    }
}
