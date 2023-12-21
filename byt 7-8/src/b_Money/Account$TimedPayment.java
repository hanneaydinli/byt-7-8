
package b_Money;

class Account$TimedPayment {
    private int interval;
    private int next;
    private Account fromaccount;
    private Money amount;
    private Bank tobank;
    private String toaccount;

    Account$TimedPayment(Account var1, Integer interval, Integer next, Money amount, Account fromaccount, Bank tobank, String toaccount) {
        this.this$0 = var1;
        this.interval = interval;
        this.next = next;
        this.amount = amount;
        this.fromaccount = fromaccount;
        this.tobank = tobank;
        this.toaccount = toaccount;
    }

    public Boolean tick() {
        if (this.next == 0) {
            this.next = this.interval;
            this.fromaccount.withdraw(this.amount);

            try {
                this.tobank.deposit(this.toaccount, this.amount);
            } catch (AccountDoesNotExistException var2) {
                this.fromaccount.deposit(this.amount);
            }

            return true;
        } else {
            --this.next;
            return false;
        }
    }
}
