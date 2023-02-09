package test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigsReader;

import static utils.BaseClass.*;
public class LoginTest {
    /**
     *  US 16457: As an Admin User, I should not be able to login to the application using invalid credentials.    <== High Level explanation of the feature.
     */
    @BeforeMethod
    void startBrowser() {
        setUp();
    }
    @AfterMethod
    void quitBrowser() {
        tearDown();
    }
   @Test
    public void validAdminLogin(){

       sendText(loginPage.username, ConfigsReader.getProperties("username"));
       sendText(loginPage.password, ConfigsReader.getProperties("password"));
       click(loginPage.loginBtn);

       String expectedValue = "Welcome Admin";
       String actualValue = dashboardPage.welcome.getText();
       Assert.assertEquals(actualValue,expectedValue,"'Welcome Admin' text is incorrect");
   }
   @Test
    public void validUserInvalidPassword(){
       String invalidPassword = "MineLibe";
       String expectedErrorMessage = "Invalid credentials";

       sendText(loginPage.username, ConfigsReader.getProperties("username"));
       sendText(loginPage.password, invalidPassword);
       click(loginPage.loginBtn);
       Assert.assertEquals(loginPage.loginErrorMessage,expectedErrorMessage,"Error message is incorrect.");
   }
    @Test
    public void validUserEmptyPassword() {
        String expectedErrorMessage = "Password cannot be empty";

        sendText(loginPage.username, ConfigsReader.getProperties("username"));   // Valid Username, Password empty (skipped).
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(),expectedErrorMessage, "Error message is incorrect");
    }
}
