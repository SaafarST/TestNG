package com.Exelenter.class01;

import org.testng.annotations.*;

public class _04_TestNGDemo4 {

    /**
     *  TestNG Methods run by ascending order (alphabetically, alphanumeric).
     *  sayH  <=== this runs second
     *  sayB  <=== this runs first
     */
    @Test(enabled = false)
    public void test1(){
        System.out.println("one");
    }
    @Test(priority = 2)
    void test2(){
        System.out.println("two");
    }
    @Test(priority = 3)
    void test3(){
        System.out.println("three");
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
        System.out.println("====>BEFORE test");
    }
    @AfterTest
    void afterTest(){
        System.out.println("AFTER test<====");
    }
    @BeforeClass
    void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    void afterClass(){
        System.out.println("After Class");
    }
    @BeforeSuite
    void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    void afterSuite(){
        System.out.println("After Suite");
    }
}
