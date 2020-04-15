package com.bitrix24.tests;

import com.bitrix24.pages.CreateLinkPage;
import com.bitrix24.pages.LoginPage;
import com.bitrix24.utilities.BrowserUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLinkTests extends AbstractTestBase {


    @Test
    public void verifyQuote(){
        test=report.createTest("Create quote");

        LoginPage loginPage=new LoginPage();
        loginPage.login();
        loginPage.navigateTo("Event");

        CreateLinkPage createLinkPage=new CreateLinkPage();
        createLinkPage.clickCommaIcon();
        createLinkPage.clickSendBtn();
        Assert.assertTrue(createLinkPage.getQuoteVerification().isDisplayed());
        test.pass("Quote is created successfully");

    }

    @Test
    public void verifyVisualEditor(){
        test=report.createTest("Visual editor");

        LoginPage loginPage=new LoginPage();
        loginPage.login();
        loginPage.navigateTo("Event");

        CreateLinkPage createLinkPage=new CreateLinkPage();
        createLinkPage.clickVisualEditor();
        Assert.assertTrue(createLinkPage.getVisualEditorToolBar().isDisplayed());
        test.pass("Visual editor toolbox is displayed successfully");

    }


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




    @Test
    public void verifyUploadFiles(){

        test=report.createTest("Upload file");

        LoginPage loginPage=new LoginPage();
        loginPage.login();
        loginPage.navigateTo("Event");

        CreateLinkPage createLinkPage=new CreateLinkPage();
        createLinkPage.clickUploadFilesBtn();

        createLinkPage.getUploadFilesAndImages().sendKeys("/Users/mervefaki/Desktop/download.jpeg");
        BrowserUtilities.wait(2);
        createLinkPage.getSelectDocFromBitrix24().click();
        createLinkPage.clickCancel();
        BrowserUtilities.wait(2);

    }
}
