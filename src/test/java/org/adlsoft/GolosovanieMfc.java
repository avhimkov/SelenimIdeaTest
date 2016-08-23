package org.adlsoft;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

public class GolosovanieMfc {

    private WebDriver driver;
    private String baseUrl;
    public String numderDela;
    public String codAutantif;

    @Before
    public void logPass(){
        baseUrl = "http://mfc.admhmao.ru/";
    }

    @Test
    public void testCase() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl + "/mfctablet/quality.htm");
        driver.findElement(By.name("fileNumber")).clear();
        driver.findElement(By.name("fileNumber")).sendKeys("111111111");
        driver.findElement(By.name("authCode")).clear();
        driver.findElement(By.name("authCode")).sendKeys("11111");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

}
