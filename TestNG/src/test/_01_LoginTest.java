package test;


import pages._02_LoginPage;
import utils.ConfigsReader;

import static utils.BaseClass.*;
public class _01_LoginTest {
    public static void main(String[] args) {
        setUp();
//
//        var loginPage = new _01_LoginPageWithoutPageFactory();
//        sendText(loginPage.username, ConfigsReader.getProperties("username"));
//        sendText(loginPage.password,ConfigsReader.getProperties("password"));
//        click(loginPage.loginBtn);

        var login = new _02_LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password,ConfigsReader.getProperties("password"));
        click(login.loginBtn);

        tearDown();
    }
}
