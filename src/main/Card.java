
public class Card {
    private String name;
    private double interestRate;
    private double balance;

    /**
     * Constructor to initialize a card with a name and interest rate
     * @param name Name of the card
     * @param interestRate Interest rate for the card
     */
    public Card(String name, double interestRate) {
        this.interestRate = interestRate;
        this.name = name;
    }

    /**
     * Constructor to initialize a card with a name, interest rate, and balance
     * @param name Name of the card
     * @param interestRate Interest rate for the card
     * @param balance Balance for the card
     */
    public Card(String name, double interestRate, double balance) {
        this.interestRate = interestRate;
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public String getName() {
        return this.name;
    }

    /**
     *  Method that calculates the amount of interest owed for a card
     * @return The calculated amount of interest for the card
     */
    public double calculateInterest() {
        return this.balance * this.interestRate;
    }
}
