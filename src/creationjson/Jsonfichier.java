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
        ecrirefichier();
        saveAsIndentedJsonFile(formation);
    }
    
    private void ecrirefichier() {
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

    private static void saveAsIndentedJsonFile(JSONObject outputList) throws IOException {
        FileWriter pretty = new FileWriter("json/output-pretty.json");
        pretty.write(outputList.toString(2));
        pretty.close();
    }

}
