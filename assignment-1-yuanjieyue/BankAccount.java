/**
 * Represents an Account with its holder's name and account balance
 *
 * @author yuanjie yue
 */
public class BankAccount {
    private Person holder;
    private Amount balance;

    /**
     * Create a new account given its holder as person and its account balance as balance
     *
     * @param holder the holder of the account
     * @param balance the account balance of the account
     */
    public BankAccount(Person holder, Amount balance){
        this.holder = holder;
        this.balance = balance;
    }

    /**
     * @return the holder
     */
    public Person getHolder(){
        return this.holder;
    }

    /**
     * @return the account balance
     */
    public Amount getBalance(){
        return this.balance;
    }

    /**
     * @param deposit the amount that to be deposited in the account
     * @return the balance after deposit
     */
    public Amount balanceAfterDeposit(Amount deposit){
        Integer newCents = this.balance.getCents() + deposit.getCents();
        Integer incrementOnDollars = newCents >= 100 ? 1 : 0;
        newCents = newCents >= 100 ? newCents - 100 : newCents;

        Integer newDollars = this.balance.getDollars() + deposit.getDollars() + incrementOnDollars;

        return new Amount(newDollars, newCents);
    }

    /**
     * @param withdraw the amount that to be withdrawn from the account
     * @return the balance after withdraw
     */
    public Amount balanceAfterWithdraw(Amount withdraw){
        Integer newCents = this.balance.getCents() - withdraw.getCents();
        Integer decrementOnDollars = newCents < 0 ? 1 : 0;
        newCents = newCents < 0 ? newCents + 100 : newCents;

        Integer newDollars = this.balance.getDollars() - withdraw.getDollars() - decrementOnDollars;

        return new Amount(newDollars, newCents);
    }
}
