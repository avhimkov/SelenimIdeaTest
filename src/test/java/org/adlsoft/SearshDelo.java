package org.adlsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.adlsoft.Login;


public class SearshDelo {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception {
        Login log = new Login();
        log.Logpass("D:\\login.csv", 0, 1, "login", "password", "http://148.251.88.9:8080/mfc_hmao/admin/");

        WebDriver driver = new ChromeDriver();

//        driver.findElement(By.xpath("//button[@type='button']")).click();

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
}


