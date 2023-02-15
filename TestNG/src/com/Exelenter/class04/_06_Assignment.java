package com.Exelenter.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.io.File;
import java.io.IOException;
import java.sql.Time;

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
        waitForVisibility(personalDetailsPage.personalDetailsHeader);

        //takeScreenshot1 Method modified to for this assignment
        takeScreenshot1(firstName,lastName);

        //Get header of the personalDetailsPage:
        boolean personalDetailsHeader = personalDetailsPage.personalDetailsHeader.isDisplayed();
        //Assert it is
        Assert.assertTrue(personalDetailsHeader, "Personal Details Header is not displayed.");

    }

    @DataProvider(name = "addEmployeeTest")
    public Object[][] dataProviderMethod() {
        Object[][] data = {
                {"Jurgen", "Klopp", "Kloppy6","JurgenKlopp2021!"},
                {"Pep", "Guardiola", "Peppy6","PepGuardiola2022!"},
                {"Mikel", "Arteta", "Miko6","MikelArteta2023!"},
                {"Sir", "Fergie", "Referee6","SirFergie2013!"},
               {"Bill", "Shankly", "Billosh6","BillShankly1973!"}

        };
        return data;}

}
