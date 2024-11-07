package org.example;



import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
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
