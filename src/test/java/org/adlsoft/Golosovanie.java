package org.adlsoft;

import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.lang.*;

public class Golosovanie {

    @Test
    public void testCase() throws IOException, InterruptedException {
//      Голосование
        String line;
        BufferedReader reader = new BufferedReader(new FileReader("src/csv/golos.csv"));
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://mfc.admhmao.ru/mfctablet/quality.htm");
        while ((line = reader.readLine()) != null) {
            String str[] = line.split(";");
            if (str.length > 1) {
                driver.findElement(By.name("fileNumber")).clear();
                driver.findElement(By.name("fileNumber")).sendKeys(str[1]);
                driver.findElement(By.name("authCode")).clear();
                driver.findElement(By.name("authCode")).sendKeys(str[4]);
                driver.findElement(By.xpath("//button[@type='button']")).click();
                driver.findElement(By.xpath("//div[@id='page0']/div[2]/div/div[2]/ul/li[5]/label/span")).click();
                driver.findElement(By.xpath("//button[@type='button']")).click();
                driver.findElement(By.xpath("//div[@id='page1']/div[2]/div/div[2]/ul/li[4]/label/span")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
                driver.findElement(By.xpath("//div[@id='page2']/div[2]/div/div[2]/ul/li[5]/label/span")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
                driver.findElement(By.xpath("//div[@id='page3']/div[2]/div/div[2]/ul/li[5]/label/span")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
                driver.findElement(By.xpath("//div[@id='page4']/div[2]/div/div[2]/ul/li[5]/label/span")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
                Thread.sleep(1000);
            }
        }
        driver.quit();
    }
}
