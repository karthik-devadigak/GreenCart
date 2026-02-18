package com.test;

import com.utility.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    private static WebDriver driver = Base.loadDriver("Chrome");

    @Test
    public static void checkPagination() throws IOException {

        String item=Base.loadProperties().getProperty("paginationItem");
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.id("productTable")));

        WebElement table=driver.findElement(By.id("productTable"));
        try {
            List<String> price;
            int pageid = 2;

            do {
                List<WebElement> productLists = table.findElements(By.xpath(".//td[2]"));
                price = productLists.stream().filter(s -> s.getText().equalsIgnoreCase(item)).map(s -> getPriceAndSelect(s)).collect(Collectors.toList());
                price.forEach(a -> System.out.println("The price of " + item + " is " + a));
                if (price.size() < 1) {
                    driver.findElement(By.xpath("//ul[@id='pagination']//*[text()='" + pageid + "']")).click();
                    pageid++;

                }
            }
            while (price.size() < 1);
        } finally {
            Base.closeDriver(driver);
        }
    }



    public static String getPriceAndSelect(WebElement e){
        e.findElement(By.xpath("./following-sibling::td/input")).click();
        return e.findElement(By.xpath("./following-sibling::td[1]")).getText();
    }

    }

