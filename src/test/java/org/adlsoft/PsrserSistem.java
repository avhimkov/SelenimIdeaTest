package org.adlsoft;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PsrserSistem {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.parse(new File("src/html/MFC12.html"), "UTF-8"); //"../MFC12.html");
            String folderNumber = doc.select("td:containsOwn(MFC)").first().text();
            System.out.println("Номер дела" + "\n" + folderNumber + "\n");
            String authCode = doc.select("td:matches(^(\\d{5})$)").first().text();
            System.out.println("Код авторизации" + "\n" + authCode + "\n");
    }
}
