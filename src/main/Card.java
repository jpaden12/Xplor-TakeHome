
public class Card {
    private String name;
    private double interestRate;
    private double balance;

    public Card(String name, double interestRate) {
        this.interestRate = interestRate;
        this.name = name;
    }

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

    public double calculateInterest() {
        return this.balance * this.interestRate;
    }
}
