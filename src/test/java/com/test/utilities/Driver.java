package com.test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //private constructor, we are closing access to the object
    //of this clas from outside the class
    private Driver(){

    }

    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver>driverPool=new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
        if(driverPool.get()==null){
            String browserType=ConfigurationReader.getProperty("browser");
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
            }
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

/*
//***************      SIMPLE DRIVER         *******************
package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

   private static WebDriver driver;

     public static WebDriver getDriver() {
         //  public static WebDriver getDriver(String browserType) {

         String browserType = ConfigurationReader.getProperties("browser");

        if (driver == null) {

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "FireFox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){

        if (driver!=null){
            driver.quit();

            driver=null;
        }

    }

}*/
