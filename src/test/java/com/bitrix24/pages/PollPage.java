package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PollPage extends AbstractBasePage {
    @FindBy (tagName = "Poll")
    private WebElement pollTab;

    @FindBy (id = "POST_TITLE")
    private WebElement topic;

    @FindBy (linkText = "<link href=\"/bitrix/cache/css/s1/bitrix24/kernel_main/kernel_main_v1.css?154877734236509\" type=\"text/css\" rel=\"stylesheet\">")
    private WebElement messageBox;

    @FindBy (id = "question_0")
    private WebElement questionBar;

    @FindBy (id = "answer_0__0_")
    private WebElement answer1bar;

    @FindBy (id = "answer_0__1_")
    private WebElement answer2bar;

    @FindBy (id= "multi_0")
    private WebElement multiChoiceBox;

    @FindBy (id = "blog-submit-button-save")
    private WebElement sendBtn;


    public void clickToPollTab(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(pollTab)).click();
    }
    public void clickToTopic(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(topic)).click();
    }
    public void clickToMessageBox(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(messageBox)).click();
    }
    public void clickToQuestionBox(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(questionBar)).click();
    }
    public void clickToAnswerOne(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(answer1bar)).click();
    }
    public void clickToAnswerTwo(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(answer2bar)).click();
    }
    public void clickToMultipleChoiceBox(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(multiChoiceBox)).click();
    }
    public void clickToSendButton(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(sendBtn)).click();
    }

}
