package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.utility.Base.*;

public class FramePractice {
    public static void main(String[] args) {
        WebDriver driver = loadDriver("Chrome");
        WebDriverWait wait = getWait(driver);
        Actions action = new Actions(driver);
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));
        action.dragAndDrop(source,destination).build().perform();



    }
}
