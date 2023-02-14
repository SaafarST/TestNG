package com.Exelenter.class03;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

/**
 *  Task: Hard Assert & Soft Assertion
 *    Hard Assert
 *       1. Go to exelentersdet.com website
 *       2. Get the title of the webpage, change it to false, fail this test step intentionally
 *       3. Login to the website. You should NOT be able to login
 *    Now, comment out Hard Assert, and use soft Assert instead.
 *       4. Using Soft Assert, try to login to the website.
 *    You should be able to login, even if the title verification (previous step) fails.
 */
public class _00_Assert_HW extends BaseClass {

    @Test
    void hardAssert(){
        String expectedTitle = "Exelenter Project!";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Exelenter Project is wrong.");

        loginPage.loginToWebsite("username","password");
    }
    @Test
    void softAssert(){

        SoftAssert softAssert = new SoftAssert();

        String expectedTitle = "Exelenter Project!";
        String actualTitle = driver.getTitle();

        softAssert.assertEquals(actualTitle,expectedTitle,"Exelenter Project is wrong.");

        loginPage.loginToWebsite("username","password");
        softAssert.assertAll();

    }

}
