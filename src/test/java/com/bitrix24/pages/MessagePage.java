package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessagePage extends AbstractBasePage {

    @FindBy (id = "feed-add-post-form-tab-message")
    private WebElement messageTab;

    @FindBy (xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement messageFrame;

    @FindBy(xpath = "//body[@contenteditable='true']")
    private WebElement messageBodyTextArea;

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

    @FindBy(linkText = "helpdesk31@cybertekschool.com")
    private WebElement addedContactEmailLink;

    @FindBy(xpath = "//body[@contenteditable='true']")
    private WebElement messageBodyTextArea;

    @FindBy(xpath = "//*[@id='lhe_button_editor_blogPostForm']")
    //@FindBy(css = "#lhe_button_editor_blogPostForm")
    private WebElement visualEditorButton;

    @FindBy(xpath = "(//div[@class='bxhtmled-toolbar'])[1]")
    private WebElement editorTextBar;

    @FindBy(xpath = "//span[@title='Topic']")
    private WebElement topicIcon;

    @FindBy(id = "blog-title" )
    private  WebElement messageTopicTextBox;


    @FindBy(xpath = "//*[text()='Windows']")
    private WebElement windowsLink;

    public void clickOnWindowsDesktopIcon(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(windowsLink));
        BrowserUtilities.scrollTo(windowsLink);
        windowsLink.click();
    }

    public void clickTopicIcon(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(topicIcon)).click();
    }
    public WebElement isTopicTextBoxVisible(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(messageTopicTextBox));
        return messageTopicTextBox;
    }


    public void clickOnVisualEditor(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(visualEditorButton)).click();

    }
    public WebElement editorTextBarVisible(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(editorTextBar));
        WebElement editorTextBar = driver.findElement(By.xpath("(//div[@class='bxhtmled-toolbar'])[1]"));
        return  editorTextBar;
    }

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

    public WebElement getAddedContactEmailLink(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(addedContactEmailLink));
        WebElement addedContactEmail = driver.findElement(By.linkText("helpdesk31@cybertekschool.com"));

        return addedContactEmail;
      
    @FindBy (xpath = "//span[@title='Quote text']")
    private WebElement quoteIcon;

    @FindBy (tagName = "blockquote")
    private WebElement quoteInputArea;


    public void clickOnQuoteIcon(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(quoteIcon)).click();

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
        WebElement image = driver.findElement(By.cssSelector("[id^='disk-attach-image']"));
        return image.isDisplayed();
    }

    public String checkIfQuoteIsMatching(){
        BrowserUtilities.waitForPageToLoad(10);
        WebElement quote = driver.findElement(By.xpath("//table[@class='blogquote']/tbody/tr/td"));
        return quote.getText();
    }

    public void enterQuote (String quote){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(messageFrame));
        wait.until(ExpectedConditions.visibilityOf(quoteInputArea)).sendKeys(quote);
        driver.switchTo().defaultContent();//exit from the frame

    }

    public void enterMessageInFrame (String description) {
        //wait until frame is available and switch to it
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(messageFrame));
        wait.until(ExpectedConditions.elementToBeClickable(messageBodyTextArea)).sendKeys(description);
        driver.switchTo().defaultContent();//exit from the frame
    }
}
