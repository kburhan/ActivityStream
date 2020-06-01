package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActivityStream_MainPage extends AbstractBasePage {

    @FindBy(xpath = "(//*[@title='Add to favorites']) [1]")
    private WebElement addToFavoritesButton;

    @FindBy(xpath = "(//a[text()='Comment'])[1]")
    //@FindBy(xpath = "(//span[@class='feed-inform-comments']//a[text()='Comment'])[1]")
    private WebElement comment;


      public void clickOnAddToFavoritesStarIcon(){
        BrowserUtilities.wait(10);
        wait.until(ExpectedConditions.elementToBeClickable(addToFavoritesButton)).click();
        BrowserUtilities.wait(10);
    }

    public void clickOnComment(){
          BrowserUtilities.wait(10);
          wait.until(ExpectedConditions.elementToBeClickable(comment)).click();
    }

   }

