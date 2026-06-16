import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Person {

    private List<Wallet> wallets;
    private String name;

    /**
     * Person constructor with no parameters
     * Initializes the person with a list of wallets
     * @param wallets List of wallets to initialize the person with
     */
    public Person(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    /**
     * Person constructor with a name and list of wallets
     * @param wallets List of wallets to initialize the person with
     * @param name Name to initialize the person with
     */
    public Person(List<Wallet> wallets, String name) {
      this.wallets = wallets;
      this.name = name;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void addWallet(Wallet wallet) {
        this.wallets.add(wallet);
    }

    /**
     * Method to remove a wallet from a person
     * @param wallet Wallet to remove from a person
     */
    public void removeWallet(Wallet wallet) {
        if (wallets.isEmpty()) {
            throw new NoSuchElementException("This person does not have any wallets.");
        }
        if (wallets.contains(wallet)) {
            wallets.remove(wallet);
        } else {
            throw new NoSuchElementException("This person does not have wallet " + wallet.getName()) ;
        }
    }

    /**
     * Method to calculate a person's owed interest in all of their wallets
     * @return Calculated interest for a person across all wallets
     */
    public double interestPerPerson() {
        double calculatedInterest = 0;
        for (Wallet w: this.wallets) {
            calculatedInterest += w.interestPerWallet();
        }
        return calculatedInterest;
    }
  
}
