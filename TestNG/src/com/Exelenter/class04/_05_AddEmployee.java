package com.Exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PersonalDetailsPage;
import utils.BaseClass;

public class _05_AddEmployee extends BaseClass {
    /*
  Task: Add Employees using Data Provider Annotation
         1. Open the Chrome browser
         2. Go to https://exelentersdet.com
         3. Login into the application
         4. Navigate to Add Employee Page
         5. Add a new employee by providing
             - First Name
             - Last Name
         6. Click Save Button to save employee
         7. Close the browser
 */
    @Test(dataProvider = "test one")
    void addEmployee(String firstName, String lastName){
        loginPage.loginToWebsite("username","password");
        wait(200);
        pimPage.navigateToAddEmployee();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.lastName, lastName);
        String expectedID = addEmployeePage.employeeId.getAttribute("value");
        click(addEmployeePage.saveButton);

        //Validation
        waitForVisibility(personalDetailsPage.personalDetailsHeader);
        String actualID = personalDetailsPage.employeeID.getAttribute("value");
        Assert.assertEquals(actualID,expectedID,"Employee add does not match.");
    }
    @DataProvider(name = "test one")
    public Object[][]addEmployees(){
        Object[][] employee = {
                {"John", "Doe"},
                {"Jack", "Sparrow"}
        };
        return employee;
    }
}
