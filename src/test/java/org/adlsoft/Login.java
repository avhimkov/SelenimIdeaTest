package org.adlsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

class Login {
        WebDriver driver;
        void Logpass(String csvFile, Integer loginkey, Integer passkey, String felogin, String fepass) throws IOException {
        String loginLine;
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        while ((loginLine = reader.readLine()) != null) {
            String strLogin[] = loginLine.split(";");
            if (strLogin.length > 1) {
                driver.findElement(By.name(felogin)).clear();
                driver.findElement(By.name(felogin)).sendKeys(strLogin[loginkey]);//"login", "fileNumber"
                driver.findElement(By.name(fepass)).clear();
                driver.findElement(By.name(fepass)).sendKeys(strLogin[passkey]);//"password", "authCode"
                driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
            }

        }

    }
}