package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateLinkPage extends AbstractBasePage{

    @FindBy(xpath = "//span[text()='Event']")
    private WebElement eventClick;

    @FindBy(xpath = "(//span[@id='bx-b-link-blogPostForm_calendar'])//span")
    private WebElement linkClick;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    private WebElement linkInput;

    @FindBy(className = "adm-btn-save")
    private WebElement saveButton;

    @FindBy(xpath = "(//style[@type='text/css'])[2]//following::body")
    private WebElement linkText;



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
    public void setSaveButton(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public String getCreateLinkText(){

        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath ("//div[@id='bx-html-editor-iframe-cnt-oCalEditorcal_3Jcl']//iframe")));
        return linkText.getText();



      ////a[@data-bx-clean-attribute='title']
    }


}
