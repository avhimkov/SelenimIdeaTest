package org.adlsoft;

import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.lang.*;

public class GolosovanieMfc {

    @Before
    public void logPass() throws IOException {
    }

    @Test
    public void testCase() throws IOException, InterruptedException {

        Login log = new Login();
        log.Logpass("D:\\golos.csv", 1, 4, "fileNumber", "authCode", "http://mfc.admhmao.ru/mfctablet/quality.htm", 2);

        WebDriver driver = new ChromeDriver();
//        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        //Голосование

//        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}

