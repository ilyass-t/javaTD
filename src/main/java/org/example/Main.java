package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Client objects
        Client client1 = new Client(1, "John", "Doe", "123 Main St", "555-1234", "john.doe@example.com");
        Client client2 = new Client(2, "Smith", "Wili", "124 Main St", "555-1233", "Smith.wili@example.com");

        // Create a Banque object and add accounts
        Banque bank = new Banque(23, "dortmund");
        Compte compte1 = new Compte(1001, 550.0, client1, bank);
        Compte compte2 = new Compte(1002, 550.0, client2, bank);

        bank.addCompte(compte1);
        bank.addCompte(compte2);
        client1.addCompte(compte1);
        client2.addCompte(compte2);

        // Create a Transaction and associate with comptes
        Transaction transaction = new Transaction(222, 30);
        transaction.addCompte(compte1);
        transaction.addCompte(compte2);
        compte1.addTransaction(transaction);
        compte2.addTransaction(transaction);

        // JSON display for each object

        // Convert Client to JSON and display
        System.out.println("Client 1 JSON:");
        System.out.println(client1.toJson());

        System.out.println("\nClient 2 JSON:");
        System.out.println(client2.toJson());

        // Convert Banque to JSON and display
        System.out.println("\nBank JSON:");
        System.out.println(bank.toJson());

        // Convert Compte to JSON and display
        System.out.println("\nCompte 1 JSON:");
        System.out.println(compte1.toJson());

        System.out.println("\nCompte 2 JSON:");
        System.out.println(compte2.toJson());

        // Convert Transaction to JSON and display
        System.out.println("\nTransaction JSON:");
        System.out.println(transaction.toJson());
    }
}


