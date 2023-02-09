package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigsReader;

import static utils.BaseClass.*;
import static utils.CommonMethods.sendText;

// Note: This is just a template for LoginPage where we store everything related to Login page here, in this class.
//  In Page Object Model (Design Pattern), we organize our code by pages. Each web page will have their own class.
public class LoginPage {

    @FindBy(id = "txtUsername")
    public WebElement username;

    public @FindBy(name = "txtPassword")
    WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(css = "#divLogo img")
    public WebElement homepageLogo;
    @FindBy(id = "spanMessage")
    public WebElement loginErrorMessage;
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void loginToWebsite(String user, String pwd){
        sendText(this.username, user);
        sendText(this.password, pwd);
        click(this.loginBtn);
    }
}
