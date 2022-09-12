package lazcano.explora;

public class ExploraLazcano2022 {

    public static void main( String[] args )
    {
        if(args.length < 2){
            System.out.println("Merci de nous fournir 2 arguments :\n" +
                    "l'URL de la page de départ, la liste de mots clés à ignorer séparés par des espaces entre guillemets.\n" +
                    "Par exemple : https://info.cegepmontpetit.ca/3N5-Prog3/z/index.html \"bibop bobip\"");
            return;
        }
        else{
            try{

            }
            catch(Exception e){
                System.out.println("Nous avons rencontré un problème avec l'URL fournie : htps:/info.cegepmontpetit.ca/\n" +
                        "Merci de fournir une URL bien formée");
            }

        }
    }
}
