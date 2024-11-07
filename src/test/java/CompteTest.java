import org.example.Banque;
import org.example.Client;
import org.example.Compte;
import org.example.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class CompteTest {
    @Test

    public void test() {
        Client client1 = new Client(1, "John", "Doe", "123 Main St", "555-1234", "john.doe@example.com");
        Client client2 = new Client(2, "Smith", "Wili", "124 Main St", "555-1233", "Smith.wili@example.com");

        // Create a Banque object and add accounts
        Banque bank = new Banque(23, "dortmund");
        Compte compte1 = new Compte(1001, "eur", client1, bank);
        Compte compte2 = new Compte(1002, "eur", client2, bank);

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
        String comptetojson= compte1.toJson();
        Assert.assertEquals(comptetojson,"{\"numCompte\":1001,\"device\":550.0}");
    }
}
