package org.adlsoft;

import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.lang.*;

public class GolosovanieMfc {

    @Before
    public void logPass() {

    }

    @Test
    public void testCase() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        String csvFile = "D:\\Golos.csv";
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        while ((line = reader.readLine()) != null) {
            String str[] = line.split(";");
            if (str.length > 1) {
                System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
                System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

                driver.get("http://mfc.admhmao.ru/mfctablet/quality.htm");
                driver.findElement(By.name("fileNumber")).clear();
                driver.findElement(By.name("fileNumber")).sendKeys(str[1]);
                driver.findElement(By.name("authCode")).clear();
                driver.findElement(By.name("authCode")).sendKeys(str[4]);
                driver.findElement(By.xpath("//button[@type='button']")).click();

                Thread.sleep(5000);  // Let the user actually see something!
                driver.quit();
            }

        }

    }
}

