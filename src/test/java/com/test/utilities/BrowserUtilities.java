package com.test.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserUtilities {
    public static void clickRadioButton(List<WebElement>listRadioButtons, String searchedValue){
        for (WebElement each :
                listRadioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(searchedValue))
                each.click();
        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){
        for (String each :
                Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl))
                break;
        }
        Assert.assertTrue("Failed, title verification", Driver.getDriver().getTitle().contains(expectedTitle));
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals("Failed, title is not the same", expectedTitle, driver.getTitle());
    }

    public static void waitForVisibilityOf(WebElement element){
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
