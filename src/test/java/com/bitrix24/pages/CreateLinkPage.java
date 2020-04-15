package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateLinkPage extends AbstractBasePage {

    @FindBy(xpath = "//span[text()='Event']")
    private WebElement eventClick;

    @FindBy(xpath = "(//span[@id='bx-b-link-blogPostForm_calendar'])//span")
    private WebElement linkClick;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    private WebElement linkInput;

    @FindBy(className = "adm-btn-save")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='bx-html-editor-iframe-cnt-oCalEditorcal_3Jcl']//iframe")
    private WebElement linkText;

    @FindBy(id = "bx-b-uploadfile-blogPostForm_calendar")
    private WebElement uploadFilesBtn;

    @FindBy(css = "[name='bxu_files[]']")
    private WebElement uploadFilesAndImages;

    @FindBy(xpath = "(//span[@class='wd-fa-add-file-light-title-text diskuf-selector-link'])[3]")
    private WebElement selectDocFromBitrix24;

    @FindBy(xpath = "//div[@class='feed-event']//span[@class='wd-fa-add-file-light-title diskuf-selector-link-cloud']")
    private WebElement downloadFromExternalDrive;

    @FindBy(xpath = "//div[@id='diskuf-selectdialog-BiTYTVe']//span[@class='wd-fa-add-file-editor-text']")
    private WebElement createUsingDesktopApp;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-link popup-window-button-link-cancel']")
    private WebElement cancel;

    @FindBy(xpath = "//span[@id='bx-b-quote-blogPostForm_calendar']//span")
    private WebElement commaIcon;

    @FindBy(css = "[id='lhe_button_editor_blogPostForm_calendar']")
    private  WebElement visualEditor;

    @FindBy(css = "[id^='bx-html-editor-tlbr-oCalEditorcal']")
    private WebElement visualEditorToolBar;

    @FindBy(xpath = "(//table[@class=\"quote\"])[1]")
    private WebElement quoteVerification;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendBtn;

    @FindBy(xpath = "(//a[@class='bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file'])[2]")
    private WebElement logoGif;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-disabled']")
    private WebElement selectDocBtn;





    public void setEventClick() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(eventClick)).click();
    }

    public void setLinkClick() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(linkClick)).click();
    }

    public void setLinkInput(String link) {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(linkInput));
        linkInput.sendKeys(link);
    }

    public void setSaveButton() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public String getCreateLinkText() {

        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='bx-html-editor-iframe-cnt-oCalEditorcal_3Jcl']//iframe")));

        BrowserUtilities.wait(2);

        WebElement  frame =driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));
        WebElement body=driver.switchTo().frame(frame).findElement(By.xpath("//body[@contenteditable='true']"));
        System.out.println(body.getText());

        return body.getText();

    }

    public void clickUploadFilesBtn(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(uploadFilesBtn)).click();
        BrowserUtilities.wait(3);
    }

    public void clickCommaIcon() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(commaIcon)).click();
        BrowserUtilities.wait(3);
    }

    public void clickVisualEditor() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(visualEditor)).click();
    }


    public void clickSendBtn(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(sendBtn)).click();
        BrowserUtilities.wait(3);
    }

    public WebElement getQuoteVerification(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(quoteVerification));
        return quoteVerification;
    }

    public WebElement getVisualEditorToolBar(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(visualEditorToolBar));
        return visualEditorToolBar;
    }

    public void clickCancel() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
    }


    public WebElement getUploadFilesAndImages(){
        BrowserUtilities.waitForPageToLoad(20);
        //wait.until(ExpectedConditions.visibilityOf(uploadFilesAndImages));
        return uploadFilesAndImages;
    }

    public WebElement getSelectDocFromBitrix24(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(selectDocFromBitrix24));
        return selectDocFromBitrix24;
    }

    public WebElement getDownloadFromExternalDrive(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(downloadFromExternalDrive));
        return downloadFromExternalDrive;
    }

    public WebElement getCreateUsingDesktopApp(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(createUsingDesktopApp));
        return createUsingDesktopApp;
    }

    public void clickSelectDocBtn(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(selectDocBtn)).click();
        BrowserUtilities.wait(3);
    }

}