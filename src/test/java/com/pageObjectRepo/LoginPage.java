package com.pageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Properties;

/**
 * Created by niksat21 on 2/14/2017.
 */

public class LoginPage {

    private static WebElement element = null;

    public  WebElement userNameTxtBox(WebDriver driver, Properties locatorProp){

        String loc = locatorProp.getProperty("userName");
        element = driver.findElement(By.id(loc));
        return element;

    }

    public  WebElement passwordTxtBox(WebDriver driver,Properties locatorProp) {

        String loc = locatorProp.getProperty("password");
        element = driver.findElement(By.id(loc));
        return element;

    }

    public  WebElement signInButton(WebDriver driver,Properties locatorProp) {

        String loc = locatorProp.getProperty("signinButton");
        element = driver.findElement(By.className(loc));
        return element;

    }




}
