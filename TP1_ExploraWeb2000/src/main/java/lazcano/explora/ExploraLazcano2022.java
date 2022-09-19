package lazcano.explora;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.net.URL;

public class ExploraLazcano2022 {

    public static void main( String[] args ) throws IOException {
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

        //COMPLETED 05: Si les arguments sont corrects, il faut alors commencer l'exploration de la première page. Tu dois afficher dans la console le titre (title) de la page et l'URL complète.
        System.out.println("Titre : " + JsoupGet.titreDeLaPage(args[0]) + "URL : " + args[0] + " Liens " + JsoupGet.nbrDeLiens(args[0]));
//
        //TODO 06: L'exploration devrait continuer en explorant le premier lien de chaque page. L'exploration s'arrête si une page ne contient aucun lien.

        //TODO 07: L'exploration ignore un lien s'il n'est pas valide.

        //TODO 08: On veut pouvoir contrôler l'exploration en forçant notre application à ignorer certains liens.
        // Si le premier lien d'une page a une URL qui contient un des mots clés passés en argument, on veut sauter ce lien et passer au suivant jusqu'à trouver un lien ne contenant aucun des mots clés.
        // Si l'URL pointe vers la page actuelle (URL interne), on devrait ignorer le lien et passer au suivant.

        //TODO 09: Afin d'éviter des boucles infinies, l'exploration doit s'arrêter si le programme rencontre une URL déjà explorée. Il faut afficher un message significatif.

        //TODO 10: Chaque page html explorée doit être stockée dans un fichier avec le même nom que la resource explorée (index.html, 1.html etc.).

        //TODO 11: Chaque apparition d'une adresse courriel dans le contenu d'une page doit être remplacée par prenom.nom@pipo.org avant l'écriture sur le disque.

        //TODO 12: Les liens relatifs entre pages téléchargées doivent être fonctionnels et doivent pointer vers les fichiers locaux si 2 pages sont dans le même dossier.

        //TODO 13: Les liens relatifs doivent fonctionner entre resources locales dans des dossiers différents.

        //TODO 14: Le programme collecte les adresses courriels valides contenues dans chaque page pendant l'exploration. L'application doit sauvegarder la liste des courriels en minuscule dans un fichier dossier_du_projet/resultat/courriels.txt

        //TODO 15: Dans ce fichier, tu dois avoir chaque courriel sur une ligne séparée, classés dans l'ordre alphabétique. Si un courriel a été trouvé plusieurs fois dans l'exploration, tu dois supprimer les doublons.

    }



}
