package projetsession;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Main {

    public static void main(String[] args) throws IOException {
        Categorie categorie;
        String file = FileReader.loadFileIntoString("json/output-pretty.json", "UTF-8");
        JSONObject obj = JSONObject.fromObject(file);
        Test(obj);

    }

    private static void Test(JSONObject obj) {
        if (obj.getString("cycle").compareTo("2012-2014") != 0) {
            System.out.println("Le cycle n'est pas valide");
            System.exit(0);
        }
        JSONArray listeActivites = obj.getJSONArray("activites");
        JSONObject activites = (JSONObject) listeActivites.get(0);
        System.out.println(activites.getString("description"));

    }
}
