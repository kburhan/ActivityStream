package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.pages.MessagePage;
import com.bitrix24.utilities.BrowserUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendingMessagesTests extends AbstractTestBase {

    /**
     * 1. As a user, I should be able to send messages by clicking on Message tab under Active Stream.
     * AC:
     * 1. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.
     * 2. User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
     * 3. User should be able to attach link by clicking on the link icon.
     * 4. User should be able to insert videos by clicking on the video icon and entering the video URL.
     * 5. User should be able to create a quote by clicking on the Comma icon.
     * 6. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
     * 7. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
     * 8. User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.
     * 9. User should be able to click on "Record Video" tab to record a video and attach it with the message.
     */
    @Test (description = "Verify that user is able to Select document from Bitrix24")
    public void verifyUserIsAbleToSelectImage() {
        test = report.createTest("Verify that user is able to select logo from Bitrix24 library");

        LoginPage loginPage = new LoginPage();
        MessagePage messagePage = new MessagePage();

        loginPage.login("marketing41@cybertekschool.com", "UserUser");
        messagePage.clickToMessageTab();
        messagePage.clickOnImageIcon();
        messagePage.setSelectDocAndSelectImage();
        messagePage.setSendButton();

        Assert.assertTrue(messagePage.checkIfPictureIsDisplayed());

        test.pass("Logo uploaded successfully");


    }

    @Test (description = "Verify that user is able to create a quote by clicking on the Comma icon")
    public void verifyThatQuoteIsCreated(){
        test = report.createTest("Verify that user is able to create a quote (Hello, World) by clicking on the Comma icon");

        LoginPage loginPage = new LoginPage();
        MessagePage messagePage = new MessagePage();
        loginPage.login();
        messagePage.clickToMessageTab();
        messagePage.clickOnQuoteIcon();

        messagePage.enterQuote("Hello, World");
        messagePage.setSendButton();

        String actual = messagePage.checkIfQuoteIsMatching();
        String expected = "Hello, World";

        Assert.assertEquals(actual,expected);
        test.pass("Quote is created successfully");

    }

}
