package org.adlsoft;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearshDelo {

        @Before
        public void setUp() throws Exception {
        }

        @Test
        public void test() throws Exception {
            WebDriver driver;
            System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver_win32\\chromedriver.exe");
            System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            driver = new ChromeDriver();
            driver.get("http://148.251.88.9:8080/mfc_hmao/admin/");
            driver.findElement(By.name("login")).clear();
            driver.findElement(By.name("login")).sendKeys("Samosadova");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("qwe123qwe");

            driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
            driver.findElement(By.id("title_iSurname")).click();
//            driver.findElement(By.id("title_iSurname")).clear();
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


