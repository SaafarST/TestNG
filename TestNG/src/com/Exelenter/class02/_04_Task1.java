package com.Exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigsReader;

import static utils.BaseClass.setUp;
import static utils.BaseClass.tearDown;
import static utils.CommonMethods.click;
import static utils.CommonMethods.sendText;

public class _04_Task1 {
    /**
     * Task: Dashboard Logo Validation
     *       1. Using TestNG, login to ExelenterSdet.com website,
     *       2. Verify dashboard logo is displayed.
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
    void dashboardLogoValidation(){
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        sendText(loginPage.password, ConfigsReader.getProperties("password"));
        click(loginPage.loginBtn);

        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.dashboardLogo.isDisplayed(),"Dashboard logo is not displayed.");
    }

}
