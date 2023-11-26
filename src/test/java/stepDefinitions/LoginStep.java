package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class LoginStep {

    @Given("The user is on login page")
    public void the_user_is_on_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("The user fills up valid {string} and {string}")
    public void the_user_fills_up_valid_username_and_password(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsername().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        loginPage.getSingInButton().click();
    }
    @Then("user should be able to navigate to homepage")
    public void user_should_be_able_to_navigate_to_homepage() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "Duobank Mortgage Application");
    }


    @When("The user enters invalid credentials")
    public void the_user_enters_invalid_credentials(DataTable dataTable) {

        List<List<String>> data = dataTable.cells();

        LoginPage loginPage = new LoginPage();
        loginPage.getUsername().sendKeys(data.get(0).get(0));
        loginPage.getPassword().sendKeys(data.get(0).get(1));
//        loginPage.getSingInButton().click();

    }
    @And("User clicks on sing in button")
    public void user_clicks_on_sing_in_button() {
        LoginPage loginPage = new LoginPage();
        loginPage.getSingInButton().click();
    }
    @Then("Error massage should appear")
    public void error_massage_should_appear() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.getLoginFailed().isDisplayed());
    }


}
