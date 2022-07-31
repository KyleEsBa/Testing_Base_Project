package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class LoginPage{
    BasePage basePage=new BasePage();
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement tbxEmail;

    @FindBy(id = "inputPassword")
    public WebElement tbxPassword;

    @FindBy(tagName = "button")
    public WebElement btnSignIn;

    /*The 'login' method will be called to stay into the application, after this you can execute your step scenarios.
     * IMPORTANT: The method parameter is a String with value of 'student' or 'librarian'
     * e.g.  LoginPage loginPage=new LoginPage();
     *       loginPage.login("student");
     * */
    public void login(String userType) {
        switch (userType.toLowerCase(Locale.ROOT)) {
            case "student":
                tbxEmail.sendKeys(ConfigurationReader.getProperty("student.email"));
                tbxPassword.sendKeys(ConfigurationReader.getProperty("student.password"));
                break;
            case "librarian":
                tbxEmail.sendKeys(ConfigurationReader.getProperty("librarian.email"));
                tbxPassword.sendKeys(ConfigurationReader.getProperty("librarian.password"));
                break;
        }
        btnSignIn.click();
        WebDriverWait waitOfAccess=new WebDriverWait(Driver.getDriver(),3);
        waitOfAccess.until(ExpectedConditions.visibilityOf(basePage.btnLibrary));
    }
}
