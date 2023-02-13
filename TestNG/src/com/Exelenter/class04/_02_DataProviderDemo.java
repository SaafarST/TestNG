package com.Exelenter.class04;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _02_DataProviderDemo {
    @Test
    void printData(){
        userList();
        data();
    }
    public void userList(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Sam");
        stringList.add("John");
        //stringList.add(25);
        List<Object> objectslist = new ArrayList<>();
        objectslist.add(2);
        objectslist.add("List");
        objectslist.add(3435L);
        System.out.println(stringList);
        System.out.println(objectslist);
    }

    public void data(){
        //Single user
        Object user = "John Mich";
        //1D Array of users
        Object[] users = {"John Mich","Sam Lee",'c',34,432.4};
        //2D Array of users
        Object[][] users2D = {{"John Mich","Sam Lee",'c',34,432.4},
                              {"John Mich","Sam Lee",'c',34,432.4},
                              {"John Mich","Sam Lee",'c',34,432.4}

        };
        System.out.println(user);
        for (Object o : users) {
            System.out.println(o);
        }
        for (Object[] objects : users2D) {
            for (Object object : objects) {
                System.out.print(object);
            }
            System.out.println("\n======");
        }

    }

}
