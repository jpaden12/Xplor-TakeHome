import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Person {

    private List<Wallet> wallets;

    public Person() {
        wallets = new ArrayList<>();
    }

    public Person(List<Wallet> wallets) {
      this.wallets = wallets;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void addWallet(Wallet wallet) {
        this.wallets.add(wallet);
    }

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

    public double interestPerPerson() {
        double calculatedInterest = 0;
        for (Wallet w: this.wallets) {
            calculatedInterest += w.interestPerWallet();
        }
        return calculatedInterest;
    }
  
}
