package org.example;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

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

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    // Add a compte to the banque
    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.setBanque(this);  // Establish the back-reference to this Banque
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", pays='" + pays + '\'' +
                '}';
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
