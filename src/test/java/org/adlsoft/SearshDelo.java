package org.adlsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.adlsoft.Login;


public class SearshDelo {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
//        Logpass("D:\\Golos.csv", 1, 4);
    }

    @Test
    public void test() throws Exception {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        driver.get("http://148.251.88.9:8080/mfc_hmao/admin/");

        driver.findElement(By.id("title_iSurname")).click();
        driver.findElement(By.id("title_iSurname")).sendKeys("Абубакиров");
        driver.findElement(By.cssSelector("input.button_green")).click();
        driver.findElement(By.cssSelector("button.tm")).click();
        driver.findElement(By.cssSelector("#td10358281 > nobr")).click();
        driver.findElement(By.id("td10358287")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[55]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[37]")).click();
        driver.findElement(By.id("winCloseButton")).click();
    }


//    public void Logpass(String csvFile) throws IOException {
//
//        String loginLine;
//        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
//
//        while ((loginLine = reader.readLine()) != null) {
////            String strLogin[] = loginLine.split(";");
////            if (strLogin.length > 1) {
////                driver.findElement(By.name("login")).clear();
////                driver.findElement(By.name("login")).sendKeys("Samosadova");
////                driver.findElement(By.name("password")).clear();
////                driver.findElement(By.name("password")).sendKeys("qwe123qwe");
////                driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
////            }
////
////        }
//
//    }


}


