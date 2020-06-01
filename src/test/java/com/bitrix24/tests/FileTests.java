package com.bitrix24.tests;

import com.bitrix24.pages.FilePage;
import com.bitrix24.pages.LoginPage;
import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileTests extends AbstractTestBase{


    @Test
    public void verifyUserUpload(){
        test=report.createTest("Verify User able to upload files");
        LoginPage loginPage = new LoginPage();
        loginPage.login("marketing5@cybertekschool.com","UserUser");
      //  Actions actions = new Actions(Driver.getDriver());

        FilePage filePage = new FilePage();
        filePage.navigateToFile();
        filePage.uploadFilesFromLocal();

    }
}
