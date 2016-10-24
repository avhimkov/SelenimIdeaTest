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
        Elements tableRows = doc.getElementsByTag("td");
//        for(Element row : tableRows) {
//            Elements tableHeaders = row.getElementsByTag("tr");
//            for (Element element : tableHeaders) {
//                String elementText = element.text();
//                System.out.print(elementText + " ");
//            }
//        }
        try {
            for (Element row : tableRows) {
                Elements tableCells = row.getElementsByTag("td");
                String elementText = tableCells.text();
//                boolean result = elementText.contains("MFC");
                String[] text = elementText.split(" ");
                if (elementText.matches("MFC")){
                    String result = text[5];
                    System.out.println(result);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
//            System.out.println("Error");
        }
    }

//    static void findString(String put, String findeSring) throws IOException  {
//        List<String> list = new ArrayList<>();
//        try (Stream<String> stream = Files.lines(Paths.get(put), Charset.forName("windows-1251"))) {
//            list = stream
//                    .filter(line -> line.contains())
//                    .filter(line -> line.contains())
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        list.forEach(System.out::println);
//    }
}
