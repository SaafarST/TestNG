package com.Exelenter.class02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigsReader;

import static utils.BaseClass.*;

public class _01_LoginValidation {
    /**
     * Todo: We will copy from Selenium Project following folders & packages:
     *    1. utils package ok
     *    2. page package ok
     *    3. test package ok
     *    4. Selenium JARs.
     *    5. Drivers folder ok
     *    6. configs folder ok
     */

    @BeforeMethod
    void openBrowser(){
        setUp();
    }
    @AfterMethod
    void afterMethod(){
        tearDown();
    }

    @Test
    void titleValidation(){
        String expectedTitle = "Exelenter Project";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle))
            System.out.println("Title matches, Test passed.");
        else
            System.out.println("Title does not match, Test failed.");

    }
    @Test
    void logoValidation(){

        LoginPage loginPage = new LoginPage();

        if (loginPage.homepageLogo.isDisplayed()) {
            System.out.println("Logo is displayed, Test passed.");
        }else {
            System.out.println("Logo is not displayed, Test failed.");
        }
    }

    @Test
    void validLoginTest(){

        LoginPage loginPage = new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        sendText(loginPage.password, ConfigsReader.getProperties("password"));
        click(loginPage.loginBtn);

        DashboardPage dashboardPage = new DashboardPage();
        String expectedValue = "Welcome Admin";
        String actualValue = dashboardPage.welcome.getText();

        if (expectedValue.equals(actualValue))
            System.out.println("Login successful.");
        else
            System.out.println("Login failed.");


        if (dashboardPage.welcome.isDisplayed()) {
            System.out.println("Login successful. Test is passed.");
        }else {
            System.out.println("Login failed. Test failed.");
        }

    }
}
