import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
public class PersonTest {

    private Person person1;
    private Person person2;
    private Wallet wallet1, wallet2;
    private Card visa, masterCard, discover;

    @Before
    public void setUp() {
        this.person1 = new Person();
        this.person2 = new Person();
        this.wallet1 = new Wallet();
        this.wallet2 = new Wallet();
        this.visa = new Card("Visa", 0.1, 100.0);
        this.masterCard = new Card("Mastercard", 0.05, 100.0);
        this.discover = new Card("Discover", 0.01, 100.0);
    }

    @Test
    public void testScenario1() {

        wallet1.addToWallet(visa);
        wallet1.addToWallet(masterCard);
        wallet1.addToWallet(discover);
        person1.addWallet(wallet1);

       assertEquals(10.0, visa.calculateInterest(), 0.001);
       assertEquals(5.0, masterCard.calculateInterest(), 0.001);
       assertEquals(1.0, discover.calculateInterest(), 0.001);

       assertEquals(16.0, person1.interestPerPerson(), 0.001);
    }

    @Test
    public void testScenario2() {
        wallet2.addToWallet(masterCard);
        wallet1.addToWallet(visa);
        wallet1.addToWallet(discover);
        person1.addWallet(wallet1);
        person1.addWallet(wallet2);

        assertEquals(5.0, wallet2.interestPerWallet(), 0.001);
        assertEquals(11.0, wallet1.interestPerWallet(), 0.001);
        assertEquals(16.0, person1.interestPerPerson(), 0.001);
    }

    @Test
    public void testScenario3() {
        person1.addWallet(wallet1);
        wallet1.addToWallet(masterCard);
        wallet1.addToWallet(visa);

        person2.addWallet(wallet2);
        wallet2.addToWallet(visa);
        wallet2.addToWallet(masterCard);

        assertEquals(15.0, person1.interestPerPerson(), 0.001);
        assertEquals(15.0, wallet1.interestPerWallet(), 0.001);

        assertEquals(15.0, person2.interestPerPerson(), 0.001);
        assertEquals(15.0, wallet2.interestPerWallet(), 0.001);
        assertEquals(person1.interestPerPerson(), person2.interestPerPerson(), 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromWallet() {
        wallet1.addToWallet(discover);
        wallet1.removeFromWallet(visa);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveWalletFromPerson() {
        wallet1.addToWallet(discover);
        person1.addWallet(wallet1);
        person1.removeWallet(wallet2);
    }

}