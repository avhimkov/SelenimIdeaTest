package org.adlsoft;

import java.io.*;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.google.common.io.Files;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.lang.*;
import com.csvreader.CsvReader;





public class GolosovanieMfc{
    //    private static final String FILENAME = "C:\\1.txt";
    private WebDriver driver;
    //    private String baseUrl;
    public String numderDela = "21212121"; //111111111
    public String codAutantif = "32323"; //11111

/* ================================================================ */
    private String login() {
    String csvFile = "D:\\Golos.csv";
    String line = "";
    final String cvsSplitBy = ";";
    BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] code = line.split(cvsSplitBy);

                codAutantif = code[4];
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return codAutantif;
    }


/* ================================================================ */

    @Before
    public void logPass() {

        //baseUrl = "http://mfc.admhmao.ru/";
    }

    @Test
    public void testCase() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\DriverBrowser\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://mfc.admhmao.ru/mfctablet/quality.htm");
        driver.findElement(By.name("fileNumber")).clear();
        driver.findElement(By.name("fileNumber")).sendKeys(numderDela);
        driver.findElement(By.name("authCode")).clear();
        driver.findElement(By.name("authCode")).sendKeys(codAutantif);
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

}
