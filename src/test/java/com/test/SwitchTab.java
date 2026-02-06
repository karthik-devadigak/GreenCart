package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

import static com.utility.Base.*;

public class SwitchTab {
    public static void main(String[] args) {
        WebDriver driver = loadDriver("Chrome");
        WebDriverWait wait = getWait(driver);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow=it.next();
        String childWindow=it.next();
        driver.switchTo().window(childWindow);

        String orginalMessage=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='im-para red']")))).getText();
        String mailId=orginalMessage.split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("username")).sendKeys(mailId);

        closeDriver(driver);

    }
}
