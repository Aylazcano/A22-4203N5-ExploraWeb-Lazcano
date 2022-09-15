package lazcano.explora;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.net.URL;

public class ExploraLazcano2022 {

    public static void main( String[] args )
    {
        //COMPLETED 01: Si l'utilisateur ne fournit pas 2 arguments, on lui indique clairement comment utiliser l'application puis l'application s'arrête.
        if(args.length < 2){

            System.out.println("Merci de nous fournir 2 arguments :\n" +
                    "l'URL de la page de départ, la liste de mots clés à ignorer séparés par des espaces entre guillemets.\n" +
                    "Par exemple : https://info.cegepmontpetit.ca/3N5-Prog3/z/index.html \"bibop bobip\"");
        }

        //COMPLETED 02: Si l'utilisateur a bien entré 2 arguments, il faut valider l'URL avant de commencer le traitement. Il faut afficher un message significatif si l'URL est mal formé puis quitter.
        else{
            try{
                URL u = new URL(args[0]); //Verifie le protocol
            }
            catch(Exception e){
                System.out.println("Nous avons rencontré un problème avec l'URL fournie : htps:/info.cegepmontpetit.ca/\n" +
                        "Merci de fournir une URL bien formée");
                return;
            }

            //COMPLETED 03: Si l'URL est correctement formée, il faut s'assurer qu'il existe une page à l'adresse fournie. Si ce n'est pas le cas, affichez un message puis quitter.
            try{
                Document docUrl = Jsoup.connect(args[0]).get();
            }
            catch (HTTPException e){
            } catch (IOException e) {
                System.out.println("Il n'y a pas de page correspondante à l'URL : https://info.cegepmontptit.ca/\n" +
                        "Merci de fournir une URL correspondant à une page.");
                return;
            }

            //COMPLETED 04: Si l'argument URL est correct, il faut s'assurer que la liste de mots clés est correcte. Nous validons qu'elle ne contient pas de répétitions.
            String[] mots = args[1].split(" ");
            int i = 1;
            for (String mot : mots) {
                if (mot == mots[i]){
                    System.out.println("Mots clés fournis incorrects \"" + args[1] + "\".\n" +
                            "Merci de ne pas avoir de répétitions dans les mots clés : " + mot);
                    return;
                }
            }
        }

    }
}
