package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.MortgageApplicationPage;
import utils.ConfigReader;
import utils.Driver;

public class MortgageApplicationStep {


    @Given("User in logged in dashboard page and profile are displayed")
    public void user_in_logged_in_dashboard_page_and_profile_are_displayed() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsername().sendKeys(ConfigReader.getProperty("username"));
        loginPage.getPassword().sendKeys(ConfigReader.getProperty("password"));
        loginPage.getSingInButton().click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");
    }
    @When("User clicks on Mortgage Application")
    public void user_clicks_on_mortgage_application() {
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.getMortgageApplicationLink().click();
    }
    @Then("User should be taken new page where user can apply for mortgage")
    public void user_should_be_taken_new_page_where_user_can_apply_for_mortgage() {
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        Assert.assertTrue(mortgageApplicationPage.getNewMortgageAppPage().isDisplayed());
    }

//    @When("the user navigates to the dashboard page")
//    public void the_user_navigates_to_the_dashboard_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("the dashboard page should contain a link for {string}")
//    public void the_dashboard_page_should_contain_a_link_for(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


    @When("User clicks on Application List")
    public void user_clicks_on_application_list() {
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
     mortgageApplicationPage.getApplicationListLink().click();

    }
    @Then("User should be taken new page where user can see list")
    public void user_should_be_taken_new_page_where_user_can_see_list() {
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        Assert.assertTrue(mortgageApplicationPage.getAppListPage().isDisplayed());
    }



}
