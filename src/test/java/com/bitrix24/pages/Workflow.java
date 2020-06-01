package com.bitrix24.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Workflow extends AbstractBasePage {

    @FindBy(id= "feed-add-post-form-link-text")
    private WebElement dropdownTap;


    @FindBy(className= "menu-popup-item-text")
    private WebElement workflowTap;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-priority-cb']")
    private WebElement highPriorityTab;

}
