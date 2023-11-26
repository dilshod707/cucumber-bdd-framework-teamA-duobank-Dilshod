package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(id = "exampleInputEmail1")
    private WebElement username;

    @FindBy(id = "exampleInputPassword1")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement singInButton;

    @FindBy(xpath = "//div[@class='card-title']")
    private WebElement loginFailed;
}
