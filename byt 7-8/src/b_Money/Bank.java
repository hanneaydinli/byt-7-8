
package b_Money;

import java.util.Hashtable;
import java.util.Iterator;

public class Bank {
    private Hashtable<String, Account> accountlist = new Hashtable();
    private String name;
    private Currency currency;

    Bank(String name, Currency currency) {
        this.name = name;
        this.currency = currency;
    }

    public String getName() {
        return this.name;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void openAccount(String accountid) throws AccountExistsException {
        if (this.accountlist.containsKey(accountid)) {
            throw new AccountExistsException();
        } else {
            this.accountlist.get(accountid);
            this.accountlist.put(accountid, new Account(accountid, this.currency));
        }
    }

    public void deposit(String accountid, Money money) throws AccountDoesNotExistException {
        if (!this.accountlist.containsKey(accountid)) {
            throw new AccountDoesNotExistException();
        } else {
            Account account = (Account)this.accountlist.get(accountid);
            account.deposit(money);
        }
    }

    public void withdraw(String accountid, Money money) throws AccountDoesNotExistException {
        if (!this.accountlist.containsKey(accountid)) {
            throw new AccountDoesNotExistException();
        } else {
            Account account = (Account)this.accountlist.get(accountid);
            account.withdraw(money);
        }
    }

    public Integer getBalance(String accountid) throws AccountDoesNotExistException {
        if (!this.accountlist.containsKey(accountid)) {
            throw new AccountDoesNotExistException();
        } else {
            return ((Account)this.accountlist.get(accountid)).getBalance().getAmount();
        }
    }

    public void transfer(String fromaccount, Bank tobank, String toaccount, Money amount) throws AccountDoesNotExistException {
        if (this.accountlist.containsKey(fromaccount) && tobank.accountlist.containsKey(toaccount)) {
            ((Account)this.accountlist.get(fromaccount)).withdraw(amount);
            ((Account)tobank.accountlist.get(toaccount)).deposit(amount);
        } else {
            throw new AccountDoesNotExistException();
        }
    }

    public void transfer(String fromaccount, String toaccount, Money amount) throws AccountDoesNotExistException {
        this.transfer(fromaccount, this, toaccount, amount);
    }

    public void addTimedPayment(String accountid, String payid, Integer interval, Integer next, Money amount, Bank tobank, String toaccount) {
        Account account = (Account)this.accountlist.get(accountid);
        account.addTimedPayment(payid, interval, next, amount, tobank, toaccount);
    }

    public void removeTimedPayment(String accountid, String id) {
        Account account = (Account)this.accountlist.get(accountid);
        account.removeTimedPayment(id);
    }

    public void tick() throws AccountDoesNotExistException {
        Iterator var1 = this.accountlist.values().iterator();

        while(var1.hasNext()) {
            Account account = (Account)var1.next();
            account.tick();
        }

    }
}

