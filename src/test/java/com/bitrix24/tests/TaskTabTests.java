package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.pages.TaskPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTabTests extends AbstractTestBase {
    /*
    2. As a user, I should be able to assign tasks by clicking on task under Active Stream.
       1. User should be able to click on "High Priority" checkbox to set  the current task to a top priority task.
       2. User should be able to click on Visual Editor and see the editor text-bar displays in top of the message box.
       3. User should be able to click on upload files and pictures from local disks,
          download from external drive, select documents from bitrix24, and create files to upload.
       4. User should be able to create a quote by clicking on the Comma icon.
       5. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.

     */
    @Test(description = "Verify that task is created")
    public void verifyIfHighPriority(){

        LoginPage loginPage = new LoginPage();
        TaskPage taskPage = new TaskPage();
        loginPage.login("hr41@cybertekschool.com", "UserUser");

        test = report.createTest("Task tab is visible!");
        Assert.assertEquals(taskPage.taskTab("Demo Meeting!"),"TASK");
        test.pass("Task tab is visible");


       test = report.createTest("High Priority checkbox is clicked");
       Assert.assertEquals(taskPage.highPriorityLabel(), "High Priority");
       taskPage.highPriorityCheckBox();
       test.pass("High Priority checkbox visible and clickable");







    }
}
