package com.test;

import com.utility.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CompareSortList {
    private static WebDriver driver = Base.loadDriver("chrome");
    private static WebDriverWait wait = Base.getWait(driver);
    private static final By topDeals = By.xpath("//a[contains(text(),\"Top Deals\")]");
    private static String columnHead = "Veg/fruit name";

    @Test
    public static void compareSorted() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();

        driver.findElement(topDeals).click();

        switchTo();
        int count = getColumnNumber();

        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> actualListLocators = driver.findElements(By.xpath("//tr/td[" + count + "]"));
//        List<String> actualList = new ArrayList<>();
//        for (WebElement actualListValues : actualListLocators) {
//            actualList.add(actualListValues.getText());
//        }

        List<String> actualList = actualListLocators.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = actualList.stream().sorted().collect(Collectors.toList());
//        if (actualList.equals(sortedList)) {
//            System.out.println("Passed");
//        }
        Assert.assertTrue(actualList.equals(sortedList));

        Base.closeDriver(driver);

    }

    public static void switchTo() {
        //        Set<String> handle= driver.getWindowHandles();
//        Iterator<String> it= handle.iterator();
//        String parentTab=it.next();
//        String childTab=it.next();
//        driver.switchTo().window(childTab);

        String parentTab = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentTab)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static int getColumnNumber() {
        List<WebElement> headers = driver.findElements(By.xpath("//th"));
        int c = 0;
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getAttribute("aria-label").contains(columnHead)) {
                c = i + 1;
            }
        }
        return c;
    }
}
