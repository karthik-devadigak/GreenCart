package com.test;

import com.utility.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class GetPrice {
//    public static void main(String[] args) {
        private static WebDriver driver = Base.loadDriver("firefox");
        private static  String vegetable = "Rice";
        private static final By topDeals = By.xpath("//a[contains(text(),\"Top Deals\")]");


//    }
    public static void getPrice(){
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();

        driver.findElement(topDeals).click();

        switchTo(driver);

//    get the rowId of veg
        int count = 0;
        List<WebElement> vegList = driver.findElements(By.xpath("//tr/td[1]"));
        for (int i = 0; i < vegList.size(); i++) {
            if (vegList.get(i).getText().equalsIgnoreCase(vegetable)) {
                count = i + 1;
                break;
            }
        }

        int price = Integer.parseInt(driver.findElement(By.xpath("//tr[" + count + "]//td[2]")).getText());
        int discountedPrice = Integer.parseInt(driver.findElement(By.xpath("//tr[" + count + "]//td[3]")).getText());
        System.out.println("The price of " + vegetable + " is " + price + " and discounted price is " + discountedPrice);

    }

    public static void switchTo(WebDriver driver) {
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

}
