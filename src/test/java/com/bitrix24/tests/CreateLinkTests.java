package com.bitrix24.tests;

import com.bitrix24.pages.CreateLinkPage;
import com.bitrix24.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLinkTests extends AbstractTestBase {


    @Test(dataProvider = "smokeTestData")
    public  void createLinkEventTest(String name, String link){

        test=report.createTest("Create link event");

        LoginPage loginPage= new LoginPage();
        loginPage.login();
        loginPage.navigateTo(name);

        CreateLinkPage createLinkPage=new CreateLinkPage();

        createLinkPage.setEventClick();
        createLinkPage.setLinkClick();
        createLinkPage.setLinkInput(link);
        createLinkPage.setSaveButton();

        test.pass("Event's link was created successfully");
        String expected=createLinkPage.getCreateLinkText();

        Assert.assertEquals(link,expected);
    }

    @DataProvider
    public Object[][] smokeTestData() {
        return new Object[][]{
                {"Event", "www.google.com"},
                {"Event", "www.amazon.com"},
                {"Event", "www.ebay.com"}
        };
    }
}
