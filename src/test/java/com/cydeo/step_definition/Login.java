package com.cydeo.step_definition;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    BasePage basePage=new BasePage();
    LoginPage loginPage=new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("login.url"));
    }
    @When("user enters a valid {string} username")
    public void user_enters_a_valid_username(String username) {
        loginPage.tbxEmail.sendKeys(username);
    }

    @When("user enters a valid {string} password")
    public void user_enters_a_valid_password(String password) {
        loginPage.tbxPassword.sendKeys(password);
    }
    @When("user click on the Sign In button")
    public void user_click_on_the_sign_in_button() {
        loginPage.btnSignIn.click();
        //Timer applied to wait while the home page is loading
        WebDriverWait waitOfAccess=new WebDriverWait(Driver.getDriver(),3);
        waitOfAccess.until(ExpectedConditions.visibilityOf(basePage.btnLibrary));
    }
    @Then("user should see {string} as title of the page")
    public void user_should_see_as_title_of_the_page(String expectedTitle){
        BrowserUtilities.verifyTitle(Driver.getDriver(),expectedTitle);
    }

    @Given("user is logged as {string}")
    public void user_is_logged_as(String userType) {
        loginPage.login(userType);
    }
}
