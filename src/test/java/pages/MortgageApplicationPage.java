package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class MortgageApplicationPage {


    public MortgageApplicationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Mortgage Application")
    private WebElement mortgageApplicationLink;

    @FindBy(xpath = "//h5[@class=\"content-header-title float-left pr-1 mb-0\"]")
    private WebElement newMortgageAppPage;

    @FindBy(linkText = "Application List")
    private WebElement applicationListLink;

    @FindBy(xpath = "//h4[@class='card-title']")
    private WebElement appListPage;
}
