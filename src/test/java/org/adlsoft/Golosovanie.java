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
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        String line;
        WebDriver driver = new ChromeDriver();
        driver.get("http://mfc.admhmao.ru/mfctablet/quality.htm");
        BufferedReader reader = new BufferedReader(new FileReader("src/csv/golos.csv"));
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
        driver.quit();
    }
}
