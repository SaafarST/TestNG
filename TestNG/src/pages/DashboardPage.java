package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.BaseClass.driver;

public class DashboardPage {
    @FindBy(id = "welcome")
    public WebElement welcome;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
