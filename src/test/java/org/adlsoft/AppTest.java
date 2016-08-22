package org.adlsoft;


import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AppTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
//    public String pass;
//    public String logen;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://148.251.88.9:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAppTest() throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = in.nextLine();
        System.out.print("Введите пароль: ");
        String pass = in.nextLine();



        driver.get(baseUrl + "/mfc_hmao/admin/");
        //driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | nav | ]]
        driver.findElement(By.id("plus10358393@SXFolder")).click();
        driver.findElement(By.linkText("Сотрудники")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=toolbar | ]]
        driver.findElement(By.cssSelector("td.menu_over > button.tm")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
        driver.get(baseUrl + "/mfc_hmao/admin/create.htm?id=11478361@SXFolder&cls=mfcUser&ra=members&ds=default&link=11478361@SXFolder&4ee81ab52eb8829b2b585fd95907bc67");

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
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
