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
        Login log = new Login();
        log.Logpass("D:\\golos.csv", 1, 4, "fileNumber", "authCode", "http://mfc.admhmao.ru/mfctablet/quality.htm", 2);

        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}

