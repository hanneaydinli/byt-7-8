
package b_Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    Currency SEK;
    Currency DKK;
    Currency NOK;
    Currency EUR;
    Money SEK100;
    Money EUR10;
    Money SEK200;
    Money EUR20;
    Money SEK0;
    Money EUR0;
    Money SEKn100;

    public MoneyTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.SEK = new Currency("SEK", 0.15D);
        this.DKK = new Currency("DKK", 0.2D);
        this.EUR = new Currency("EUR", 1.5D);
        this.SEK100 = new Money(10000, this.SEK);
        this.EUR10 = new Money(1000, this.EUR);
        this.SEK200 = new Money(20000, this.SEK);
        this.EUR20 = new Money(2000, this.EUR);
        this.SEK0 = new Money(0, this.SEK);
        this.EUR0 = new Money(0, this.EUR);
        this.SEKn100 = new Money(-10000, this.SEK);
    }

    @Test
    public void testGetAmount() {
        Assert.assertEquals("Test: get amount: ", 10000, this.SEK100.getAmount());
        Assert.assertEquals("Test: get amount: ", 20000, this.SEK200.getAmount());
        Assert.assertEquals("Test: get amount: ", 0, this.SEK0.getAmount());
        Assert.assertEquals("Test: get amount: ", 1000, this.EUR10.getAmount());
        Assert.assertEquals("Test: get amount: ", 2000, this.EUR20.getAmount());
    }

    @Test
    public void testGetCurrency() {
        Assert.assertEquals("Test: get currency: ", this.SEK, this.SEK100.getCurrency());
        Assert.assertEquals("Test: get currency: ", this.SEK, this.SEK0.getCurrency());
        Assert.assertEquals("Test: get currency: ", this.EUR, this.EUR10.getCurrency());
        Assert.assertEquals("Test: get currency: ", this.EUR, this.EUR20.getCurrency());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("Test: Convert to String", "100.00 SEK", this.SEK100.toString());
        Assert.assertEquals("Test: Convert to String", "200.00 SEK", this.SEK200.toString());
        Assert.assertEquals("Test: Convert to String", "0.00 SEK", this.SEK0.toString());
        Assert.assertEquals("Test: Convert to String", "10.00 EUR", this.EUR10.toString());
        Assert.assertEquals("Test: Convert to String", "20.00 EUR", this.EUR20.toString());
        Assert.assertEquals("Test: Convert to String", "0.00 EUR", this.EUR0.toString());
    }

    @Test
    public void testGlobalValue() {
        Assert.assertEquals("Test Universal  value of SEK100:", 1500, this.SEK100.universalValue());
        Assert.assertEquals("Test Universal  value of SEK200:", 3000, this.SEK200.universalValue());
        Assert.assertEquals("Test Universal  value of SEK0:", 0, this.SEK0.universalValue());
        Assert.assertEquals("Test Universal  value of EUR10:", 1500, this.EUR10.universalValue());
        Assert.assertEquals("Test Universal  value of EUR20:", 3000, this.EUR20.universalValue());
        Assert.assertEquals("Test Universal  value of EUR0:", 0, this.EUR0.universalValue());
    }

    @Test
    public void testEqualsMoney() {
        Assert.assertTrue("value in EUR10 equals to value in SEK100", this.EUR10.equals(this.SEK100));
        Assert.assertFalse("value in EUR10 doesn't equal to value in SEK0", this.EUR10.equals(this.SEK0));
    }

    @Test
    public void testAdd() {
        Assert.assertEquals("SEK100+SEK200", "300.00 SEK", this.SEK100.add(this.SEK200).toString());
        Assert.assertEquals("SEK100+EUR10", "400.00 SEK", this.SEK100.add(this.EUR10).toString());
        Assert.assertEquals("SEK200+EUR20", "400.00 SEK", this.SEK200.add(this.EUR20).toString());
        Assert.assertEquals("SEK200+EUR10", "500.00 SEK", this.SEK200.add(this.EUR10).toString());
        Assert.assertEquals("EUR10+EUR10", "20.00 EUR", this.EUR10.add(this.EUR10).toString());
        Assert.assertEquals("EUR10+SEK100", "60.00 EUR", this.EUR10.add(this.SEK100).toString());
        Assert.assertEquals("EUR20+SEK100", "60.00 EUR", this.EUR20.add(this.SEK100).toString());
        Assert.assertEquals("EUR20+SEK200", "110.00 EUR", this.EUR20.add(this.SEK200).toString());
    }

    @Test
    public void testSub() {
        Assert.assertEquals("SEK200-SEK100", "100.00 SEK", this.SEK200.sub(this.SEK100).toString());
        Assert.assertEquals("SEK100-EUR10", "0.00 SEK", this.SEK100.sub(this.EUR10).toString());
        Assert.assertEquals("SEK100-EUR20", "-200.00 SEK", this.SEK100.sub(this.EUR20).toString());
        Assert.assertEquals("SEK100-EUR20", "-400.00 SEK", this.SEK100.sub(this.EUR20).toString());
        Assert.assertEquals("EUR20-EUR10", "10.00 EUR", this.EUR20.sub(this.EUR10).toString());
        Assert.assertEquals("EUR20-SEK100", "50.00 EUR", this.EUR20.sub(this.SEK100).toString());
    }

    @Test
    public void testIsZero() {
        Assert.assertTrue("the amount is 0", this.SEK0.isZero());
        Assert.assertTrue("the amount is 0", this.EUR0.isZero());
        Assert.assertFalse("the amount isn't 0", this.SEK100.isZero());
    }

    @Test
    public void testNegate() {
        Assert.assertEquals("Negate SEK100", "-100.00 SEK", this.SEK100.negate().toString());
        Assert.assertEquals("Negate SEKn100", "100.00 SEK", this.SEKn100.negate().toString());
    }

    @Test
    public void testCompareTo() {
        Assert.assertEquals("equal value:", 0L, (long)this.SEK100.compareTo(this.EUR10));
        Assert.assertEquals("SEK100 less than EUR20 :", -1L, (long)this.SEK100.compareTo(this.EUR20));
        Assert.assertEquals("SEK200 more than SEK100:", 1L, (long)this.SEK200.compareTo(this.SEK100));
    }
}
