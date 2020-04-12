package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.utilities.BrowserUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends AbstractTestBase {

    @Test
    public void verifyWarningMessage(){
        test=report.createTest("Verify warning message");

        LoginPage loginPage=new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Incorrect login or password");
        //take a screenshot
        BrowserUtilities.getScreenshot("warning_message");

        test.pass("Warning message is displayed");

    }
}
