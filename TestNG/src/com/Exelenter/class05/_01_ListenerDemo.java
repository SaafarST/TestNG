package com.Exelenter.class05;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _01_ListenerDemo {
    @Test
    void test1(){
        System.out.println("Test1 Running ...");
    }
    @Test
    void test2(){
        System.out.println("Test2 Running ...");
        //Assert.fail();
    }
}
