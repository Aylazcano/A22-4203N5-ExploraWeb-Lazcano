package lazcano.explora;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Methodes {

    public static void main(String args[]) throws IOException {
        //Tests
//        String url = "https://info.cegepmontpetit.ca/3N5-Prog3/phase1.html";
//        System.out.println("Titre: " + titreDeLaPage(url) + " liens " + nbrDeLiens(url));

//        System.out.println("decompose en liste " + findDuplicates(listeDepuisTableau("pipo popip pipo aaa sudiosus aaa".split(" "))));
    }

    public static List<String> listeDepuisTableau(String[] tableau){
        return new ArrayList<>(Arrays.asList(tableau));
    }

    public static Set<String> chercheRepetitions(List<String> liste) {
        final Set<String> setARetourner = new HashSet<>();
        final Set<String> set1 = new HashSet<>();

        for (String mot : liste) {
            if (!set1.add(mot)) {
                setARetourner.add(mot);
            }
        }
        return setARetourner;
    }

    public static String titreDeLaPage(String url) throws IOException {
        //Get Document object after parsing the html from given url.
        Document document = Jsoup.connect(url).get();

        //Get title from document object.
        String title = document.title();
        return title;
    }

    public static Integer nbrDeLiens(String url) throws IOException {
        //Get Document object after parsing the html from given url.
        Document document = Jsoup.connect(url).get();

        //Get links from document
        Elements links = document.select("a[href]");

        //Count numbers of Links
        int i = 0;
        for (Element link: links) {
            i++;
        }
        return i;
    }

    public static String premierLien(String url) throws IOException {
        Document document =  Jsoup.connect(url).get();
        Elements links = document.select("a[href]");
        return String.valueOf(links.get(0));
    }

}
