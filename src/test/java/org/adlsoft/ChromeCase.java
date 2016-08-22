package org.adlsoft;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class ChromeCase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void logPass(){
        baseUrl = "http://148.251.88.9:8080/";
    }

    @Test
    public void testCase() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\doc\\FirefoxDriver\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Users\\adl\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://148.251.88.9:8080/mfc_hmao/admin/");


        driver.findElement(By.name("login")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.get(baseUrl + "create.htm?id=11478361@SXFolder&cls=mfcUser&ra=members&ds=default");
//        driver.findElement(By.id("plus10358393@SXFolder")).click();
//        driver.findElement(By.linkText("Сотрудники")).click();
//        Thread.sleep(5000);  // Let the user actually see something!
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();


//        System.setProperty("webdriver.firefox.marionette","D:\\doc\\FirefoxDriver\\geckodriver.exe");
//        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//
//        driver = new FirefoxDriver();
////        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
//        //driver.get("http://ya.ru/");
//        driver.quit();
//        driver.close();
    }
}
