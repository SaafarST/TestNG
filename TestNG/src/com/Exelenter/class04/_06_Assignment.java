package com.Exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _06_Assignment extends BaseClass {
    /*
  Task: HW: Add Employees using Data Provider Annotation
         1.  Open the Chrome browser
         2.  Go to https://exelentersdet.com/
         3.  Login into the application
         4.  Navigate to Add Employee Page
         5.  Add 5 different Employees and create login credentials by providing:
                 - First Name
                 - Last Name
                 - Username
                 - Password
         6.  Verify Employee has been added successfully and take screenshots (you
              must have 5 different screenshots)
         7.  Close the browser
              BONUS: Specify a group name for this test case, and execute from the
              XML file.
 */
    @Test(dataProvider = "addEmployeeTest")
    public void loginTest(String firstName, String lastName, String username, String password) {

        //Login to website:
        loginPage.loginToWebsite("username","password");
        //Navigate to Add Employee Page:
        pimPage.navigateToAddEmployee();
        //Add name and surname:
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.lastName, lastName);
        //click to Create login details
        click(addEmployeePage.checkLogin);
        //Add Username and password, reaffirm password
        sendText(addEmployeePage.userName, username);
        sendText(addEmployeePage.EmployeePassword, password);
        sendText(addEmployeePage.confirmEmployeePassword, password);
        //Click save button
        click(addEmployeePage.saveButton);
        waitForVisibility(dashboardPage.welcome);
        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        wait(10000);
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed.");
    }

    @DataProvider(name = "addEmployeeTest")
    public Object[][] dataProviderMethod() {
        Object[][] data = {
//                {"Jurgen", "Klopp", "Kloppy","JurgenKlopp2021!"},
//                {"Pep", "Guardiola", "Peppy","PepGuardiola2022"},
//                {"Mikel", "Arteta", "Miko","MikelArteta2023"},
//                {"Sir", "Fergie", "Referee","SirFergie2013"},
               {"Bill", "Shankly", "Billo","BillShankly1973!"}

        };
        return data;}

}
