package org.example;



import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class Compte {
    private int numCompte;
    private String device;
    private transient Client client;
    private transient Banque banque;

    private transient Set<Transaction> transactions;





    public Compte(int numCompte, String device, Client client, Banque banque) {
        this.numCompte = numCompte;
        this.device = device;
        this.client = client;
        this.banque = banque;
        this.transactions = new HashSet<>();
    }
    public Transaction RechercherTransaction(int reference) {
        for (Transaction transaction : transactions) {
            if (transaction.getReference() == reference) {
                return transaction;
            }
        }
        return null;

    }




    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.addCompte(this);  // Add this compte to the transaction
    }
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Convert JSON to Transaction
    public static Transaction fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Transaction.class);
    }
}
