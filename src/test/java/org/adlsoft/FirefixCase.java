package org.adlsoft;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;

public class FirefixCase {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        baseUrl = "http://148.251.88.9:8080/mfc_hmao/admin/";

    }

    @Test
    public void testAppTest() throws Exception {
        System.setProperty("webdriver.firefox.driver","D:\\doc\\DriverBrowser\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();

        driver.findElement(By.name("login")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        //Form create user
        driver.get(baseUrl + "create.htm?id=11478361@SXFolder&cls=mfcUser&ra=members&ds=default&link=11478361@SXFolder&7ca8a1c17f9e33d2ec6b498540532cfc");
        driver.findElement(By.id("id_surname")).sendKeys("Авхимко");
        driver.findElement(By.id("id_name")).sendKeys("Дмитрий");
        driver.findElement(By.id("id_patronymic")).sendKeys("Леонидович");
        driver.findElement(By.id("id_login")).sendKeys("AvhimkovDL");
        driver.findElement(By.name("data(password)")).sendKeys("qwe123qwe");
        driver.findElement(By.name("data(repassword)")).sendKeys("qwe123qwe");
        new Select(driver.findElement(By.id("id_mfc"))).selectByVisibleText("Муниципальное казенное учреждение \"Многофункциональный центр предоставления государственных и муниципальных услуг г. Лянтор Сургутского района\"");
        driver.findElement(By.id("formSubmit")).click();
        //driver.findElement(By.id("title_operator")).click();
        //driver.findElement(By.id("title_controller")).click();
        //driver.findElement(By.id("title_docved")).click();
        driver.findElement(By.id("title_esia")).click();

        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }


}
