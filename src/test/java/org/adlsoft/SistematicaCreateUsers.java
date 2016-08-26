package org.adlsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class SistematicaCreateUsers {
//    private WebDriver driver;
//    private String baseUrl;
//    public String login = "AvhimkovDL";
//    public String pass = "";
//
//    public String id_surname = "Авхимко";
//    public String id_name = "Дмитрий";
//    public String id_patronymic = "Леонидович";
//    public String id_login = "AvhimkovDL";
//    public String data_password = "qwe123qwe";
//    public String data_repassword = "qwe123qwe";

    @Before
    public void logPass() {

//        baseUrl = "http://148.251.88.9:8080/mfc_hmao/admin/";
    }

    @Test
    public void testCase() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://148.251.88.9:8080/mfc_hmao/admin/");
        String csvFile = "D:\\loginOperator.csv";
        String line = "";
        String csvFile1 = "D:\\UsersAdd.csv";
        String line1 = "";
        BufferedReader reader1 = new BufferedReader(new FileReader(csvFile1));
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        while ((line = reader.readLine()) != null) {
            String str[] = line.split(";");
            if (str.length > 1) {
                System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver.exe");
                System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                driver.findElement(By.name("login")).sendKeys(str[0]);
                driver.findElement(By.name("password")).sendKeys(str[1]);
                driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

                while ((line = reader.readLine()) != null) {
                    String str1[] = line.split(";");
                    if (str.length > 1) {

                        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver.exe");
                        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                        //Form create user
                        driver.get("http://148.251.88.9:8080/mfc_hmao/admin/create.htm?id=11478361@SXFolder&cls=mfcUser&ra=members&ds=default&link=11478361@SXFolder&7ca8a1c17f9e33d2ec6b498540532cfc");
                        driver.findElement(By.id("id_surname")).clear();
                        driver.findElement(By.id("id_surname")).sendKeys(str1[0]); //Авхимко
                        driver.findElement(By.id("id_name")).clear();
                        driver.findElement(By.id("id_name")).sendKeys(str1[1]); //Дмитрий
                        driver.findElement(By.id("id_patronymic")).clear();
                        driver.findElement(By.id("id_patronymic")).sendKeys(str1[2]); //Леонидович
                        driver.findElement(By.id("id_login")).clear();
                        driver.findElement(By.id("id_login")).sendKeys(str1[3]); //AvhimkovDL
                        driver.findElement(By.name("data(password)")).clear();
                        driver.findElement(By.name("data(password)")).sendKeys(str1[4]); //qwe123qwe
                        driver.findElement(By.name("data(repassword)")).clear();
                        driver.findElement(By.name("data(repassword)")).sendKeys(str1[5]); //qwe123qwe
                        new Select(driver.findElement(By.id("id_mfc"))).selectByVisibleText("Муниципальное казенное учреждение \"Многофункциональный центр предоставления государственных и муниципальных услуг г. Лянтор Сургутского района\"");
                        driver.findElement(By.id("formSubmit")).click();
                        //driver.findElement(By.id("title_operator")).click();
                        //driver.findElement(By.id("title_controller")).click();
                        //driver.findElement(By.id("title_docved")).click();
                        driver.findElement(By.id("title_esia")).click();
                        Thread.sleep(5000);  // Let the user actually see something!

                    }
                }

//                Thread.sleep(5000);  // Let the user actually see something!
//                driver.quit();
            }
        }



        driver.quit();

    }
}