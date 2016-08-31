package org.adlsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Login {
    void Logpass(String csvFile, Integer loginkey, Integer passkey, String felogin, String fepass, String url, Integer feelement) throws IOException, InterruptedException {
        String line;
        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));


        WebDriver driver = new ChromeDriver();
        driver.get(url); //"http://mfc.admhmao.ru/mfctablet/quality.htm"
        while ((line = reader.readLine()) != null) {
//            line = reader.readLine();
            String str[] = line.split(";");
            if (str.length > 1) {
                driver.findElement(By.name(felogin)).clear();
                driver.findElement(By.name(felogin)).sendKeys(str[loginkey]);//"login", "fileNumber"
                driver.findElement(By.name(fepass)).clear();
                driver.findElement(By.name(fepass)).sendKeys(str[passkey]);//"password", "authCode"

                switch (feelement)
                {
                    case 1: driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
                        break;
                    case 2: driver.findElement(By.xpath("//button[@type='button']")).click(); //cssSelector"button[type=\"submit\"]"
                        break;
                    default:
                        break;
                }
            }
        }
    }
}