package com.test;

import com.utility.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Objects;

public class BrokenLinks {
    public static void main(String[] args) throws IOException, URISyntaxException {


        WebDriver driver = Base.loadDriver("Chrome");
        WebDriverWait wait = Base.getWait(driver);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        List <WebElement> listOfSites=driver.findElements(By.xpath("//a"));
        List <WebElement> listOfSites=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        String url=null;
        HttpURLConnection conn=null;
        int respCode=0;

        for(WebElement brokeSite:listOfSites){
            url=brokeSite.getAttribute("href");
            conn=(HttpURLConnection) new URI(Objects.requireNonNull(brokeSite.getAttribute("href"))).toURL().openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            respCode = conn.getResponseCode();
            if (respCode>400){
                System.out.println(brokeSite.getText());
            }
        }


    }
}
