package com.bitrix24.tests;

import com.bitrix24.pages.EventTabPage;
import com.bitrix24.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EventTabTests extends AbstractTestBase {


    @Test(dataProvider = "smokeTestData")
    public  void createLinkEventTest(String name, String link){

        test=report.createTest("Create link event");

        LoginPage loginPage= new LoginPage();
        loginPage.login();
        loginPage.navigateTo(name);

        EventTabPage eventTabPage =new EventTabPage();

        eventTabPage.setEventClick();
        eventTabPage.setLinkClick();
        eventTabPage.setLinkInput(link);
        eventTabPage.setSaveButton();

        test.pass("Event's link was created successfully");
        String expected= eventTabPage.getCreateLinkText();

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
