package org.adlsoft;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PsrserSistem {
    public static void main(String[] args) throws IOException {

        //            Pattern pattern = Pattern.compile("a-zA-Z0-9");//^MFC\w[0-9]\d{2}-[0-9]\d{6}-[0-9]\d]+$

        Document doc = Jsoup.parse(new File("src/html/MFC12.html"), "UTF-8"); //"../MFC12.html");
            String tableRows = doc.select("td:containsOwn(MFC)").first().text();
            System.out.println(tableRows);
    }
}
