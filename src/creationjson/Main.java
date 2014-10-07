package creationjson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ArrayList<Activite> list = new ArrayList<Activite>();
        Activite act1 = new Activite("Cours sur la déontologie", "cours", 14, "2013-03-20");  
        Activite act2 = new Activite("Séminaire sur l'architecture contemporaine", "séminaire", 10, "2014-01-07");  
        Activite act3 = new Activite("Rédaction pour le magazine Architecture moderne", "rédaction professionnelle", 6, "2012-10-22");
        Activite act4 = new Activite("Participation à un groupe de discussion sur le partage des projets architecturaux de plus de 20 ans", "groupe de discussion", 6, "2013-04-01");
        Activite act5 = new Activite("Visite d'établissements architecturaux", "voyage", 2, "2014-02-02");
    
        list.add(act1);
        list.add(act2);
        list.add(act3);
        list.add(act4);
        list.add(act5);
        try {
            Jsonfichier fichier = new Jsonfichier("A0001", "2012-2014", 2, list);
        } catch (IOException ex) {
            System.out.println("erreur dans le fichier");
        }
    }

}
