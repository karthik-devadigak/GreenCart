package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    public static WebDriver loadDriver(String browser){
        WebDriver driver = null;

        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }
        else
            if (browser.equalsIgnoreCase("Firefox")){
                driver = new FirefoxDriver();
            }
            else
                if (browser.equalsIgnoreCase("Safari")){
                    driver = new SafariDriver();
                } else if (browser.equalsIgnoreCase("Edge")) {
                    driver = new EdgeDriver();

                }
                else {
                    System.out.println("Invalid Borwser");
                }

                return driver;

    }

    public static WebDriverWait getWait(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }

    public static void closeDriver(WebDriver driver){
        driver.close();
        driver.quit();
    }


}
