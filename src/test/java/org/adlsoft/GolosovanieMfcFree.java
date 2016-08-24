package org.adlsoft;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class GolosovanieMfcFree {

    @Before
    public void logPass() {
        //baseUrl = "http://mfc.admhmao.ru/";
    }

    @Test
    public void testCase() throws InterruptedException, IOException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("http://mfc.admhmao.ru/mfctablet/quality.htm");
        driver.findElement(By.name("fileNumber")).clear();
        driver.findElement(By.name("fileNumber")).sendKeys("11111111");
        driver.findElement(By.name("authCode")).clear();
        driver.findElement(By.name("authCode")).sendKeys("11111");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();

    }

}

