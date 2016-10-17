package edu.bim313;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        String url = args[0];

        //"http://www.kimya.anadolu.edu.tr/OgretimElemanlari.aspx";
        System.out.println("Fetching: " + url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");


        for (Element link : links) {
            String s = link.attr("abs:href").trim();

            if (s.startsWith("mailto:"))
                System.out.println(s.substring(7));
        }
    }
}