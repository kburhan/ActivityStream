package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.pages.MessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Message_Add_Icon_Tests extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    MessagePage messagePage = new MessagePage();


    @Test
    public void verifyAddedContactDisplayed(){
        test = report.createTest("Verify that added contact email is displayed");
        loginPage.login();
        messagePage.clickToMessageTab();
        messagePage.addMention();
        messagePage.clickOnContactsLink();
        messagePage.selectContactEmail();
        messagePage.setSendButton();

        test.pass("Contact was added successfully");

        Assert.assertTrue(messagePage.getAddedContactEmailLink().isDisplayed());
    }
    @Test
    public void verifyEditorToolBarIsDisplayed(){
        test = report.createTest("Verify editor tool bar is displayed");
        loginPage.login();
        messagePage.clickToMessageTab();
        messagePage.clickOnVisualEditor();
        Assert.assertTrue(messagePage.editorTextBarVisible().isDisplayed());
        test.pass("Editor text-bar is displayed");

    }

    @Test
    public void verifyTopicTextBox(){
        test = report.createTest("Verify topic icon text box is displayed");
        loginPage.login();
        messagePage.clickToMessageTab();
        messagePage.clickTopicIcon();
        messagePage.isTopicTextBoxVisible();
        Assert.assertTrue(messagePage.isTopicTextBoxVisible().isDisplayed());
        test.pass("Topic icon text box is displayed");
    }
    @Test
    public void test(){
        loginPage.login();
        messagePage.clickOnWindowsDesktopIcon();

    }

}
