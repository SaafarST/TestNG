package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigsReader;

import static utils.BaseClass.*;
public class LoginTest {
   @Test
    public void validAdminLogin(){
       var loginPage = new LoginPage();
       sendText(loginPage.username, ConfigsReader.getProperties("username"));
       sendText(loginPage.password, ConfigsReader.getProperties("password"));
       click(loginPage.loginBtn);

       var dashboardPage = new DashboardPage();
       String expectedValue = "Welcome Admin";
       String actualValue = dashboardPage.welcome.getText();
       Assert.assertEquals(actualValue,expectedValue,"'Welcome Admin' text is incorrect");
   }
   @Test
    public void validUserInvalidPassword(){
       String invalidPassword = "MineLibe";
       String expectedErrorMessage = "Invalid credentials";
       var loginPage = new LoginPage();
       sendText(loginPage.username, ConfigsReader.getProperties("username"));
       sendText(loginPage.password, invalidPassword);
       click(loginPage.loginBtn);
       Assert.assertEquals(loginPage.loginErrorMessage,expectedErrorMessage,"Error message is incorrect.");

   }
}
