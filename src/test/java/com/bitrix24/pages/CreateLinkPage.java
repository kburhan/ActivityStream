package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateLinkPage extends AbstractBasePage{

    @FindBy(xpath = "//span[text()='Event']")
    private WebElement eventClick;

    @FindBy(className = "bxhtmled-top-bar-btn bxhtmled-button-link bxhtmled-top-bar-btn-active")
    private WebElement linkClick;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    private WebElement linkInput;

    @FindBy(className = "adm-btn-save")
    private WebElement saveButton;



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

    public String getCreateLinkText(String link){

        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(link)));
      return  driver.findElement(By.linkText(link)).getText();



      ////a[@data-bx-clean-attribute='title']
    }


}
