package org.example;



import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

public class Compte {
    private int numCompte;
    private double device;
    private transient Client client;
    private transient Banque banque;

    private transient Set<Transaction> transactions;





    public Compte(int numCompte, double device, Client client, Banque banque) {
        this.numCompte = numCompte;
        this.device = device;
        this.client = client;
        this.banque = banque;
        this.transactions = new HashSet<>();
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public double getDevice() {
        return device;
    }

    public void setDevice(double device) {
        this.device = device;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
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
