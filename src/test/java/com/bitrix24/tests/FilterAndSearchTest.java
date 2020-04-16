package com.bitrix24.tests;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.pages.LoginPage;
import com.bitrix24.pages.MessagePage;
import com.bitrix24.utilities.BrowserUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterAndSearchTest extends AbstractTestBase{
/**
 * 9. As a user, I should be able to use "Filter
 * and search" functionality on Active Stream.
 *
 1. User should be able to search by clicking on default filters. (work, favorate, my activity, annoucements, and workflows)
 2. User should be able to search by selecting Date, Type, Author, To and more default dropdowns.
 3. User should be able to type-in keyword to search previous posts.
 4. User should be able to use Save Filter functionality on search bar.
 */
    @Test (description = "Verify that user is able to search by typing-in keyword to search previous posts")
    public void verifyThatFilterAndSearchIsOperational(){
        test = report.createTest("Verify that user is able to search for -admin- using Filter and Search");

        LoginPage loginPage = new LoginPage();
        ActivityStreamPage activityStreamPage = new ActivityStreamPage();

        loginPage.login();
        activityStreamPage.FilterAndSearch("admin");
        BrowserUtilities.wait(3);
        Assert.assertTrue(activityStreamPage.adminIsDisplayed());
    }
}
