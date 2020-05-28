package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import com.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);
    protected  Actions actions = new Actions(Driver.getDriver());

    public AbstractBasePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String tabName) {

        String tabNameXpath = "//span[text()='"+ tabName + "']";
        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement));
        tabElement.click();
        BrowserUtilities.wait(5);

    }
}
