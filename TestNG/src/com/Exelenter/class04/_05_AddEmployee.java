package com.Exelenter.class04;

import org.testng.annotations.Test;
import pages.PIMPage;
import utils.BaseClass;
import utils.ConfigsReader;

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
    @Test
    void addEmployee(){
        loginPage.loginToWebsite("username","password");
        PIMPage.
    }
}
