package org.example;



import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int numClient;
    private String name;
    private String prenom;
    private String address;
    private String phone;
    private String email;

    private transient List<Compte> comptes;



    public Client(
            int numClient,
            String name,
            String prenom,
            String address,
            String phone,
            String email
    ) {
        this.numClient = numClient;
        this.name = name;
        this.prenom = prenom;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.comptes = new ArrayList<>();
    }

    // Getters and Setters
    public int getNumClient() {
        return numClient;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    // Add a compte to the client
    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.setClient(this);  // Set the back-reference in Compte
    }
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Convert JSON to Client
    public static Client fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Client.class);
    }
}
