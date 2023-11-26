package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class LoanAppFillOutPage {

    public LoanAppFillOutPage(){
        PageFactory.initElements(Driver.getDriver(), this);}

//    @FindBy(linkText = "Employment and Income")
    @FindBy(xpath = "(//span[@class=\"d-block\"])[4]")
    private WebElement employementButton;

    @FindBy(id = "estimatedprice-error")
    private WebElement thisFieldisRequired;




}
