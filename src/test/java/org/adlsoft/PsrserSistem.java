package org.adlsoft;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PsrserSistem {
    public static void main(String[] args) throws IOException {

//      "../MFC12.html");
        Document doc = Jsoup.parse(new File("src/html/MFC12.html"), "UTF-8");
        Elements tableRows = doc.getElementsByTag("tr");

        try {
            for (Element row : tableRows) {
                Elements tableCells = row.getElementsByTag("tr");
                String elementText = tableCells.text();
                String[] arrstring = elementText.split(" ");
                int result = elementText.indexOf("MFC");
                String text = elementText.substring(result, result+14);
                System.out.println(text);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
//            System.out.println("Error");
        }

//        for(Element row : tableRows) {
//            Elements tableHeaders = row.getElementsByTag("tr");
//            for (Element element : tableHeaders) {
//                String elementText = element.text();
//                System.out.print(elementText + " ");
//            }
//        }
    }
}
