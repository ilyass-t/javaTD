package org.example;
import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

public class Transaction {
    private final int reference;
    private final double amount;
    private final transient Set<Compte> comptes;
    private TransactionType transactionType;
    public enum TransactionType {
        VIRINI, VIREST, VIRMULTA, VIRCHAC;
    }

    public Transaction() {
        this.reference = 0;  // Default value
        this.amount = 0.0;   // Default value
        this.comptes = new HashSet<>();
    }


    public Transaction(int reference, double amount) {
        this.reference = reference;
        this.amount = amount;
        this.comptes = new HashSet<>();
        determineType();
    }

    public int getReference() {
        return reference;
    }

    public double getAmount() {
        return amount;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }




    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.getTransactions().add(this);


        determineType();
    }


    private void determineType() {
        if (comptes.size() != 2) {

            return;
        }

        Compte[] comptesArray = comptes.toArray(new Compte[0]);
        Compte compte1 = comptesArray[0];
        Compte compte2 = comptesArray[1];

        Client client1 = compte1.getClient();
        Client client2 = compte2.getClient();

        Banque banque1 = compte1.getBanque();
        Banque banque2 = compte2.getBanque();

        String pays1 = banque1.getPays();
        String pays2 = banque2.getPays();

        if (banque1.equals(banque2)) {
            // Same bank
            transactionType = TransactionType.VIRINI;  // Transaction between two clients of the same bank
        } else if (pays1.equals(pays2)) {
            // Different banks but same country
            transactionType = TransactionType.VIREST;  // Transaction between two clients of the same country but different banks
        } else if (!pays1.equals(pays2)) {
            // Different countries
            if (banque1.equals(banque2)) {
                transactionType = TransactionType.VIRMULTA;  // Same bank, but different countries
            } else {
                transactionType = TransactionType.VIRCHAC;  // Different countries, different banks
            }
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "reference=" + reference +
                ", amount=" + amount +
                ", type='" + transactionType + '\'' +
                ", comptes=" + comptes +
                '}';
    }
    // Convert Transaction to JSON
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
