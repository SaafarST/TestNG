package com.Exelenter.class05;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ExcelUtility;

import static org.testng.Assert.assertEquals;

public class _03_HW_ReadingFromExcel extends BaseClass {
    /*
      HW: using TestNG DataProvider, write negative test cases for all the following scenarios:

User Story: As an Invalid User, I should not be able to login using invalid login credentials, and if I try, I should see an error message.

Acceptance Criteria:
 1. When a User enters a valid username and an invalid password
    An 'Invalid credentials' error message is presented.
 2. When a User enters an invalid username and a valid password
    An 'Invalid credentials' error message is presented.
 3. When a User enters an invalid username and invalid password
    An 'Invalid credentials' error message is presented.
 4. When a User enters a valid username and an empty password
    A 'Password cannot be empty' error message is displayed.
 5. When a User enters an invalid username and an empty password
    A 'Password cannot be empty' error message is displayed.
 6. When a User enters an empty username and a valid password
    A 'Username cannot be empty' error message is presented.
 7. When a User enters an empty username and an invalid password
    A 'Username cannot be empty' error message is presented.
 8. When a User enters an empty username and an empty password
    A 'Username cannot be empty' error message is presented.

     */
    @Test(dataProvider = "readFromExcel")
    public void loginTest(String username, String password, String expectedErrorMessage) {

        //Login to website:
        loginPage.loginToWebsite1(username,password);
        String actualErrorMessage = loginPage.loginErrorMessage.getText();
        System.out.println(actualErrorMessage);
        boolean contains = actualErrorMessage.equals(expectedErrorMessage);
        Assert.assertTrue(contains,"Error message does not match.");
    }

    @DataProvider(name = "readFromExcel")
    public Object[][] getDataFromExcel(){
        String absolutePath = ExcelUtility.projectPath + "/testData/LoginHWWithExcel1.xlsx";  //Don't forget slash in front of testData
        return ExcelUtility.readFromExcel(absolutePath, "login&passwords");
    }

}

