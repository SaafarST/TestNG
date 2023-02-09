package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddEmployeePage;
import pages.LoginPage;
import pages.PIMPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class addEmployeeTest extends BaseClass {
    @BeforeMethod
    void startBrowser() {
        setUp();
    }
    @AfterMethod
    void quitBrowser() {
        tearDown();
    }
    @Test
    public void addEmployeeTest(){
        var loginPage = new LoginPage();// Happy Path Testing
        loginPage.loginToWebsite(ConfigsReader.getProperties("username"),ConfigsReader.getProperties("password"));

        PIMPage pimPage = new PIMPage();
        pimPage.navigateToAddEmployee();

        AddEmployeePage addEmployee = new AddEmployeePage();
        String name = "Eva";
        String surname = "Brown";
        sendText(addEmployee.firstName,name);
        sendText(addEmployee.lastName,surname);
        sendText(addEmployee.uploadPhoto, ConfigsReader.getProperties("filePath"));
        click(addEmployee.saveButton);
    }
}
