
package b_Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    Currency SEK;
    Currency DKK;
    Bank Nordea;
    Bank DanskeBank;
    Bank SweBank;
    Account testAccount;

    public AccountTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.SEK = new Currency("SEK", 0.15D);
        this.SweBank = new Bank("SweBank", this.SEK);
        this.SweBank.openAccount("Alice");
        this.testAccount = new Account("Hans", this.SEK);
        this.testAccount.deposit(new Money(10000000, this.SEK));
        this.SweBank.deposit("Alice", new Money(1000000, this.SEK));
    }

    @Test
    public void testAddRemoveTimedPayment() {
        this.testAccount.addTimedPayment("1", 10, 10, new Money(50000, this.SEK), this.SweBank, "Alice");
        Assert.assertTrue(this.testAccount.timedPaymentExists("1"));
        this.testAccount.removeTimedPayment("1");
        Assert.assertFalse(this.testAccount.timedPaymentExists("1"));
    }

    @Test
    public void testTimedPayment() throws AccountDoesNotExistException {
        this.testAccount.addTimedPayment("1", 3, 0, new Money(10000, this.SEK), this.SweBank, "Alice");
        Assert.assertTrue(this.testAccount.timedPaymentExists("1"));
        Assert.assertEquals("Before tick1:", 10000000, this.testAccount.getBalance().getAmount());
        this.testAccount.tick();
        Assert.assertEquals("after tick1:", 9990000, this.testAccount.getBalance().getAmount());
        this.testAccount.tick();
        Assert.assertEquals("After tick2:", 9990000, this.testAccount.getBalance().getAmount());
        this.testAccount.tick();
        Assert.assertEquals("After tick3:", 9990000, this.testAccount.getBalance().getAmount());
        this.testAccount.tick();
        Assert.assertEquals("After tick4:", 9990000, this.testAccount.getBalance().getAmount());
        this.testAccount.tick();
        Assert.assertEquals("After tick5:", 9980000, this.testAccount.getBalance().getAmount());
        this.testAccount.tick();
    }

    @Test
    public void testAddWithdraw() {
        this.testAccount.withdraw(new Money(500000, this.SEK));
        Assert.assertEquals("Test: withdraw ", 9500000, this.testAccount.getBalance().getAmount());
    }

    @Test
    public void testGetBalance() {
        Assert.assertEquals("Test get Balance", 10000000, this.testAccount.getBalance().getAmount());
    }
}
