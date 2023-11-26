package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class SignupPage {

    public SignupPage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(linkText = "Sign up")
    private WebElement signupButton;

    @FindBy(id = "inputfirstname4")
    private WebElement firstName;

    @FindBy(id = "inputlastname4")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "register")
    private WebElement registerButton;

    @FindBy(id = "exampleInputPassword1")
    private WebElement password;

    @FindBy(id = "emailerror")
    private WebElement emailError;

public void signupWithValidData(){
    Faker faker = new Faker();
    String generatedPassword;
    String generatedEmail;
    String generatedFirstName;
    String generatedLastName;


    do {
        generatedPassword = faker.internet().password(8, 50, true, true);
    } while (!(generatedPassword.length() >= 8 && generatedPassword.matches(".*[A-Z].*") && generatedPassword.matches(".*\\d.*")));

    do {
        generatedFirstName = faker.name().firstName();
    } while (!(generatedFirstName.length() <= 50 && generatedFirstName.matches("[a-zA-Z ]+")));

    do {
        generatedLastName = faker.name().lastName();
    } while (!(generatedLastName.length() <= 50 && generatedLastName.matches("[a-zA-Z ]+")));

//    do {
//        generatedEmail = faker.internet().emailAddress();
//    } while (!(generatedEmail.length() < 255 && generatedEmail.matches(".*[A-Z].*") && generatedEmail.matches(".*\\d.*")));


    firstName.sendKeys(generatedFirstName);
    lastName.sendKeys(generatedLastName);
    email.sendKeys(faker.internet().emailAddress());
    password.sendKeys(generatedPassword);
    registerButton.click();
}

public void signupWithExistEmail(){
    Faker faker = new Faker();
    String generatedPassword;
    String generatedFirstName;
    String generatedLastName;


    do {
        generatedPassword = faker.internet().password(8, 50, true, true);
    } while (!(generatedPassword.length() >= 8 && generatedPassword.matches(".*[A-Z].*") && generatedPassword.matches(".*\\d.*")));

    do {
        generatedFirstName = faker.name().firstName();
    } while (!(generatedFirstName.length() <= 50 && generatedFirstName.matches("[a-zA-Z ]+")));

    do {
        generatedLastName = faker.name().lastName();
    } while (!(generatedLastName.length() <= 50 && generatedLastName.matches("[a-zA-Z ]+")));


    firstName.sendKeys(generatedFirstName);
    lastName.sendKeys(generatedLastName);
    email.sendKeys("davidme1988@gmail.com");
    password.sendKeys(generatedPassword);


}

}
