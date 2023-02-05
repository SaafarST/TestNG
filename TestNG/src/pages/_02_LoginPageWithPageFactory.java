package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.BaseClass.driver;

// Note: This is just a template for LoginPage where we store everything related to Login page here, in this class.
//  In Page Object Model (Design Pattern), we organize our code by pages. Each web page will have their own class.
public class _02_LoginPageWithPageFactory {

    @FindBy(id = "txtUsername")
    public WebElement username;

    public @FindBy(name = "txtPassword")
    WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(css = "#divLogo img")
    public WebElement homepageLogo;

    public _02_LoginPageWithPageFactory() {
        PageFactory.initElements(driver,this);
    }
}
