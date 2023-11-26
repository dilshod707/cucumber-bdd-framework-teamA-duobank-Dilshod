package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoanAppFillOutPage;
import pages.LoginPage;
import pages.MortgageApplicationPage;
import utils.ConfigReader;
import utils.SeleniumUtils;

public class LoanAppFillOutStep {
    @Given("User in logged in Mortgage application page")
    public void user_in_logged_in_mortgage_application_page() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsername().sendKeys(ConfigReader.getProperty("username"));
        loginPage.getPassword().sendKeys(ConfigReader.getProperty("password"));
        loginPage.getSingInButton().click();
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.getMortgageApplicationLink().click();
        SeleniumUtils.waitFor(3);
    }
    @When("User tries to navigate to Employement and Income window")
    public void user_tries_to_navigate_to_employement_and_income_window() {

        LoanAppFillOutPage loanAppFillOutPage = new LoanAppFillOutPage();
        loanAppFillOutPage.getEmployementButton().click();
    }
    @Then("User gets error this field is required message on many fields")
    public void user_gets_error_this_field_is_required_message_on_many_fields() {
        LoanAppFillOutPage loanAppFillOutPage = new LoanAppFillOutPage();
        System.out.println(loanAppFillOutPage.getThisFieldisRequired().getText());
        Assert.assertTrue(loanAppFillOutPage.getThisFieldisRequired().isDisplayed());

    }


    @When("User fillouts personal information for loan")
    public void user_fillouts_personal_information_for_loan() {

       Faker faker = new Faker();

    }
    @When("User clicks on Next button")
    public void user_clicks_on_next_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User should land in Expenses Page")
    public void user_should_land_in_expenses_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
