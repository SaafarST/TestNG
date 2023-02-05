package com.Exelenter.class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_TestNGDemo {

    /**
     *  TestNG Methods run by ascending order (alphabetically, alphanumeric).
     *  sayH  <=== this runs second
     *  sayB  <=== this runs first
     */
    @Test(priority = 1)
    public void sayHello(){
        System.out.println("Hello!");
    }
    @Test(priority = 2)
    void sayBye(){
        System.out.println("Bye!");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("This will run BEFORE method which has @Test annotation.");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("This will run AFTER method which has @Test annotation.");
    }
}
