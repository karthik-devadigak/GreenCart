package com.test;

import com.utility.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Base.loadDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,300)");

    }
}
