package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActivityStreamPage extends AbstractBasePage{

    @FindBy (className = "main-ui-filter-search-filter")
    private WebElement filterAndSearch;


    public void FilterAndSearch(String searchInput){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(filterAndSearch)).sendKeys(searchInput);

    }

    public boolean adminIsDisplayed(){
        BrowserUtilities.waitForPageToLoad(10);
        WebElement adminLocator = driver.findElement(By.cssSelector("[id='bp_1']"));
        return adminLocator.isDisplayed();
    }
}
