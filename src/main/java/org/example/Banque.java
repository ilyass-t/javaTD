package org.example;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Banque {
    private int id;
    private String pays;
    private transient List<Compte> comptes;
    public Banque() {
        this.id = 0;  // Default value
        this.pays = "";
        this.comptes = new ArrayList<>();
    }
    public Banque(int id, String pays) {
        this.id = id;
        this.pays = pays;
        this.comptes = new ArrayList<>();
    }



    // Add a compte to the banque
    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.setBanque(this);  // Establish the back-reference to this Banque
    }
    public Compte RechercheCompte(Client client) {
        for (Compte compte : comptes) {
            if (compte.getClient() == client) {
                return compte;
            }
        }
        return null;
    }
    public Client RechercheClient(Compte compte) {
        for (Compte compte1 : comptes) {
            if (compte1.equals(compte)) {
                return compte.getClient();
            }
        }
        return null;
    }


    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Convert JSON to Banque
    public static Banque fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Banque.class);
    }
}
