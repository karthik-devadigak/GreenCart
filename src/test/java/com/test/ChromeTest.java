package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeTest {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-proxy-server");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://example.com/");
        System.out.println(driver.getPageSource());
        driver.quit();  
    }
}
