import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Wallet {

  private List<Card> cards;
  private String name;

  public Wallet() {
    cards = new ArrayList<>();
  }

  public Wallet(String name, List<Card> cards) {
    this.cards = cards;
    this.name = name;
  }

  public double interestPerWallet() {
    double calculatedInterest = 0;
    for (Card c: cards) {
      calculatedInterest += (c.calculateInterest());
    }
    return calculatedInterest;
  }

  public void addToWallet(Card c) {
    cards.add(c);
  }

  public void removeFromWallet(Card c) {
    if (cards.isEmpty()) {
      throw new NoSuchElementException("The wallet is empty.");
    }
    if (cards.contains(c)) {
      cards.remove(c);
    } else {
      throw new NoSuchElementException("Card " + c.getName() + " was not found in the wallet.");
    }
  }

  public String getName() {
    return this.name;
  }
}
