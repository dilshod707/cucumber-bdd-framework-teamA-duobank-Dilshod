package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.MortgageApplicationPage;
import pages.PersonalInfoPage;
import pages.PreApprovalPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class PersonalInfoStep {


    @Given("User on personal info page")
    public void user_on_personal_info_page() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsername().sendKeys(ConfigReader.getProperty("username"));
        loginPage.getPassword().sendKeys(ConfigReader.getProperty("password"));
        loginPage.getSingInButton().click();
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.getMortgageApplicationLink().click();
        SeleniumUtils.waitFor(2);


        Faker faker = new Faker();
        PreApprovalPage preApprovalPage = new PreApprovalPage();
        if (!preApprovalPage.getRealterCheckbox().isSelected()) {
            preApprovalPage.getRealterCheckbox().click();

        } else {
            System.out.println("Checkbox already checked");
        }
        preApprovalPage.getRealtorInfo().sendKeys(faker.name().fullName() + " ");
        preApprovalPage.getRealtorInfo().sendKeys(faker.internet().emailAddress());



        if (!preApprovalPage.getCheckboxLoanOfficer().isSelected()) {
            preApprovalPage.getCheckboxLoanOfficer().click();
        } else {
            System.out.println("Checkbox already checked");
        }

        SeleniumUtils.waitFor(1);

        preApprovalPage.getEstimatedPrice().sendKeys("620000");
        preApprovalPage.getDownPayment().sendKeys("25000", Keys.TAB, Keys.ENTER);
        preApprovalPage.getNextButton().click();
        SeleniumUtils.waitFor(2);
    }
    @When("User completes full personal info")
    public void user_completes_full_personal_info() {
        Faker faker = new Faker();
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.getFirstName().sendKeys(faker.name().firstName());
        personalInfoPage.getLastName().sendKeys(faker.name().lastName());
        personalInfoPage.getEmail().sendKeys(faker.internet().emailAddress());
        personalInfoPage.getDob().sendKeys("03121988");
        SeleniumUtils.waitFor(1);
        personalInfoPage.getSsn().sendKeys("777225555");

        personalInfoPage.getMaritalStatus().click();
        SeleniumUtils.waitFor(2);
        personalInfoPage.getSearchMarried().sendKeys("Married", Keys.ENTER);
        personalInfoPage.getCellPhone().sendKeys(faker.phoneNumber().cellPhone());



//        WebElement dropdownElement = personalInfoPage.getMaritalStatus();
//        Select select = new Select(dropdownElement);
//        select.selectByVisibleText("Married");
//        select.selectByIndex(1);
//
//        personalInfoPage.getPrivacyCheckbox().click();
        personalInfoPage.getNextButton().click();
//




    }
    @Then("User should be able to move expense page")
    public void user_should_be_able_to_move_expense_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
    }
}
