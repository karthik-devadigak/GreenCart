package com.test;

import com.utility.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class TableTotal {
    public static void main(String[] args) throws IOException {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter table name");
//        String tableName = scanner.nextLine();
//        System.out.println("Enter coulm name");
//        String columnName = scanner.nextLine();

        String tableName = Base.loadProperties().getProperty("tableName");
        String columnName = Base.loadProperties().getProperty("columnName");
        System.out.println(tableName);
        System.out.println(columnName);
        int i = 0;
        int headCount = 0;
        int sum = 0;

        WebDriver driver = Base.loadDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");


        try {

            WebElement table = driver.findElement(By.xpath("//*[text()=\"" + tableName + "\"]/following-sibling::*"));
            List<WebElement> tableHeaders = table.findElements(By.xpath(".//th"));
            for (i = 0; i < tableHeaders.size(); i++) {
                if (tableHeaders.get(i).getText().equalsIgnoreCase(columnName)) {
                    headCount = i + 1;
                    break;
                }
            }
            if (headCount == 0) {
                throw new RuntimeException("Wrong Column Name");
            }
            List<WebElement> valueList = table.findElements(By.xpath(".//tbody/tr/td[" + headCount + "]"));


            for (WebElement valueCount : valueList) {
                sum = sum + Integer.parseInt(valueCount.getText());
            }
            System.out.println("The total is " + sum);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Base.closeDriver(driver);
        }


    }


}
