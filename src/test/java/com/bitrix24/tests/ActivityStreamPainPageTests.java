package com.bitrix24.tests;

import com.bitrix24.pages.ActivityStream_MainPage;
import com.bitrix24.pages.LoginPage;
import org.testng.annotations.Test;


public class ActivityStreamPainPageTests extends AbstractTestBase{

    LoginPage loginPage = new LoginPage();
    ActivityStream_MainPage activityStream_mainPage = new ActivityStream_MainPage();

     @Test
    public void clickOnAddToFavorites(){
        loginPage.login();
        activityStream_mainPage.clickOnAddToFavoritesStarIcon();
    }
    @Test
    public void clickOnComment(){
         loginPage.login();
         activityStream_mainPage.clickOnComment();
    }
}
