
package b_Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
    Currency SEK;
    Currency DKK;
    Bank SweBank;
    Bank Nordea;
    Bank DanskeBank;

    public BankTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.DKK = new Currency("DKK", 0.2D);
        this.SEK = new Currency("SEK", 0.15D);
        this.SweBank = new Bank("SweBank", this.SEK);
        this.Nordea = new Bank("Nordea", this.SEK);
        this.DanskeBank = new Bank("DanskeBank", this.DKK);
        this.SweBank.openAccount("Ulrika");
        this.SweBank.openAccount("Bob");
        this.Nordea.openAccount("Bob");
        this.DanskeBank.openAccount("Gertrud");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Test  get name: ", "SweBank", this.SweBank.getName());
        Assert.assertEquals("Test  get name: ", "Nordea", this.Nordea.getName());
        Assert.assertEquals("Test  get name: ", "DanskeBank", this.DanskeBank.getName());
    }

    @Test
    public void testGetCurrency() {
        Assert.assertEquals("Test  get currency: ", this.SEK, this.SweBank.getCurrency());
        Assert.assertEquals("Test  get currency: ", this.SEK, this.Nordea.getCurrency());
        Assert.assertEquals("Test  get currency: ", this.DKK, this.DanskeBank.getCurrency());
    }

    @Test(
        expected = AccountExistsException.class
    )
    public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
        this.SweBank.openAccount("new");
        this.SweBank.openAccount("new");
    }

    @Test
    public void testDeposit() throws AccountDoesNotExistException {
        this.SweBank.deposit("Bob", new Money(10000, this.SEK));
        this.SweBank.deposit("Bob", new Money(100000, this.SEK));
        Assert.assertEquals("Test: adding Deposit", 110000, this.SweBank.getBalance("Bob"));
    }

    @Test
    public void testWithdraw() throws AccountDoesNotExistException {
        this.SweBank.deposit("Bob", new Money(100000, this.SEK));
        this.SweBank.withdraw("Bob", new Money(50000, this.SEK));
        Assert.assertEquals("Test: withdraw money", 50000, this.SweBank.getBalance("Bob"));
    }

    @Test
    public void testGetBalance() throws AccountDoesNotExistException {
        Assert.assertEquals("Test get Balance: ", 0, this.SweBank.getBalance("Bob"));
        Assert.assertEquals("Test get Balance: ", 0, this.SweBank.getBalance("Ulrika"));
    }

    @Test
    public void testTransfer() throws AccountDoesNotExistException {
        this.SweBank.deposit("Bob", new Money(10000, this.SEK));
        this.SweBank.transfer("Bob", this.Nordea, "Bob", new Money(5000, this.SEK));
        Assert.assertEquals("Test: Transfer from SweBank to Nordea bank: ", 5000, this.Nordea.getBalance("Bob"));
        Assert.assertEquals("Test: Transfer from SweBank to Nordea bank: ", 5000, this.SweBank.getBalance("Bob"));
        this.SweBank.transfer("Bob", "Ulrika", new Money(5000, this.SEK));
        Assert.assertEquals("Test: transfer  to another  account:", 5000, this.SweBank.getBalance("Ulrika"));
        Assert.assertEquals(0, this.SweBank.getBalance("Bob"));
    }

    @Test
    public void testTimedPayment() throws AccountDoesNotExistException {
        this.SweBank.deposit("Bob", new Money(100000, this.SEK));
        this.SweBank.addTimedPayment("Bob", "1", 3, 0, new Money(1000, this.SEK), this.SweBank, "Ulrika");
        Assert.assertEquals("Before tick1:", 100000, this.SweBank.getBalance("Bob"));
        Assert.assertEquals("Before tick1:", 0, this.SweBank.getBalance("Ulrika"));
        this.SweBank.tick();
        Assert.assertEquals("After tick1:", 99000, this.SweBank.getBalance("Bob"));
        Assert.assertEquals("After tick1:", 1000, this.SweBank.getBalance("Ulrika"));
        this.SweBank.tick();
        Assert.assertEquals("After tick2:", 99000, this.SweBank.getBalance("Bob"));
        Assert.assertEquals("After tick2:", 1000, this.SweBank.getBalance("Ulrika"));
        this.SweBank.tick();
        Assert.assertEquals("After tick3:", 99000, this.SweBank.getBalance("Bob"));
        Assert.assertEquals("After tick3", 1000, this.SweBank.getBalance("Ulrika"));
        this.SweBank.tick();
        Assert.assertEquals("After tick4:", 99000, this.SweBank.getBalance("Bob"));
        Assert.assertEquals("After tick4:", 1000, this.SweBank.getBalance("Ulrika"));
    }
}
