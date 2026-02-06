package com.test;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreenCart {
    public static void main(String[] args) {
        String[] requiredItems = {"Brocolli", "Carrot", "Cucumber"};
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        By itemNameLocator= By.xpath("//h4[@class='product-name']");
        List<WebElement> itemNames=  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemNameLocator));
        List<String> requiredItemList = new ArrayList<>(Arrays.asList(requiredItems));
        int j=0;
        for(WebElement itemNamesRaw : itemNames){
            String itemName = itemNamesRaw.getText().split("-")[0].trim();

            if(requiredItemList.contains(itemName)) {
                itemNamesRaw.findElement(By.xpath("./../div[@class=\"product-action\"]/button")).click();
                j++;
            }
            if(j>= requiredItems.length){
                break;
            }
        }

        driver.quit();


    }
}
