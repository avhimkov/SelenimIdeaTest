package org.adlsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class CreateUsers {

    @Before
    public void logPass() throws IOException {
    }

    @Test
    public void testCase() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        Login log = new Login();
        log.Logpass("D:\\Login.csv", 0, 1, "login", "password", "http://148.251.88.9:8080/mfc_hmao/admin/", 1);

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
                driver.findElement(By.id("title_operator")).click();
//                int fe_id = 0;
//                switch (fe_id)
//                {
//                    case 1: driver.findElement(By.id("title_operator")).click();
//                        break;
//                    case 2: driver.findElement(By.id("title_controller")).click();
//                        break;
//                    case 3: driver.findElement(By.id("title_docved")).click();
//                        break;
//                    case 4: driver.findElement(By.id("title_esia")).click();
//                        break;
//                    default:
//                        break;
//                }
                Thread.sleep(5000);  // Let the user actually see something!

            }
        }
        driver.quit();
//                Thread.sleep(5000);  // Let the user actually see something!
//                driver.quit();
    }
}
