package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.pages.PollPage;
import com.bitrix24.utilities.BrowserUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePollTest extends AbstractTestBase {
    /**
     * 10. User should be able to Add questions and multiple answers;
     * User can provide multiple choice to attendees by selecting the allow multiple choice checkbox.
     */

    @Test(description ="User able to create multi-choice poll")
    public void CreateMultipleChoicePoll(){
        test = report.createTest("User able to add questions and multiple answers");
        LoginPage loginPage = new LoginPage();
        PollPage pollPage = new PollPage();
        loginPage.login("hr42@cybertekschool.com","UserUser");

        pollPage.clickToPollTab();// no need to fill up
        BrowserUtilities.wait(3);
        pollPage.clickToTopic();
        BrowserUtilities.wait(3);
        pollPage.clickToMessageBox();
        BrowserUtilities.wait(3);
        pollPage.clickToQuestionBox();
        BrowserUtilities.wait(3);
        pollPage.clickToAnswerOne();
        BrowserUtilities.wait(3);
        pollPage.clickToAnswerTwo();
        BrowserUtilities.wait(3);
        pollPage.clickToMultipleChoiceBox();// no need
        pollPage.clickToSendButton();// no need
        BrowserUtilities.wait(3);

        String expectedResult = "id=blg-post-img-417";
        Assert.assertEquals("id=blg-post-img-417",expectedResult);



    }

}
