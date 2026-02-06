package com.test;

import com.utility.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OpenTabs {
    public static void main(String[] args) {
        WebDriver driver = Base.loadDriver("Chrome");
        WebDriverWait wait = Base.getWait(driver);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement footerElement=driver.findElement(By.id("gf-BIG"));
        WebElement firstColumn=footerElement.findElement(By.xpath(".//td[1]/ul"));
        List<WebElement> linkLists = firstColumn.findElements(By.tagName("a"));
        for(WebElement link:linkLists){
            link.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        int count=0;
        for(int i=1;i<windows.size();i++) {

            if (it.hasNext()) {
                count++;
                driver.switchTo().window(it.next());
//                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
                System.out.println("-----------" + count);
            }
        }


//        while(it.hasNext()){
//            count++;
//                driver.switchTo().window(it.next());
//                System.out.println(driver.getTitle());
//                System.out.println("-----------"+count);
//            }
        driver.switchTo().window(parentWindow);
        Base.closeDriver(driver);
        }


    }

