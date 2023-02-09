package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class AddEmployeePage extends BaseClass {
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(id = "employeeId")
    public WebElement employeeId;
    @FindBy(id = "photofile")
    public WebElement uploadPhoto;
    @FindBy(id = "btnSave")
    public WebElement saveButton;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }


}