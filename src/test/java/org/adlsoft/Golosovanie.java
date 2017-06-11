package org.adlsoft;

import java.io.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.lang.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Golosovanie {
    @Test
    public void testCase() throws IOException, InterruptedException {
//      Голосование

//        driver.navigate().to("http://148.251.88.9:8080/mfc_hmao/admin/edit.htm?id=910019@mfcSocServPetition");
//        List<WebElement> allAuthors =  driver.findElements(By.className("blabala"));
//        List<WebElement> allTitles =  driver.findElements(By.className("blabala"));
//        int i=0;
//        String fileText = "";
//
//        for (WebElement author : allAuthors){
//            String authorName = author.getText();
//            String Url = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", allTitles.get(i++));
//            final Pattern pattern = Pattern.compile("title=(.+?)>");
//            final Matcher matcher = pattern.matcher(Url);
//            matcher.find();
//            String title = matcher.group(1);
//            fileText = fileText+authorName+","+title+"\n";
//        }
//        String text = driver.findElement(By.css("h1")).getText();

        String line;
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        String basedurl = ("http://mfc.admhmao.ru/mfctablet/quality.htm");
        WebDriver driver = new ChromeDriver();
        driver.get(basedurl);
        BufferedReader reader = new BufferedReader(new FileReader("src/csv/golos.csv"));
        while ((line = reader.readLine()) != null) {
            String str[] = line.split(";");
            if (str.length > 1) {
                driver.findElement(By.name("fileNumber")).clear();
                driver.findElement(By.name("fileNumber")).sendKeys(str[1]);
                driver.findElement(By.name("authCode")).clear();
                driver.findElement(By.name("authCode")).sendKeys(str[4]);
                driver.findElement(By.xpath("//button[@type='button']")).click();
                driver.findElement(By.xpath("//div[@id='page0']/div[2]/div/div[2]/ul/li[5]/label/span")).click();
                driver.findElement(By.xpath("//button[@type='button']")).click();
                driver.findElement(By.xpath("//div[@id='page1']/div[2]/div/div[2]/ul/li[4]/label/span")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
                driver.findElement(By.xpath("//div[@id='page2']/div[2]/div/div[2]/ul/li[5]/label/span")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
                driver.findElement(By.xpath("//div[@id='page3']/div[2]/div/div[2]/ul/li[5]/label/span")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
                driver.findElement(By.xpath("//div[@id='page4']/div[2]/div/div[2]/ul/li[5]/label/span")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
                Thread.sleep(1000);
            }
        }
        driver.quit();
    }
}
