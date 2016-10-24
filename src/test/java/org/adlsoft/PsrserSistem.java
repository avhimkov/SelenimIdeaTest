package org.adlsoft;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PsrserSistem {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.parse(new File("src/html/MFC12.html"), "UTF-8"); //"../MFC12.html");
        Pattern pattern = Pattern.compile("^MFC\\w[0-9]\\d{2}-[0-9]\\d{6}-[0-9]\\d]+$");

        try {
            Elements tableRows = doc.getElementsByTag("tr");
            String elementText = tableRows.text();

            Matcher matcher = pattern.matcher(elementText);

            int result = elementText.lastIndexOf("MFC");
            int result1 = elementText.indexOf("10");
            String text = elementText.substring(result, result + 14);
//            String text1 = elementText.substring(result1, result1 + 5);
            System.out.println(text);
//            System.out.println(text1);
            System.out.println(elementText.substring(matcher.start(), matcher.end()));
        } catch (StringIndexOutOfBoundsException e) {
//            e.printStackTrace();
//            System.out.println("Error");
        }
    }
}
