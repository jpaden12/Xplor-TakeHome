import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Wallet {

  private List<Card> cards;
  private String name;

  /**
   * Wallet constructor with no parameters
   * Initializes the wallet with an empty list of cards
   */
  public Wallet() {
    cards = new ArrayList<>();
  }

  /**
   * Wallet constructor with a name and list of cards
   * @param name The name of the wallet
   * @param cards A list of cards to initialize the wallet with
   */
  public Wallet(String name, List<Card> cards) {
    this.cards = cards;
    this.name = name;
  }

  /**
   * Method to calculate the owed interest for a particular wallet
   * @return The calculated interest for a given wallet.
   */
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

  /**
   * Method to remove a card from a wallet. Throws exception if the
   * card is not present or if the wallet is empty.
   * @param c Card to remove from the wallet
   */
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
