package org.adlsoft;

import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.lang.*;

public class Golosovanie {

    @Before
    public void logPass() throws IOException {
    }

    @Test
    public void testCase() throws IOException, InterruptedException {
//      Голосование
        String line;
        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        BufferedReader reader = new BufferedReader(new FileReader("D:\\golos.csv"));

        WebDriver driver = new ChromeDriver();
        driver.get("http://mfc.admhmao.ru/mfctablet/quality.htm"); //"http://mfc.admhmao.ru/mfctablet/quality.htm"
        while ((line = reader.readLine()) != null) {
            String str[] = line.split(";");
            if (str.length > 1) {
                driver.findElement(By.name("fileNumber")).clear();
                driver.findElement(By.name("fileNumber")).sendKeys(str[1]);//"login", "fileNumber"
                driver.findElement(By.name("authCode")).clear();
                driver.findElement(By.name("authCode")).sendKeys(str[4]);//"password", "authCode"
                driver.findElement(By.xpath("//button[@type='button']")).click();

            }
        }
    }
}

