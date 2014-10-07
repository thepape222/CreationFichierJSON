
package creationjson;


class Activite {
private String description;
private String categorie;
private int heures;
private String date;

    public Activite(String description, String categorie, int heures, String date) {
        this.description = description;
        this.categorie = categorie;
        this.heures = heures;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getHeures() {
        return heures;
    }

    public String getDate() {
        return date;
    }

    
}
