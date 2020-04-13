package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class TaskPage extends AbstractBasePage {

    @FindBy(id = "feed-add-post-form-tab-tasks")
    private WebElement taskTab;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    private WebElement taskBox;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-priority-cb']")
    private WebElement highPriorityTab;

    @FindBy(xpath = "//label[.='High Priority']")
    private WebElement highPriorityLabel;

    @FindBy(xpath = "//span[@id='lhe_button_editor_task-form-lifefeed_task_form']")
    private WebElement visualEditor;

    @FindBy(xpath = "//*[@id='bx-html-editor-tlbr-bitrix_tasks_task_1']/span[2]")
    private WebElement visualEditorBar;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-task-form-lifefeed_task_form']")
    private WebElement uploadFiles;

    @FindBy(css = "span#bx-b-quote-task-form-lifefeed_task_form i")
    private WebElement commaIcon;


    public String taskTab(String text){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(taskTab)).click();
        BrowserUtilities.wait(2);
        taskBox.sendKeys(text);
//        highPriorityTab.click();
        return taskTab.getText();
    }

    public String highPriorityCheckBox(){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(taskBox));
        BrowserUtilities.wait(2);
        highPriorityTab.click();

        return  highPriorityTab.getText();
    }


    public String highPriorityLabel(){
        BrowserUtilities.wait(2);
        return highPriorityLabel.getText();
    }



}
