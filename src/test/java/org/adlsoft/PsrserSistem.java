package org.adlsoft;

import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * Created by adl on 22.10.2016.
 */
public class PsrserSistem {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src\\html\\MFC12.html");
        Document parser = new Jsoup.parse();
    }


}
