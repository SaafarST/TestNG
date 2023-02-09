package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
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
    }
}
