package org.adlsoft;


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

@Before
public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://148.251.88.9:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

@Test
public void test1111() throws Exception {
        driver.get(baseUrl + "/mfc_hmao/admin/");
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | nav | ]]
        driver.findElement(By.id("plus10358393@SXFolder")).click();
        driver.findElement(By.linkText("Сотрудники")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=toolbar | ]]
        driver.findElement(By.cssSelector("td.menu_over > button.tm")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
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
