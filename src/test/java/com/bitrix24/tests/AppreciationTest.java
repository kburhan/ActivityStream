package com.bitrix24.tests;

import com.bitrix24.pages.AppreciationPage;
import com.bitrix24.pages.LoginPage;
import org.testng.annotations.Test;

public class AppreciationTest extends AbstractTestBase {

    @Test (description = "Verify if user is able to click Appretiation")
    public void verifyIfUserCanClickAppret(){
        test = report.createTest("Verify if user is able to click Appretiation");

        LoginPage loginPage = new LoginPage();
        AppreciationPage appreciationPage= new AppreciationPage();

        loginPage.login("helpdesk41@cybertekschool.com", "UserUser");

        appreciationPage.clickMoreButton();
        appreciationPage.clickAppreciationClick();
        appreciationPage.setUploadFilesClick();











    }

}
