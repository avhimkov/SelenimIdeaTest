package org.adlsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class SistematicaCreateUsers {
    private WebDriver driver = new ChromeDriver();

    @Before
    public void logPass() throws IOException {
        Login log = new Login();
        log.Logpass("D:\\Login.csv", 0, 1, "login", "password");
    }

    @Test
    public void testCase() throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver.get("http://148.251.88.9:8080/mfc_hmao/admin/");

        String csvAddUserFile = "D:\\UsersAdd.csv";
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(csvAddUserFile));

        //Form create user
        while ((line = reader.readLine()) != null) {
            String str[] = line.split(";");
            if (str.length > 1) {

                driver.get("http://148.251.88.9:8080/mfc_hmao/admin/create.htm?id=11478361@SXFolder&cls=mfcUser&ra=members&ds=default&link=11478361@SXFolder&7ca8a1c17f9e33d2ec6b498540532cfc");
                driver.findElement(By.id("id_surname")).clear();
                driver.findElement(By.id("id_surname")).sendKeys(str[0]); //Авхимко
                driver.findElement(By.id("id_name")).clear();
                driver.findElement(By.id("id_name")).sendKeys(str[1]); //Дмитрий
                driver.findElement(By.id("id_patronymic")).clear();
                driver.findElement(By.id("id_patronymic")).sendKeys(str[2]); //Леонидович
                driver.findElement(By.id("id_login")).clear();
                driver.findElement(By.id("id_login")).sendKeys(str[3]); //AvhimkovDL
                driver.findElement(By.name("data(password)")).clear();
                driver.findElement(By.name("data(password)")).sendKeys(str[4]); //qwe123qwe
                driver.findElement(By.name("data(repassword)")).clear();
                driver.findElement(By.name("data(repassword)")).sendKeys(str[5]); //qwe123qwe
                new Select(driver.findElement(By.id("id_mfc"))).selectByVisibleText("Муниципальное казенное учреждение \"Многофункциональный центр предоставления государственных и муниципальных услуг г. Лянтор Сургутского района\"");
                driver.findElement(By.id("formSubmit")).click();
                //driver.findElement(By.id("title_operator")).click();
                //driver.findElement(By.id("title_controller")).click();
                //driver.findElement(By.id("title_docved")).click();
                driver.findElement(By.id("title_esia")).click();
                Thread.sleep(5000);  // Let the user actually see something!

            }
        }
        driver.quit();
//                Thread.sleep(5000);  // Let the user actually see something!
//                driver.quit();
    }
}
