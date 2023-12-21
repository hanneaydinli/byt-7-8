
package b_Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
    Currency SEK;
    Currency DKK;
    Currency NOK;
    Currency EUR;

    public CurrencyTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.SEK = new Currency("SEK", 0.15D);
        this.DKK = new Currency("DKK", 0.2D);
        this.EUR = new Currency("EUR", 1.5D);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Test: currency_name: ", "SEK", this.SEK.getName());
        Assert.assertEquals("Test: currency_name: ", "DKK", this.DKK.getName());
        Assert.assertEquals("Test: currency_name: ", "EUR", this.EUR.getName());
    }

    @Test
    public void testGetRate() {
        Assert.assertEquals("Test: currency_rate of SEK: ", 0.15D, this.SEK.getRate());
        Assert.assertEquals("Test: currency_rate of DKK: ", 0.2D, this.DKK.getRate());
        Assert.assertEquals("Test: currency_rate of EUR: ", 1.5D, this.EUR.getRate());
    }

    @Test
    public void testSetRate() {
        this.SEK.setRate(0.3D);
        Assert.assertEquals("Test: set new currency_rate for SEK: ", 0.3D, this.SEK.getRate());
        this.DKK.setRate(0.1D);
        Assert.assertEquals("Test: set new currency_rate for DKK: ", 0.1D, this.DKK.getRate());
        this.EUR.setRate(0.2D);
        Assert.assertEquals("Test: set new currency_rate for EUR: ", 0.2D, this.EUR.getRate());
    }

    @Test
    public void testGlobalValue() {
        Assert.assertEquals("Test: convert SEK to its Universal Value: ", 15, this.SEK.universalValue(100));
        Assert.assertEquals("Test: convert DKK to its Universal Value: ", 20, this.DKK.universalValue(100));
        Assert.assertEquals("Test: convert EUR to its Universal Value: ", 150, this.EUR.universalValue(100));
    }

    @Test
    public void testValueInThisCurrency() {
        Assert.assertEquals("Test: convert EUR to SEK: ", 1000, this.SEK.valueInThisCurrency(100, this.EUR));
        Assert.assertEquals("Test: convert EUR to DKK: ", 750, this.DKK.valueInThisCurrency(100, this.EUR));
        Assert.assertEquals("Test: convert SEK to EUR: ", 10, this.EUR.valueInThisCurrency(100, this.SEK));
    }
}
