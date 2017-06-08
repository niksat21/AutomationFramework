package com.testScripts;

import com.appModule.LoginModule;
import com.pageObjectRepo.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

//import static org.testng.Assert.assertEquals;

/**
 * Created by niksat21 on 2/14/2017.
 */
public class InvalidLoginTest {



    public static WebDriver driver=null;
    private static WebDriverWait _wait=null;
    private static Properties dataProp,locatorProp;
    private InputStream dataInputStream,locatorInputStream;

//    @Before
    public void setup() throws IOException {


//        driver = new ChromeDriver();
        driver = new HtmlUnitDriver();
        _wait = new WebDriverWait(driver,10);
        System.setProperty("webdriver.chrome.driver", "driverExe/chromedriver.exe");


        //loading data from prop file
        dataProp = new Properties();
        String dataPropFileName = "data.properties";

        dataInputStream = getClass().getClassLoader().getResourceAsStream(dataPropFileName);
        if(dataInputStream!=null){
            dataProp.load(dataInputStream);
        }else {
            throw new FileNotFoundException("property file '" + dataPropFileName + "' not found in the classpath");
        }

        //laoding locator prop file
        locatorProp = new Properties();
        String locatorPropFileName = "locator.properties";

        locatorInputStream = getClass().getClassLoader().getResourceAsStream(locatorPropFileName);
        if(locatorInputStream!=null){
            locatorProp.load(locatorInputStream);
        }else {
            throw new FileNotFoundException("property file '" + locatorPropFileName + "' not found in the classpath");
        }

        Init init = new Init();
        init.launch(driver,dataProp.getProperty("homeTestURL"));

    }

//    @Test
    public void doInValidLogin0(){
        System.out.println("came here");

        // 1. Check if we are currently landed on correct page
        String url = driver.getCurrentUrl();
        System.out.println(url);
//        assertEquals(url,dataProp.getProperty("homeTestURL"));

        // 2. Perform login action
        LoginModule log = new LoginModule();
        log.login(driver,locatorProp,"dsfd", "dfmdnf");

        WebElement element = driver.findElement(By.id(locatorProp.getProperty("errorMsgLogin")));
        if(element!=null){

            System.out.println("error : "+element.getText());
            System.out.println("error text : "+element.getAttribute("outerText"));
//            assertEquals(element.getText(),"Invalid Username or Password. Please Try Again.");
        }else{
            System.out.println("null error element");
        }

    }

//    @Test
    public void doInValidLogin1(){
        System.out.println("came here");

        // 1. Check if we are currently landed on correct page
        String url = driver.getCurrentUrl();
        System.out.println(url);
//        assertEquals(url,dataProp.getProperty("homeTestURL"));

        // 2. Perform login action
        LoginModule log = new LoginModule();
        log.login(driver,locatorProp,"@dsf", "123");

        WebElement element = driver.findElement(By.id(locatorProp.getProperty("errorMsgLogin")));
        if(element!=null){
            System.out.println(element.getText());
            System.out.println("error text : "+element.getAttribute("outerText"));
//            assertEquals(element.getText(),"Invalid Username or Password. Please Try Again.");
        }else{
            System.out.println("null error element");
        }

    }

//    @After
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

}
