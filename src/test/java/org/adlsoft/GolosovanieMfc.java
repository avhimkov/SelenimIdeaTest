package org.adlsoft;

import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.lang.*;

public class GolosovanieMfc {
    WebDriver driver = new ChromeDriver();

    @Before
    public void logPass() throws IOException {
        Login log = new Login();
        log.Logpass("D:\\Golos.csv", 1, 4, "fileNumber", "authCode");
    }

    @Test
    public void testCase() throws IOException, InterruptedException {

                System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
                System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

                //Голосование

                Thread.sleep(5000);  // Let the user actually see something!
                driver.quit();
    }
}

