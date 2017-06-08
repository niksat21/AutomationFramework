package com.appModule;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.pageObjectRepo.LoginPage;

import java.util.Properties;


/**
 * Created by niksat21 on 2/14/2017.
 */
public class LoginModule {


    private static WebElement element=null;

    public  void login(WebDriver driver, Properties locatorProp, String userName, String password){

        LoginPage logPage = new LoginPage();
        //Enter username
        element = logPage.userNameTxtBox(driver,locatorProp);
        if(element!=null){
            element.clear();
            element.sendKeys(userName);
        }else{
            System.out.println("username field is not yet displayed");
        }


        //Enter password
        element = logPage.passwordTxtBox(driver,locatorProp);
        if(element!=null){
            element.clear();
            element.sendKeys(password);
        }else{
            System.out.println("password field is not yet displayed");
        }


        //click on sign in button

        element = logPage.signInButton(driver,locatorProp);
        if(element!=null){
            element.click();
        }else {
            System.out.println("sign in button is not clickable");
        }


    }

}
