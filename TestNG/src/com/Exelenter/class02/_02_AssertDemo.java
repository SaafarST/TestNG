package com.Exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _02_AssertDemo extends BaseClass {
    /**
     * TC 01: Login Validation Test (Happy Path)
     *   1. Open Chrome browser
     *   2. Go to https://exelentersdet.com
     *   3. Enter valid username and valid password
     *   4. Click on login button
     *   5. Verify login is successful
     *   6. Close the browser
     *
     * TC 02: Login Validation Test (Negative Test)
     *    1. Open Chrome browser
     *    2. Go to http://exelentersdet.com
     *    3. Enter valid username
     *    4. Leave password field empty
     *    5. Verify error message with text “Password cannot be empty” is displayed.
     */
    @BeforeMethod
    void beforeMethod(){
        setUp();
    }
    @AfterMethod
    void afterMethod(){
        tearDown();
    }
    @Test
    void validLoginTest(){
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        sendText(loginPage.password, ConfigsReader.getProperties("password"));
        click(loginPage.loginBtn);

        //Validation
        DashboardPage dashboard = new DashboardPage();
        String expectedValue = "Welcome Admin";
        String actualValue = dashboard.welcome.getText();
        Assert.assertEquals(actualValue,expectedValue,"Test is unsuccessful!");// Message is optional and prints only if the test fails.

    }

    @Test
    void invalidLoginTest(){
        String expectedErrorText = "Password cannot be empty";
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.username,ConfigsReader.getProperties("username"));
        clickButWaitForClickability(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(),expectedErrorText,"Message ERROR is incorrect.");
    }
}
