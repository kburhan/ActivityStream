package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.pages.MessagePage;
import org.testng.annotations.Test;

public class Message_Add_Icon_Tests extends AbstractTestBase {

    @Test
    public void verifyAddedContactDisplayed(){
        test = report.createTest("Verify that added contact email is displayed");

        LoginPage loginPage = new LoginPage();
        MessagePage messagePage = new MessagePage();
        loginPage.login();
        messagePage.clickToMessageTab();

        messagePage.addMention();
        messagePage.clickOnContactsLink();
        messagePage.selectContactEmail();

    }
}
