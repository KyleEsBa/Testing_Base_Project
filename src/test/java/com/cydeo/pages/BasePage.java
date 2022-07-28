package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Library")
    public WebElement btnLibrary;

    @FindBy(xpath = "//span[.='Books']")
    public WebElement btnBooks;

    @FindBy(xpath = "//span[.='Borrowing Books']")
    public WebElement btnBorrowing;

    @FindBy(id = "user_avatar")
    public WebElement btnUserProfile;
}
