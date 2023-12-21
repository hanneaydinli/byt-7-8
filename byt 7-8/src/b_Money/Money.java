
package b_Money;

import java.text.DecimalFormat;

public class Money implements Comparable {
    private int amount;
    private Currency currency;
    public static final DecimalFormat d = new DecimalFormat("0.00");

    Money(Integer amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public String toString() {
        double money = (double)(this.amount / 100);
        String res = d.format(money) + " " + this.currency.getName();
        return res;
    }

    public Integer universalValue() {
        return this.currency.universalValue(this.amount);
    }

    public Boolean equals(Money other) {
        return this.amount == this.currency.valueInThisCurrency(other.amount, other.currency);
    }

    public Money add(Money other) {
        this.amount += this.currency.valueInThisCurrency(other.getAmount(), other.currency);
        return new Money(this.amount, this.currency);
    }

    public Money sub(Money other) {
        this.amount -= this.currency.valueInThisCurrency(other.getAmount(), other.currency);
        return new Money(this.amount, this.currency);
    }

    public Boolean isZero() {
        return this.amount == 0;
    }

    public Money negate() {
        this.amount = -this.amount;
        return new Money(this.amount, this.currency);
    }

    public int compareTo(Object other) {
        return this.universalValue().compareTo(((Money)other).universalValue());
    }
}
