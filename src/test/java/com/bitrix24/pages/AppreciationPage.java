package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import com.bitrix24.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppreciationPage extends AbstractBasePage {

    @FindBy(xpath = "//span[@class='feed-add-post-more-icon']")
    private WebElement moreButton;

    @FindBy(xpath = "(//span[@class='menu-popup-item-text'])[2]")
    private WebElement appreciationClick;

    @FindBy(xpath ="//span[@id='bx-b-uploadfile-blogPostForm']" )
    private  WebElement uploadFilesClick;

    @FindBy(xpath = "(//span[@class='wd-fa-add-file-light-text'])[1]")
    private WebElement filesImagesClick;


    @FindBy(xpath = "//span[@class='insert-btn-text']")
    private WebElement insertImage;


    @FindBy(xpath ="(//span[@class='wd-fa-add-file-light-title-text'])[2]" )
    private WebElement downloadclick;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-disabled']")
    private WebElement selectDocClick;

    @FindBy(xpath = "//body[@contenteditable='true']")
    private WebElement textBody;

    public void clickMoreButton() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(moreButton)).click();
    }

    public void clickAppreciationClick() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(appreciationClick)).click();
    }

    public void setUploadFilesClick() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(uploadFilesClick)).click();
    }

    public void putText() {
        BrowserUtilities.wait(5);
        wait.until(ExpectedConditions.elementToBeClickable(textBody)).click();

    }










}
