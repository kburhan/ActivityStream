package com.bitrix24.tests;

import com.bitrix24.pages.CreateLinkPage;
import com.bitrix24.pages.LoginPage;

public class CreateLinkTests extends AbstractTestBase {

    LoginPage loginPage= new LoginPage();
    CreateLinkPage createLinkPage=new CreateLinkPage();


    public  void createLinkEventTest(String name, String link){

        LoginPage loginPage= new LoginPage();
        CreateLinkTests createLinkTests=new CreateLinkTests();
        loginPage.login();
        test=report.createTest("Create link event");

        createLinkPage.navigateTo("Event");
        createLinkPage.setEventClick();
        createLinkPage.setLinkClick();
        createLinkPage.setLinkInput(link);
        createLinkPage.setSaveButton();


        test.pass("Event's link was created succesfully");

    }
}
