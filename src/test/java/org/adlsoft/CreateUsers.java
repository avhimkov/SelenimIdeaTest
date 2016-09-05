package org.adlsoft;

import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.lang.*;

public class CreateUsers {

    @Test
    public void testCase() throws InterruptedException, IOException {
        String lineLogin;
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        String basedurl = "http://148.251.88.9:8080/mfc_hmao/admin/";
        WebDriver driver = new ChromeDriver();
        driver.get("http://148.251.88.9:8080/mfc_hmao/admin/");
        BufferedReader reader1 = new BufferedReader(new FileReader("src/csv/login.csv"));
        while ((lineLogin = reader1.readLine()) != null) {
            String str[] = lineLogin.split(";");
            if (str.length > 1) {
                driver.findElement(By.name("login")).clear();
                driver.findElement(By.name("login")).sendKeys(str[0]);//"login", "fileNumber"
                driver.findElement(By.name("password")).clear();
                driver.findElement(By.name("password")).sendKeys(str[1]);//"password", "authCode"
                driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

                //Form create user
                String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/csv/UsersAdd.csv"), "windows-1251"));
                while ((line = reader.readLine()) != null) {
                    String strUsers[] = line.split(";");
                    if (strUsers.length > 1) {

                        driver.get(basedurl + "create.htm?id=11478361@SXFolder&cls=mfcUser&ra=members&ds=default&link=11478361@SXFolder&7ca8a1c17f9e33d2ec6b498540532cfc");
                        driver.findElement(By.id("id_surname")).clear();
                        driver.findElement(By.id("id_surname")).sendKeys(strUsers[0]); //Авхимко
                        driver.findElement(By.id("id_name")).clear();
                        driver.findElement(By.id("id_name")).sendKeys(strUsers[1]); //Дмитрий
                        driver.findElement(By.id("id_patronymic")).clear();
                        driver.findElement(By.id("id_patronymic")).sendKeys(strUsers[2]); //Леонидович
                        driver.findElement(By.id("id_login")).clear();
                        driver.findElement(By.id("id_login")).sendKeys(strUsers[3]); //AvhimkovDL
                        driver.findElement(By.name("data(password)")).clear();
                        driver.findElement(By.name("data(password)")).sendKeys(strUsers[4]); //qwe123qwe
                        driver.findElement(By.name("data(repassword)")).clear();
                        driver.findElement(By.name("data(repassword)")).sendKeys(strUsers[5]); //qwe123qwe
                        new Select(driver.findElement(By.id("id_mfc"))).selectByVisibleText("Муниципальное казенное учреждение \"Многофункциональный центр предоставления государственных и муниципальных услуг г. Лянтор Сургутского района\"");
                        driver.findElement(By.id("formSubmit")).click();
                        driver.findElement(By.id("title_operator")).click();
//                        int fe_id = 0;
//                        switch (fe_id) {
//                            case 1:
//                                driver.findElement(By.id("title_operator")).click();
//                                break;
//                            case 2:
//                                driver.findElement(By.id("title_controller")).click();
//                                break;
//                            case 3:
//                                driver.findElement(By.id("title_docved")).click();
//                                break;
//                            case 4:
//                                driver.findElement(By.id("title_esia")).click();
//                                break;
//                            default:
//                                break;
//                        }
                    }
                }
            }
        }
        driver.quit();
    }
}
