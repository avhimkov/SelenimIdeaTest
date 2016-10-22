package org.adlsoft;

import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Created by adl on 22.10.2016.
 */
public class PsrserSistem {
    public static void main(String[] args) throws IOException {
        File input = new File("src/html/MFC12.html");
        Document doc = Jsoup.parse(input,"UTF-8");
        Elements tableRows=doc.getElementsByTag("tr");
        for(Element row : tableRows)
        {
            Elements tableHeaders=row.getElementsByTag("th");
            for (Element element : tableHeaders) {
                //get text content of each cell element
                String elementText = element.text();
                //print out the content
                System.out.print(elementText +" ");
            }
        }
        //get each row to content without header
        for(Element row : tableRows)
        {
            Elements tableCells=row.getElementsByTag("td");
            //iterate over each element
            for (Element element : tableCells) {
                //get text content of each cell element
                String elementText = element.text();
                //print out the content
                System.out.print(elementText +" ");
            }
            System.out.println();
        }
    }


}
