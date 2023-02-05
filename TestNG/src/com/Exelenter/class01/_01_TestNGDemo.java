package com.Exelenter.class01;

import org.testng.annotations.*;

public class _01_TestNGDemo {

    /**
     *  TestNG Methods run by ascending order (alphabetically, alphanumeric).
     *  sayH  <=== this runs second
     *  sayB  <=== this runs first
     */
    @Test(priority = 1)
    public void test1(){
        System.out.println("Hello!");
    }
    @Test(priority = 2)
    void test2(){
        System.out.println("Bye!");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("BEFORE method");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("AFTER method");
    }
    @BeforeTest
    void beforeTest(){
        System.out.println("BEFORE test");
    }
    @AfterTest
    void afterTest(){
        System.out.println("AFTER test");
    }
}
