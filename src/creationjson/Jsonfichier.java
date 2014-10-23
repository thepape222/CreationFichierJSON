package creationjson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Jsonfichier {

    private String permis;
    private String date;
    private int heureCyclePre;
    private ArrayList<Activite> list;
    private JSONObject formation;

    public Jsonfichier(String permis, String date, int heureCyclePre, ArrayList<Activite> list) throws IOException {
        this.permis = permis;
        this.date = date;
        this.heureCyclePre = heureCyclePre;
        this.list = list;
        ecrirefichierArchitect();
        saveAsIndentedJsonFile1(formation);
    }
    public Jsonfichier(String permis, String date, ArrayList<Activite> list, int a) throws IOException {
        this.permis = permis;
        this.date = date;
        this.heureCyclePre = heureCyclePre;
        this.list = list;
        ecrirefichierPsychologues();
        saveAsIndentedJsonFile2(formation);
    }
    public Jsonfichier(String permis, String date, ArrayList<Activite> list) throws IOException {
        this.permis = permis;
        this.date = date;
        this.list = list;
        ecrirefichierGeologue();
        saveAsIndentedJsonFile3(formation);
    }
    
    private void ecrirefichierArchitect() {
        formation = new JSONObject();
        formation.accumulate("numero_de_permis", permis);
        formation.accumulate("cycle", date);
        formation.accumulate("heures_transferees_du_cycle_precedent", heureCyclePre);
        JSONArray activite = new JSONArray();

        for (int i = 0; i < list.size(); i++) {
            JSONObject subjson = new JSONObject();
            subjson.accumulate("description", list.get(i).getDescription());
            subjson.accumulate("categorie", list.get(i).getCategorie());
            subjson.accumulate("heures", list.get(i).getHeures());
            subjson.accumulate("date", list.get(i).getDate());
            activite.add(subjson);
        }

        formation.accumulate("activites", activite);
    }
    private void ecrirefichierPsychologues() {
        formation = new JSONObject();
        formation.accumulate("numero_de_permis", permis);
        formation.accumulate("cycle", date);
        JSONArray activite = new JSONArray();

        for (int i = 0; i < list.size(); i++) {
            JSONObject subjson = new JSONObject();
            subjson.accumulate("description", list.get(i).getDescription());
            subjson.accumulate("categorie", list.get(i).getCategorie());
            subjson.accumulate("heures", list.get(i).getHeures());
            subjson.accumulate("date", list.get(i).getDate());
            activite.add(subjson);
        }

        formation.accumulate("activites", activite);
    }
    private void ecrirefichierGeologue() {
        formation = new JSONObject();
        formation.accumulate("numero_de_permis", permis);
        formation.accumulate("cycle", date);
        JSONArray activite = new JSONArray();

        for (int i = 0; i < list.size(); i++) {
            JSONObject subjson = new JSONObject();
            subjson.accumulate("description", list.get(i).getDescription());
            subjson.accumulate("categorie", list.get(i).getCategorie());
            subjson.accumulate("heures", list.get(i).getHeures());
            subjson.accumulate("date", list.get(i).getDate());
            activite.add(subjson);
        }

        formation.accumulate("activites", activite);
    }

    private static void saveAsIndentedJsonFile1(JSONObject outputList) throws IOException {
        FileWriter pretty = new FileWriter("archi.json");
        pretty.write(outputList.toString(2));
        pretty.close();
    }
    private static void saveAsIndentedJsonFile2(JSONObject outputList) throws IOException {
        FileWriter pretty = new FileWriter("psycho.json");
        pretty.write(outputList.toString(2));
        pretty.close();
    }
    private static void saveAsIndentedJsonFile3(JSONObject outputList) throws IOException {
        FileWriter pretty = new FileWriter("geo.json");
        pretty.write(outputList.toString(2));
        pretty.close();
    }

}
