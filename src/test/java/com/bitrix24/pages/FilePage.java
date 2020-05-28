package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import com.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

//US  -> As a user, I should be able to send files by selecting File subheading from ""More"" tab under Activity Stream.
//AC ->  1. User should be able to click on upload files icon to upload files and pictures from local disks,
// download from external drive,

public class FilePage extends AbstractBasePage{


    @FindBy (id ="feed-add-post-form-link-text" )
    protected WebElement moreClick ;

    @FindBy(css = ".menu-popup-items > *:first-child" )
    protected  WebElement fileClick ;

    @FindBy(name = "[name=\"bxu_files[]\"]")
    //              (//span[@class="wd-fa-add-file-light"])[1]
    //               (//div[@class="diskuf-uploader"])[1]
    protected  WebElement uploadFiles ;

    @FindBy(id = "blog-submit-button-save")
    protected  WebElement sendButton ;

    @FindBy (xpath = "[id=\"disk-attach-image-357\"]")
    protected  WebElement image ;

    @FindBy (xpath = "(//span[@class=\"wd-fa-add-file-editor-link\"])[1]")
    protected  WebElement office365 ;

    @FindBy (xpath = "(//span[text()='Select document from Bitrix24'])[1]")
    protected  WebElement availableLibraries ;

    @FindBy (xpath = "title=\"Name: Array Methods\"")
    protected  WebElement titleFromBitrix24 ;


    public void navigateToFile(){
        wait.until(ExpectedConditions.elementToBeClickable(moreClick)).click();
        BrowserUtilities.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(fileClick)).click();
        BrowserUtilities.wait(5);
    }

    public void uploadFilesFromLocal (){
        String path = System.getProperty("user.dir")+"WebOrdersAutomation2020.iml";
        BrowserUtilities.waitForPageToLoad(15);
        BrowserUtilities.wait(5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name=\"bxu_files[]"))).sendKeys(path);
        BrowserUtilities.wait(5);
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
        BrowserUtilities.wait(5);
    }

    public void dowloadFromDriver() {
        wait.until(ExpectedConditions.elementToBeClickable(office365)).sendKeys();
    }

    public void setAvailableLibraries(){
        wait.until(ExpectedConditions.visibilityOf(availableLibraries)).click();
        wait.until(ExpectedConditions.visibilityOf(titleFromBitrix24)).click();
    }

}
