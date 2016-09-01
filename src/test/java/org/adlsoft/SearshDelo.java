package org.adlsoft;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class SearshDelo {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception {
//
        WebDriver driver = new ChromeDriver();
        driver.get("http://148.251.88.9:8080/mfc_hmao/admin/");
        String line = null;
        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        BufferedReader reader = new BufferedReader(new FileReader("D:\\login.csv"));

        while ((line = reader.readLine()) != null) {
            String str[] = line.split(";");
            if (str.length > 1) {
                driver.findElement(By.name("login")).clear();
                driver.findElement(By.name("login")).sendKeys(str[0]);//"login", "fileNumber"
                driver.findElement(By.name("password")).clear();
                driver.findElement(By.name("password")).sendKeys(str[1]);//"password", "authCode"
                driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//          Find user
                driver.switchTo().defaultContent();
                driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src ,'admin/console_welcome.htm')]")));
//        driver.findElement(By.id("id_iSurname")).click();
//        driver.findElement(By.id("id_iSurname")).sendKeys("Абубакиров");
//        driver.findElement(By.id("tid_iSurname")).sendKeys("Абубакиров");
//        driver.findElement(By.id("ttitle_iSurname")).sendKeys("Абубакиров");
                driver.findElement(By.id("title_iSurname")).sendKeys("Абубакиров");
                driver.findElement(By.cssSelector("input.button_green")).click();
                driver.findElement(By.cssSelector("button.tm")).click();
                driver.findElement(By.cssSelector("#td10358281 > nobr")).click();
                driver.findElement(By.id("td10358287")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[55]")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[37]")).click();
                driver.findElement(By.id("winCloseButton")).click();
            }
        }
        driver.quit();

    }
}


