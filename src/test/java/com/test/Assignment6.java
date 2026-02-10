package com.test;

import com.utility.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
    public static void main(String[] args) {
        WebDriver driver = Base.loadDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        final WebElement checkBoxId = driver.findElement(By.id("checkBoxOption2"));
        final WebElement selectElement = driver.findElement((By.id("dropdown-class-example")));
        final WebElement alertText = driver.findElement(By.id("name"));
        final WebElement alertButton = driver.findElement(By.id("alertbtn"));
//        final By checkBoxId= By.id("checkBoxOption2");


        checkBoxId.click();
        String optionValue = checkBoxId.findElement(By.xpath("./..")).getText().trim();
        System.out.println(optionValue);
        Select select = new Select(selectElement);
        select.selectByVisibleText(optionValue);

        alertText.sendKeys(optionValue);
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().contains(optionValue)) {
            System.out.println("test passed");
        } else {
            System.out.println("Test Failed");
        }
        alert.accept();
        Base.closeDriver(driver);


    }


}
