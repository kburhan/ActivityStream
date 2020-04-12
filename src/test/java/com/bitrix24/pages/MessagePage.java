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

    @FindBy (xpath = "(//iframe[@class='bx-editor-iframe'])[1]")
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

    public void clickToMessageTab(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(messageTab)).click();

    }

    public boolean clickOnImageAndSelectIcon(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(imageIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDoc)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();
        BrowserUtilities.wait(3);
        //when you click on logo the DOM changes and you have to find elements again.. stale elemen..how to resolve? find element again
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("popup-window-button popup-window-button-accept"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDocumentButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
        BrowserUtilities.wait(5);

        WebElement image = driver.findElement(By.id("disk-attach-image-193"));

        return image.isDisplayed();

    }


    public void enterMessageInFrame (String description) {
        //wait until frame is available and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(messageFrame));
        //send keys ??
        driver.switchTo().defaultContent();//exit from the frame
    }
}
