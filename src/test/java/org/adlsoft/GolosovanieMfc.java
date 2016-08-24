package org.adlsoft;

import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.lang.*;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class GolosovanieMfc {

    @Before
    public void logPass() {
        //baseUrl = "http://mfc.admhmao.ru/";
    }

    @Test
    public void testCase() throws InterruptedException, IOException {
        WebDriver driver;
//        String numderDela; //111111111
//        String codAutantif; //11111
        String csvFile = "D:\\Golos.csv";
        String line = null;
        final String cvsSplitBy = ";";
        BufferedReader br = null;

        br = new BufferedReader(new FileReader(csvFile));
        // use comma as separator
        String[] code = line.split(cvsSplitBy);
        Map<String, String> map = new HashMap<String, String>();
        for (Map.Entry<String, String> item : map.entrySet()) {
            String key = item.getKey();
            String value = item.getValue();
            System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver.exe");
            System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            driver = new ChromeDriver();
            driver.get("http://mfc.admhmao.ru/mfctablet/quality.htm");
            driver.findElement(By.name("fileNumber")).clear();
            driver.findElement(By.name("fileNumber")).sendKeys(key);
            driver.findElement(By.name("authCode")).clear();
            driver.findElement(By.name("authCode")).sendKeys(value);
//                driver.findElement(By.xpath("//button[@type='button']")).click();

            Thread.sleep(5000);  // Let the user actually see something!
            driver.quit();

        }

    }

}
