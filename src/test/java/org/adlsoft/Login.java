package org.adlsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Login {
        WebDriver driver;
        public void Logpass(String csvFile, Integer login, Integer pass) throws IOException {
        String loginLine;
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        while ((loginLine = reader.readLine()) != null) {
            String strLogin[] = loginLine.split(";");
            if (strLogin.length > 1) {
                driver.findElement(By.name("login")).clear();
                driver.findElement(By.name("login")).sendKeys(strLogin[login]);
                driver.findElement(By.name("password")).clear();
                driver.findElement(By.name("password")).sendKeys(strLogin[pass]);
                driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
            }

        }

    }
}