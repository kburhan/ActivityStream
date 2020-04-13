package com.bitrix24.pages;

import com.bitrix24.tests.AbstractTestBase;
import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessagePage extends AbstractBasePage {

    @FindBy (id = "feed-add-post-form-tab-message")
    private WebElement messageTab;

    @FindBy (xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement messageFrame;

    @FindBy (id = "bx-b-uploadfile-blogPostForm")
    private WebElement imageIcon;

    @FindBy (xpath = "(//*[contains(text(),'Select document from Bitrix24')])[1]")
    private WebElement selectDoc;

    @FindBy (xpath = "//a[text()='Logo.gif']")
    private WebElement logo;

    //@FindBy ( className = "popup-window-button popup-window-button-accept")
    @FindBy (xpath = "//div[@class='popup-window-buttons']//span[1]")
    private WebElement selectDocumentButton ;

    @FindBy (id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy (id = "disk-attach-image-193")
    private WebElement imageOfLogo;

    @FindBy(id = "bx-b-mention-blogPostForm")
    private WebElement addMentionIcon;

    @FindBy(css = "[id^='destDepartmentTab_mention']")
    private WebElement contactsLink;

    @FindBy(xpath = "//div[text()='helpdesk31@cybertekschool.com']")
    private WebElement contactEmail;

    @FindBy(xpath = "//body[@contenteditable='true']")
    private WebElement messageBodyTextArea;

    public void addMention(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(addMentionIcon)).click();
    }

    public void clickOnContactsLink(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(contactsLink)).click();
    }
    public void selectContactEmail(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(contactEmail)).click();
    }
    public String getMessageBodyText(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(messageBodyTextArea));
        return messageBodyTextArea.getText();
    }




    public void clickToMessageTab(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(messageTab)).click();

    }

    public void clickOnImageIcon(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(imageIcon)).click();
    }

    public void setSelectDocAndSelectImage(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(selectDoc)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();
        BrowserUtilities.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(selectDocumentButton)).click();
    }

    public void setSendButton(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    //you can add parameter maybe for code below :
    public boolean checkIfPictureIsDisplayed(){

        BrowserUtilities.waitForPageToLoad(10);
        WebElement image = driver.findElement(By.id("disk-attach-image-193"));
        return image.isDisplayed();
    }


    public void enterMessageInFrame (String description) {
        //wait until frame is available and switch to it
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(messageFrame));
        WebElement message = messageFrame;
        //message.sendKeys(description); does not work just yet

        driver.switchTo().defaultContent();//exit from the frame
    }
}
