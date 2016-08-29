package org.adlsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Login {
    void Logpass(String csvFile, Integer loginkey, Integer passkey, String felogin, String fepass, String url) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");


        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        WebDriver driver = new ChromeDriver();
        driver.get(url); //"http://mfc.admhmao.ru/mfctablet/quality.htm"
        for (String loginLine; (loginLine = reader.readLine()) != null; ) {
            String strLogin[] = loginLine.split(";");
            if (strLogin.length > 1) {
                driver.findElement(By.name(felogin)).clear();
                driver.findElement(By.name(felogin)).sendKeys(strLogin[loginkey]);//"login", "fileNumber"
                driver.findElement(By.name(fepass)).clear();
                driver.findElement(By.name(fepass)).sendKeys(strLogin[passkey]);//"password", "authCode"
                driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
                driver.findElement(By.xpath("//button[@type='button']")).click(); //cssSelector"button[type=\"submit\"]"

//                Thread.sleep(5000);
            }
//                else
//                {
//                    driver.quit();
//                }
        }
//        while ((loginLine = reader.readLine()) != null) {
//
//
//
//        }

    }
}