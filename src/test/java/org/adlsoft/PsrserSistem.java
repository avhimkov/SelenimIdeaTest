package org.adlsoft;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PsrserSistem {
    public static void main(String[] args) throws IOException {

        File input = new File("src/html/MFC12.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Elements tableRows = doc.getElementsByTag("td");
//        Elements links = doc.getElementsByTag("a");

//        for(Element row : tableRows) {
//            Elements tableHeaders = row.getElementsByTag("tr");
//            //get text content of each cell element
//            for (Element element : tableHeaders) {
//                String elementText = element.text();
//                //print out the content
//                System.out.print(elementText + " ");
//            }
//        }
//        List<String> text = new ArrayList<>();
        for (Element row : tableRows) {
            Elements tableCells = row.getElementsByTag("td");
            String[] elementText = tableCells.text().split(" ");
            System.out.print(elementText[23] + " ");
        }

//        List<String> list = new ArrayList<>();
//        try (Stream<String> stream = Files.lines(Paths.get(put), Charset.forName("windows-1251"))) {
//            list = stream
//                    .filter(line -> line.contains(numberWindow))
//                    .filter(line -> line.contains(findeSring))
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        list.forEach(System.out::println);
    }
}
