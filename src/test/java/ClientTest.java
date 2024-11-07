import org.example.Banque;
import org.example.Client;
import org.example.Compte;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {
    @Test
    public void test() {
        Client client1 = new Client(1, "John", "Doe", "123 Main St", "555-1234", "john.doe@example.com");

        // Create a Banque object and add accounts
        Banque bank = new Banque(23, "dortmund");
        Compte compte1 = new Compte(1001, 550.0, client1, bank);

        bank.addCompte(compte1);
        client1.addCompte(compte1);

        String clientToJson = client1.toJson();

        // Use properly escaped JSON string
        String expectedJson = "{\"numClient\":1,\"name\":\"John\",\"prenom\":\"Doe\",\"address\":\"123 Main St\",\"phone\":\"555-1234\",\"email\":\"john.doe@example.com\",\"comptes\":[{\"accountNumber\":1001,\"balance\":550.0}]}";

        Assert.assertEquals(expectedJson, clientToJson);
    }
}

