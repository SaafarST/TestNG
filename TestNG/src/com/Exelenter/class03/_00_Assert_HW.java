package com.Exelenter.class03;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseClass;

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
        LoginPage loginPage = new LoginPage();
        String expectedTitle = "Exelenter Project";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Exelenter Project is wrong.");

    }


}
