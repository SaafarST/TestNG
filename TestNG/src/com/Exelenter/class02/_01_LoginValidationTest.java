package com.Exelenter.class02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static utils.BaseClass.*;

public class _01_LoginValidationTest {
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

    }

    @Test
    void validLoginTest(){

    }
}
