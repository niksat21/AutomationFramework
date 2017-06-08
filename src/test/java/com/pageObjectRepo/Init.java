package com.pageObjectRepo;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by niksat21 on 2/14/2017.
 */

public class Init {
    public  void launch(WebDriver driver, String url){

//        driver.manage().window().maximize();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
